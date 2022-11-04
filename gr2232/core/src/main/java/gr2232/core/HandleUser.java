package gr2232.core;

/**
 * A class for handeling which user that uses the system.
 */
public class HandleUser implements HandleUserInterface {
  private static boolean isManager;
  private String username = "admin";
  private String password = "admin123";


  public HandleUser() {
    setIsManager(false);
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


  
}
