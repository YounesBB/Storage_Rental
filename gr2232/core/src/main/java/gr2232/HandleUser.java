package gr2232;

public class HandleUser {
    protected static boolean isManager;

    public HandleUser() {

    }

    public static void setIsManager(boolean v) {
        isManager = v;
    }

    public static boolean getIsManager() {
        return isManager;
    }
}
