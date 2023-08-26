package login;

import base.BaseTests;
import utils.JsonDataDriverReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ScreenRecorderUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginTests extends BaseTests {

    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        JsonDataDriverReader jsonDataDriverReader = new JsonDataDriverReader();
        return jsonDataDriverReader.readDataForSuccessfulLogin();
    }

    @Test(dataProvider = "testDataForSuccessfulLogin",groups = "sanity")
    public void testSuccessfulLogin(String data) throws InterruptedException {
        String users[] = data.split(",");
        var loginPage = homePage.clickOnLoginLink();
        loginPage.login(users[0],users[1]);


    }
}
