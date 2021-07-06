package Helper;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drivers implements WebDriver {

    WebDriver driver;
    String browserName;
    public String env;
    public String baseurl;

    public void setUp() {
        Map<String, String> paramMap = getParameters("browser","env");
        System.out.println("Starting Browser");
        browserName=paramMap.get("browserName");
        env=paramMap.get("env");
        System.out.println("ENV => "+env);
        driver = getInstance(browserName);
        getEnvironment(env);
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("#hs-eu-confirmation-button ")).click();
        //System.out.println("Accept Cokkies");
    }

    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) (driver))
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        driver.quit();
        System.out.println("Closing the browser");
    }

    private Map<String,String> getParameters(String name, String env) {
        String value = System.getProperty(name);
        String dEnv = System.getProperty(env);
        if (value == null || dEnv == null)
            throw new RuntimeException(name + "or "+dEnv+" is not a parameter!");

        if (value.isEmpty() || dEnv.isEmpty())
            throw new RuntimeException(name + "or "+dEnv+" is empty!");
        Map<String, String> paramsMap=new HashMap<>();
        paramsMap.put("browserName",value);
        paramsMap.put("env",dEnv);
        return paramsMap;
    }

    public Drivers(){
    }

    public WebDriver getInstance(String browserName){
        this.browserName = browserName;
        if (browserName.equalsIgnoreCase("chrome")) {
            Driverpath.chrome();
            this.driver =  new ChromeDriver();
            return driver;
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            Driverpath.firefox();
            this.driver = new FirefoxDriver();
            return driver;
        }
        else{
            System.out.println("invalid browser");
        }
        return null;
    }

    public String getEnvironment(String env){
        String dEnv = env;
        if (dEnv.equalsIgnoreCase("production")) {
            baseurl="https://google.com/";
            this.driver.get(baseurl);
        }
        else if (dEnv.equalsIgnoreCase("release")) {
            baseurl="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
            this.driver.get(baseurl);
        }

        else{
            System.out.println("invalid browser");
            baseurl=null;
        }
        return baseurl;
    }

    public void close() {
        this.driver.close();
    }

    public WebElement findElement(By arg0) {
        return this.driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return this.driver.findElements(arg0);
    }

    public void get(String arg0) {
        this.driver.get(arg0);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public String getPageSource() {
        return this.driver.getPageSource();
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    public Options manage() {
        return this.driver.manage();
    }

    public Navigation navigate() {
        return this.driver.navigate();
    }

    public void quit() {
        this.driver.quit();
    }

    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }
}