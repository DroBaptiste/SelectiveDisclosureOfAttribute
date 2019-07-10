package utils.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class SetConfig {
    String configFile = "/home/dromard/Documents/JAva/apache-tomcat-9.0.20/bin/config.json";

    public String getDomain() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(configFile));

        JSONObject jsonObject =  (JSONObject) obj;
        String domain = (String) jsonObject.get("domain");
        return domain;
    }


    public SetConfig() throws IOException, ParseException {
    }
}
