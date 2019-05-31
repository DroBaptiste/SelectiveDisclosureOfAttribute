package SP;

import Backend.Assertion;

import java.io.File;

public class SamlVerificator {

    public static boolean verificationUrl(String URL){
        File tempFile = new File(URL);
        return tempFile.exists();
    }

    public Assertion getAssertion(String URL){
        if(verificationUrl(URL)){
            Assertion assertion = new Assertion();
            return assertion;
        }else{
            return null;
        }
    }
}
