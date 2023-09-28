package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckOutPage extends MethodHandles {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private By billingAddressContinueButton = By.cssSelector(".button-1.new-address-next-step-button");

    private By shippingMethodContinueButton = By.cssSelector(".button-1.shipping-method-next-step-button");
    private By paymentMethodContinueButton = By.cssSelector(".button-1.payment-method-next-step-button");
    private By paymentInfoContinueButton = By.cssSelector(".button-1.payment-info-next-step-button");

    private By lastConfirmationButton = By.cssSelector(".button-1.confirm-order-next-step-button");

    public void clickOnBillingAddressContinueButton(){
        click(billingAddressContinueButton);
    }
    public void clickOnShippingMethodContinueButton(){
        click(shippingMethodContinueButton);
    }
    public void clickOnPaymentMethodContinueButton(){
        click(paymentMethodContinueButton);
    }
    public void clickOnPaymentInfoContinueButton(){
        click(paymentInfoContinueButton);
    }
    public CompletePage clickOnLastConfirmationButton(){
        click(lastConfirmationButton);
        return new CompletePage(driver);
    }

}
