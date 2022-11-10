package gr2232.core;

/**
 * A class for handeling which user that uses the system.
 */
public class HandleUser {
  private static boolean isManager;
  private static boolean usesRest;

  public HandleUser() {

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
