package util;

/**
 *
 * @author cuongnguyenba
 */
public class Helper {

    public static Boolean isCheckEmpty(String str) {
        return str.trim().isEmpty();
    }

    public static Boolean isCheckNumber(Double number) {
        return number > 0;
    }
}
