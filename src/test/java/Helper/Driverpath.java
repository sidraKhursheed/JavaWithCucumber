    package Helper;

    public class Driverpath {

        public static void chrome(){
            //Chrome Webdriver for Ubuntu
            String path = System.getProperty("user.dir");
           // System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/webdrivers/chromedriver");
            //Chrome Webdriver for Window
            // System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\webdrivers\\chromedriver.exe");
             System.setProperty("webdriver.chrome.driver","E:\\New folder\\JavaWithCucumber\\src\\main\\resources\\webdrivers\\chromedriver.exe");
        }

        public static void firefox(){
            String path = System.getProperty("user.dir");
            //Firefox Webdriver for Ubuntu
            System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/webdrivers/geckodriver");
            //Firefox Webdriver for Windows
            //System.setProperty("webdriver.gecko.driver",path+"\\src\\main\\resources\\webdrivers\\geckodriver.exe");
        }
    }
