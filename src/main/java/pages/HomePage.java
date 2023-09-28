package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {


    private By login = By.linkText("Log in");
    private By computers = By.xpath("//a[contains(text(),'Computers')]");
    private By notBooks = By.xpath("//a[contains(text(),'Notebooks')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginLink(){
        click(login);
        return new LoginPage(driver);
    }

    public void hoverOnComputers(){
        hoverOnElement(computers);
    }
    public NotBookPage clickOnNotBooks(){
        click(notBooks);
        return new NotBookPage(driver);
    }



}
