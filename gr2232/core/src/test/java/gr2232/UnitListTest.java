package gr2232;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gr2232.Unit;
import gr2232.UnitList;

public class UnitListTest{

    private UnitList newUnitList;

    @BeforeEach
    public void setUp(){
        newUnitList = new UnitList();
        newUnitList.getUnitListEntries().clear();
    }

    @Test
    public void testCreateUnit(){
        newUnitList.createUnit('S');
        System.out.println(newUnitList.getUnitListEntries().get(0));
        assertEquals(1, newUnitList.getUnitListEntries().size());
        assertThrows(IllegalArgumentException.class, () -> newUnitList.createUnit('E'));

    }

    @Test
    public void testAddUnit(){
        Unit unit = new Unit('S', 1);
        newUnitList.addUnit(unit);
        assertEquals(newUnitList.getUnitListEntries().size(), 1);
    }

    @Test
    public void testClearUnitList(){
        newUnitList.addUnit(new Unit('M', 1));
        newUnitList.addUnit(new Unit('S', 2));
        newUnitList.clearUnitList();
        assertFalse(newUnitList.getUnitListEntries().iterator().hasNext());
    }
}