package gr2232;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UnitListFileSupport {

    private List<Unit> units;

    public UnitListFileSupport(List<Unit> entry) {
        this.units = entry;
    }
    
    /**
     * Iterates over all existing units, getting required unit-information, and writing a line containing the data.
     * @param filename
     */
    public void writeListToFile(String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            for (Unit units : units) {
                Integer location = units.getLocation();
                Character size = units.getSize();
                String name = units.getCustomerName();
                Boolean status = units.getIsRented();

                writer.println(location + "," + size + "," + name + "," + status);
            }
            writer.flush();
            writer.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Iterates over textfile, each line contains unit-information
     * @param filename
     * @retun unitList
     * @throws FileNotFoundException
     */
    public UnitList getListFromFile(String filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(filename));
        UnitList unitList = new UnitList();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineData = line.split(",");
            //Location, Size, Name, Status
            Integer location = Integer.parseInt(lineData[0]);
            Character size = lineData[1].charAt(0);
            System.out.println(lineData);
            String name = lineData[2];
            System.out.println(lineData[2]);
            Boolean status = Boolean.parseBoolean(lineData[3]);
            Unit u = new Unit(size,location);
            u.setCustomerName(name);
            u.setIsRented(status);
            unitList.addUnit(u);
        }
        scanner.close();
        return unitList;
    }
}