package ua.mushroom.hospital.utils;

public class DBUtils {
    public static void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                //Here will be a log
            }
        }
    }
}
