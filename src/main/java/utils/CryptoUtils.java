package utils;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class CryptoUtils {


    public static String sha256Payload(, String assertion) throws NoSuchAlgorithmException {
        String inputValue = assertion;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(inputValue.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        StringBuilder hashtext = new StringBuilder(no.toString(16));
        while (hashtext.length() < 32) {
            hashtext.insert(0, "0");
        }
        return hashtext.toString();
    }

    public static int nbrDays(String _date1, String _date2){
        DateTime date1 = new DateTime(_date1);
        DateTime date2 = new DateTime(_date2);
        String days = Days.daysBetween(date1,date2).toString();
        return Integer.valueOf(days.substring(days.indexOf("-")+1,days.indexOf("D")))+1;
    }

    public static DateTime dateExpiration(String _startDate, String _validity){
        DateTime dateTime = new DateTime(_startDate);
        dateTime = dateTime.plusDays(Integer.valueOf(_validity));
        return dateTime;
    }
}