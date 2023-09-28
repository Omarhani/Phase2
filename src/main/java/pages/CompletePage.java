package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CompletePage extends MethodHandles {
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    private By thankYouMessage = By.xpath("//div/h1");

    public String  getThankYouMessage(){
       return getText(thankYouMessage);
    }
}
