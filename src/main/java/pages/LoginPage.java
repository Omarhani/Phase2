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
    private void insertEmail(String email){
        sendKeys(emailFiled,email);
    }
    private void insertPassword(String password){
        sendKeys(passwordFiled,password);
    }
    private void clickOnLoginButton(){
        click(loginButton);
    }

    public HomePage login(String email, String password){
        insertEmail(email);
        insertPassword(password);
        clickOnLoginButton();
        return new HomePage(driver);
    }
}
