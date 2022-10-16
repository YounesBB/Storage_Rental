package gr2232.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UnitListFileSupport {

    /**
     * Uses GSON to turn all unitentries(List) into a jsonfile
     * @param filename
     * @throws IOException
     */
    public void writeListToFile(String filename) throws IOException {
        UnitList ul = new UnitList();
        String jsonFilename = filename + ".json";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(jsonFilename), StandardCharsets.UTF_8));) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(ul.getUnitListEntries(), writer);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Using GSON,Jsonreader and Filereader to read JSONfile and set UnitList to read value
     * @param filename
     * @retun unitList
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public UnitList getListFromFile(String filename) throws FileNotFoundException, UnsupportedEncodingException{
        Gson gson = new Gson();
        String jsonFilename = filename + ".json";
        FileInputStream stream = new FileInputStream(jsonFilename);
        Type unitType = new TypeToken<List<Unit>>() {}.getType();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        List<Unit> list = gson.fromJson(reader, unitType);
        UnitList ul = new UnitList();
        if (list.size() == 0) {
            throw new IllegalStateException("Corrupted file!");
        } else {
            ul.getUnitListEntries().clear();
            ul.getUnitListEntries().addAll(list);    
        };
        return ul;
    }
}
