package gr2232;

import java.util.ArrayList;
import java.util.List;

public class UnitList {
    
    //List of all units
    private List<Unit> unitList = new ArrayList<>();
    private Integer locationIncrementer = 0;
    public UnitList() {

    }

    public List<Unit> getRentedUnits() {
        List<Unit> rentedUnits = new ArrayList<>();
        for (var entry : getUnitListEntries()) {
            if (entry.getIsRented() == true) {
                rentedUnits.add(entry);
            }
        }
        return rentedUnits;
    }

    public List<Unit> getFreeUnits() {
        List<Unit> freeUnits = new ArrayList<>();
        for (var entry : getUnitListEntries()) {
            if (entry.getIsRented() == false) {
                freeUnits.add(entry);
            }
        }
        return freeUnits;
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
        //Empty list, no objects
        testList.getUnitListEntries();
        testList.createUnit('L');
        testList.createUnit('M');
        //List with two Unit objects
        System.out.println(testList.getUnitListEntries());

        //Add customer, sets unit to rented
        testList.getUnitByLocation(0).setCustomerName("Magnus Svendsen");
        System.out.println(testList.getUnitByLocation(0).getIsRented());
        System.out.println(testList.getUnitByLocation(0).getCustomerName());
        
        //Sets unit to free
        testList.getUnitByLocation(0).setUnitFree();
        System.out.println(testList.getUnitByLocation(0).getCustomerName());
        System.out.println(testList.getFreeUnits());
        System.out.println(testList.getRentedUnits());

        testList.clearUnitList();
        System.out.println(testList.getUnitListEntries());


    }
}
