package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    String fileName;
    public JsonDataReader(String fileName){
        this.fileName = fileName;
    }

    public String jsonReader(String key) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/" + fileName);

        Object obj = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) obj;

        String text = (String)jsonObject.get(key);
        return text;
    }
}
