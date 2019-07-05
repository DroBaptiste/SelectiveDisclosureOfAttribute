package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonTreatment {

    String token;
    String location;


    public static void createFile(String token, String location) {
        JSONObject credentials = new JSONObject();
        credentials.put("token", token);
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

        this.token = (String) jsonObject.get("token");
        this.location = (String) jsonObject.get("location");
    }


    public String getToken() {
        return token;
    }

    public String getLocation() {
        return location;
    }

    public static void validate() {

    }
}
