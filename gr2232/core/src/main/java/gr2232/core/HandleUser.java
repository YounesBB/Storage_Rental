package gr2232.core;

public class HandleUser {
    private static boolean isManager;

    public HandleUser() {

    }

    protected static void setIsManager(boolean v) {
        isManager = v;
    }

    protected static boolean getIsManager() {
        return isManager;
    }
}
