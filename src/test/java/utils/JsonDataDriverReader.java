package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataDriverReader {

    String successfulLogin = "SuccessfulLogin";

    @DataProvider(name = "loginTest")
    private Object[] readJson(String testStatus) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/dataDriver.json");

        Object obj = jsonParser.parse(reader);

        JSONObject userLoginSJsonObj = (JSONObject) obj;

        JSONArray userLoginsArray =(JSONArray) userLoginSJsonObj.get(testStatus);

        String arr[] = new String [userLoginsArray.size()];

        for (int i = 0 ;i<userLoginsArray.size();i++){
            JSONObject users = (JSONObject) userLoginsArray.get(i);
            String user = (String) users.get("Email");
            String password = (String) users.get("Password");
            arr[i] = user+","+ password;
        }
        return arr;
    }
    public Object[] readDataForSuccessfulLogin() throws IOException, ParseException {
        return readJson(successfulLogin);
    }
}
