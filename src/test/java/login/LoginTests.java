package login;

import base.BaseTests;
import utils.JsonDataDriverReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTests {

    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        JsonDataDriverReader jsonDataDriverReader = new JsonDataDriverReader();
        return jsonDataDriverReader.readDataForSuccessfulLogin();
    }

    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void testSuccessfulLogin(String data) {
        String users[] = data.split(",");
        var loginPage = homePage.clickOnLoginLink();
        loginPage.login(users[0],users[1]);


    }
}
