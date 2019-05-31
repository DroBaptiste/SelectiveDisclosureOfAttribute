package Utils;

import org.apache.commons.codec.binary.Hex;

public class Main {
    public static void main(String[] args) throws Exception {
        String myString = "ça marche";
        String hexString = Hex.encodeHexString(myString.getBytes());
        System.out.println(Web3Utils.doTransaction("0x8fa7173202d86C746bd884C9f116E356600c6b0E", hexString));
        System.out.println(Web3Utils.verifyAssertion("0x0b24f0b32299dead23b957a924503ff863e70a0e98e8459174513250b335058c", "0xb47b08c50be136f41510f6a1cb579fa36d45cf79c6be92033874ce16b4e0550f"));
    }
}
