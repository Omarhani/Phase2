package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    public  WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public MethodHandles(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator){
        for (int i = 0;i<10;i++){
            try {
                explicitWait(locator,10);
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }
    protected void sendKeys(By locator,String text){
        for (int i = 0;i<10;i++) {
            try {
                explicitWait(locator,10);
                webElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }
    protected String getText(By locator){
        explicitWait(locator,10);
        return webElement(locator).getText();

    }

    protected void hoverOnElement(By locator){
        explicitWait(locator,15);
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }


    private void explicitWait(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    private WebElement webElement (By locator){
        return driver.findElement(locator);
    }


}
