package gr2232.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gr2232.core.Unit;

public class UnitTest {

    private Unit newUnit;

    @BeforeEach
    public void setUp() {
        newUnit = new Unit('S', 0);
    }

    @Test
    public void testSetSize() {
        newUnit.setSize('M');
        assertEquals(newUnit.getSize(), 'M');
        assertThrows(IllegalArgumentException.class, () -> newUnit.setSize('E'));
    }

    @Test
    public void testToggleIsRented() {
        newUnit.toggleIsRented();
        assertTrue(newUnit.getIsRented());
        newUnit.toggleIsRented();
        assertEquals("null", newUnit.getCustomerName());
    }

    @Test
    public void testSetIsRented() {
        newUnit.setIsRented(true);
        assertTrue(newUnit.getIsRented());
    }

    @Test
    public void testSetLocation() {
        newUnit.setLocation(2);
        assertEquals(2, newUnit.getLocation());
    }

    @Test
    public void testSetCustomerName() {
        newUnit.toggleIsRented();
        newUnit.setCustomerName("john doe");
        assertEquals("john doe", newUnit.getCustomerName());
    }

    @Test
    public void testSetUnitFree() {
        newUnit.toggleIsRented();
        newUnit.setCustomerName("john doe");
        newUnit.setUnitFree();
        assertEquals("null", newUnit.getCustomerName());
    }
    @Test 
    public void testRemoveTenantFromUnit(){
        assertThrows(IllegalArgumentException.class , () -> newUnit.removeTenantFromUnit());
        Unit a1 = new Unit('S', 4);
        a1.setCustomerName("Tom");
        a1.removeTenantFromUnit();
        assertTrue(a1.getCustomerName() == "null" && a1.getIsRented() == false);
    }
}
