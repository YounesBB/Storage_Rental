package gr2232.core;

/**
 * A class for handeling which user that uses the system.
 */
public class HandleUser implements HandleUserInterface {
  protected static boolean isManager;
  private String username = "admin";
  private String password = "admin123";

  protected static boolean usesRest;

  public HandleUser() {
  }
  
  @Override
  public boolean validateInputs(String inputUsername, String inputPassword) {
    if((this.username.equals(inputUsername)) && (this.password.equals(inputPassword))) {
      return true;
    }
    return false;
  }

  public static void setIsManager(boolean v) {
    isManager = v;
  }

  public static boolean getIsManager() {
    return isManager;
  }

  public static void setUsesRest(boolean v) {
    usesRest = v;
  }

  public static boolean getUsesRest() {
    return usesRest;
  }
}
