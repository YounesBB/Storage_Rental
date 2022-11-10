package gr2232.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandleUserTest {

  private HandleUser user;

  @BeforeEach
  public void setUp() {
    HandleUser.setIsManager(false);
  }

  @Test
  public void testGetIsManager() {
    assertEquals(false, HandleUser.getIsManager());


  }


  @Test
  public void testSetIsManager() {
    HandleUser.setIsManager(true);
    assertTrue(HandleUser.getIsManager());
  }

  @Test
  public void testValidateWrongInput() {
    HandleUser test = new HandleUser();
    assertFalse(test.validateInputs("Test", "Test123"));
  }

  @Test
  public void testValidateCorrectInput() {
    HandleUser test = new HandleUser();
    assertTrue(test.validateInputs("admin", "admin123"));
  }

}
