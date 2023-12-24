import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String LPad(String str, Integer length, char car) {
        return String.format("%1$" + length + "s", str).replace(' ', car);
    }

    public static String RPad(String str, Integer length, char car) {
        return str +
                String.format("%" + (length - str.length()) + "s", "")
                        .replace(" ", String.valueOf(car));
    }

    public static String getYYYMMDDHHmmssSSS() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getYyyyMMdd() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getYyyyMMddWithDash() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getHHmmss() {
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static String getYyyy() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}