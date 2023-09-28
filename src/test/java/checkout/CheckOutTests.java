package checkout;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataDriverReader;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CheckOutTests extends BaseTests {

    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        JsonDataDriverReader jsonDataDriverReader = new JsonDataDriverReader();
        return jsonDataDriverReader.readDataForSuccessfulLogin();
    }
    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void testCheckOut(String data) throws InterruptedException {
        String users[] = data.split(",");
        LoginPage loginPage = homePage.clickOnLoginLink();
        HomePage homePage1 = loginPage.login(users[0],users[1]);
        homePage1.hoverOnComputers();
        NotBookPage notBookPage =homePage1.clickOnNotBooks();
        notBookPage.clickOnAddToCartButton();
        String expectedTitle = notBookPage.getProductTitle();

        notBookPage.clickOnAddToCartButton2();
        CartPage cartPage = notBookPage.clickOnShoppingCartLink();
        assertEquals(expectedTitle,cartPage.getTitle(),"The item added is wrong");
        cartPage.clickOnAgreeCheckBoxButton();
        CheckOutPage checkOutPage = cartPage.clickOnCheckoutButton();
        checkOutPage.clickOnBillingAddressContinueButton();
        checkOutPage.clickOnShippingMethodContinueButton();
        checkOutPage.clickOnPaymentMethodContinueButton();
        checkOutPage.clickOnPaymentInfoContinueButton();
        CompletePage completePage =checkOutPage.clickOnLastConfirmationButton();
        String expectedResult = completePage.getThankYouMessage();
        assertEquals("Thank you",expectedResult);

        Thread.sleep(3000);

    }
}
