package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CartPage extends MethodHandles {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By productTitle = By.cssSelector(".product-name");

    private By agreeCheckBox = By.id("termsofservice");

    private By checkoutButton = By.id("checkout");

    public String getTitle(){
        return getText(productTitle);
    }
    public void clickOnAgreeCheckBoxButton(){
        click(agreeCheckBox);
    }
    public CheckOutPage clickOnCheckoutButton(){
        click(checkoutButton);
        return new CheckOutPage(driver);
    }
}
