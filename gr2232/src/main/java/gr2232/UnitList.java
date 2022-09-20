package gr2232;

import java.util.ArrayList;
import java.util.List;

public class UnitList {
    
    //List of all units
    private List<Unit> unitList = new ArrayList<>();
    private Integer locationIncrementer = 0;
    public UnitList() {

    }

    public List<Unit> getUnitListEntries() {
        return this.unitList;
    }

    public Unit getUnitByLocation(Integer location) {
        for (var entry : getUnitListEntries()) {
            if (entry.getLocation().equals(location)) {
                return entry;
            }
        }
        return null;
    }


    //TODO: Encapsulate, valdiation
    //Creates and adds Unit to UnitList
    public void createUnit(char size) {
        Unit unitToAdd = new Unit(size,this.locationIncrementer);
        this.locationIncrementer = this.locationIncrementer++;
        getUnitListEntries().add(unitToAdd);
    }

    //Adds allready made Unit to UnitList
    //public void addUnit(Unit u) {
    //   getUnitListEntries().add(u);
    //}

    public void clearUnitList() {
        getUnitListEntries().clear();
    }

    public static void main(String args[]) {
        UnitList testList = new UnitList();
        testList.getUnitListEntries();
        testList.createUnit('L');
        testList.createUnit('M');
        System.out.println(testList.getUnitListEntries());
        System.out.println(testList.getUnitByLocation(0).getSize());

    }
}
