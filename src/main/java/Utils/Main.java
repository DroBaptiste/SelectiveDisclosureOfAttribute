package Utils;

import org.apache.commons.codec.binary.Hex;

public class Main {
    public static void main(String[] args) throws Exception {
        String myString = "ça marche";
        String hexString = Hex.encodeHexString(myString.getBytes());
        System.out.println(Web3Utils.doTransaction("0x8fa7173202d86C746bd884C9f116E356600c6b0E", hexString));
    }
}
