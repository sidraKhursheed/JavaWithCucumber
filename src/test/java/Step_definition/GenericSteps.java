package Step_definition;

import Helper.Drivers;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class GenericSteps {

    private Drivers drivers;
    private Scenario scenario;

    @Before public void CallingScenarioBefore(Scenario scenario){

        this.scenario = scenario;

    }
    public GenericSteps(Drivers drivers) {
        this.drivers = drivers;
    }

    /*@Given("^Launch website$")
    public void launchFairWebsite() {
        this.drivers.setUp();
    }*/


    @And("^Close the browser$")
    public void quitTesting() {
        this.drivers.tearDown(scenario);
    }

}