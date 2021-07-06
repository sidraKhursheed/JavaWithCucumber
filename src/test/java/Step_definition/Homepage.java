package Step_definition;

import Helper.Drivers;
import Pageobject.HomePageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Homepage {

  //  Drivers driver = new Drivers();
   // HomePageObject obj = new HomePageObject(driver);
    private Drivers driver;
    private HomePageObject obj;
    public Homepage(Drivers drivers){
        this.driver = drivers;
        obj = new HomePageObject(this.driver);
    }

    @Given("^Open google website$")
    public void launchFairWebsite() {
        driver.setUp();
    }

    @And("^Close Home page browser$")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Closing the Home page");
    }


    @And("^Terms and condition popup appears$")
    public void termsAndConditionPopupAppears() { obj.TermConditionPop();}

    @When("^User clicks I agree button$")
    public void userClicksIAgreeButton() {obj.ClickAgreeButton();}
}