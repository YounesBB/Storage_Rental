package gr2232.core;

/**
 * A class for handeling which user that uses the system.
 */
public class HandleUser {
  private static boolean isManager;

  public HandleUser() {

  }

  public static void setIsManager(boolean v) {
    isManager = v;
  }

  public static boolean getIsManager() {
    return isManager;
  }
}
