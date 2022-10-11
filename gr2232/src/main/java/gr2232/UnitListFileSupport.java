package gr2232;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

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
     */
    public void writeListToFile(String filename) {
        UnitList ul = new UnitList();
        Gson gson = new Gson();
        String test = gson.toJson(ul.getUnitListEntries());
        System.out.println(test);
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(test);
            writer.flush();
            writer.close();
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
        Type unitType = new TypeToken<List<Unit>>() {}.getType();
        JsonReader reader = new JsonReader(new FileReader(filename));
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
