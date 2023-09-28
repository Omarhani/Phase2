package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NotBookPage extends MethodHandles {
    public NotBookPage(WebDriver driver) {
        super(driver);
    }
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");

    private By addToCartButton2 = By.id("add-to-cart-button-4");
    private By nameOfProduct = By.cssSelector("[class='product-name'] h1");

    private By shoppingCartLink = By.cssSelector(".ico-cart");

    public void clickOnAddToCartButton(){
        click(addToCartButton);
    }

    public void clickOnAddToCartButton2(){
        click(addToCartButton2);
    }
    public String getProductTitle(){
        return getText(nameOfProduct);
    }
    public CartPage clickOnShoppingCartLink(){
        click(shoppingCartLink);
        return new CartPage(driver);
    }

}
