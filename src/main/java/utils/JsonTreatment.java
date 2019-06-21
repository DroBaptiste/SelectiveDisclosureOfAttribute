package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonTreatment {

    String hash;
    String location;


    public static void createFile(String hash, String location) {
        JSONObject credentials = new JSONObject();
        credentials.put("hash", hash);
        credentials.put("location", location);
        try (FileWriter file = new FileWriter("credential.json")) {

            file.write(credentials.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonTreatment() {
    }

    public JsonTreatment(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(path));
        JSONObject jsonObject =  (JSONObject) obj;

        this.hash = (String) jsonObject.get("hash");
        this.location = (String) jsonObject.get("location");
    }


    public String getHash() {
        return hash;
    }

    public String getLocation() {
        return location;
    }

    public static void validate() {

    }
}
