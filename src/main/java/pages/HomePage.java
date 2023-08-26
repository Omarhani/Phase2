package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {


    private By login = By.linkText("Log in");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginLink(){
        click(login);
        return new LoginPage(driver);
    }

}
