package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPageObject {

    public HomePageObject(WebDriver driver) {
        super(driver);
    }





    public void Fetchurl() {
        GetUrl(drivertest);
    }

    private String TermConditionPopup = "//*[@id=\"CXQnmb\"]/div";
    private String Iagree = "L2AGLb";
    public void TermConditionPop(){
       FindElement(drivertest,By.xpath(TermConditionPopup));
    }
    public void ClickAgreeButton(){
        ClickElement(drivertest,By.id(Iagree));
    }
}  