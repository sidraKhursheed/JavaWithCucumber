package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

public class AbstractPageObject {


    WebDriver drivertest;
    WebDriverWait wait;
    WebElement element;
    //Constructor
    public AbstractPageObject(WebDriver driver) {
            this.drivertest = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementToClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void FindElement(WebDriver driver, By locator, String value) {
        String ElementName = driver.findElement(locator).getText();
        if (ElementName.isEmpty()) {
            System.out.println("Webiste contains the section but element text not found");
        } else {
            assertTrue("Text not Found", ElementName.contains(value));
            System.out.println("Website contains the " + value);
        }
    }
     // Method overload
    public void FindElement(WebDriver driver, By locator) {
        String ElementName = driver.findElement(locator).getText();
        if (ElementName.isEmpty()) {
            System.out.println("Webiste contains the section but button text not found");
        } else {
             System.out.println("Website contains the section "+ElementName);
        }
    }

    public void HandlingFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
        System.out.println("Switching to frame");
    }

    public void SendKey(WebDriver driver, By locator, String value) {
        waitForElementToAppear(locator);
        driver.findElement(locator).sendKeys(value);
        System.out.println("Enter Value " + value);
    }

    public void ClickElement(WebDriver driver, By locator) {
        waitForElementToClick(locator);
        String ElementName = driver.findElement(locator).getText();
        System.out.println("Click button i.e. " +ElementName);
        driver.findElement(locator).click();

    }

    public void GetUrl(WebDriver drivertest) {
        String Serviceurl = drivertest.getCurrentUrl();
        System.out.println("url " + Serviceurl);
    }

    public void Navigateurl(WebDriver driver, String url) {
       driver.navigate().to(url);
       System.out.println(url);
    }

    public void ActionClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.perform();
        System.out.println("Click button i.e. " +element);
    }
}