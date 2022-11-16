package gr2232.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import gr2232.core.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

 /**
   * This class takes care of persistence in our system
   * 
   * @throws IOException
   */
public class UnitListFileSupport {

  private final String filename;

  public UnitListFileSupport(String filename) {
    this.filename = filename;


  }

  /**
   * Uses GSON to turn all unitentries(List) into a jsonfile
   * 
   * @throws IOException
   */
  public void writeListToFile() throws IOException {
    UnitList ul = new UnitList();
    String jsonFilename = this.filename + ".model.json";
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(jsonFilename), StandardCharsets.UTF_8));) {
      Gson gson = new GsonBuilder().create();
      gson.toJson(ul.getUnitListEntries(), writer);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Using GSON,Jsonreader and Filereader to read JSONfile and set UnitList to
   * read value
   * 
   * @retun unitList
   * @throws FileNotFoundException
   * @throws UnsupportedEncodingException
   */
  public UnitList getListFromFile() throws FileNotFoundException, UnsupportedEncodingException {
    Gson gson = new Gson();
    String jsonFilename = this.filename + ".model.json";
    FileInputStream stream = new FileInputStream(jsonFilename);
    Type unitType = new TypeToken<List<Unit>>() {
    }.getType();
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
    List<Unit> list = gson.fromJson(reader, unitType);
    UnitList ul = new UnitList();
    
    
    ul.getUnitListEntries().clear();
    ul.getUnitListEntries().addAll(list);
  
    return ul;
  }
}
