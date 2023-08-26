package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    private By emailFiled = By.id("Email");
    private By passwordFiled = By.id("Password");
    private By loginButton = By.cssSelector(".login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email,String password){
        sendKeys(emailFiled,email);
        sendKeys(passwordFiled,password);
        click(loginButton);
    }
}
