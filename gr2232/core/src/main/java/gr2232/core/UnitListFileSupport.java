package gr2232.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class UnitListFileSupport {

    private List<Unit> units;

    public UnitListFileSupport(List<Unit> entry) {
        this.units = entry;
    }
    
    /**
     * Uses GSON to turn all unitentries(List) into a jsonfile
     * @param filename
     * @throws IOException
     */
    public void writeListToFile(String filename) throws IOException {
        UnitList ul = new UnitList();
        String jsonFilename = filename + ".json";
        try (Writer writer = new FileWriter(jsonFilename)) {
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
     */
    public UnitList getListFromFile(String filename) throws FileNotFoundException{
        Gson gson = new Gson();
        String jsonFilename = filename + ".json";
        Type unitType = new TypeToken<List<Unit>>() {}.getType();
        JsonReader reader = new JsonReader(new FileReader(jsonFilename));
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
