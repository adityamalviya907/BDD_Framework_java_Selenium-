package Hooks;

import Factory.DriverFactory;
import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class MyHooks {

    WebDriver driver;
    public DriverFactory driverFactory;
   public MyHooks(){
	   this.driverFactory= new DriverFactory();
   }

private ConfigReader configreader;
    @Before
    public void setup() throws InterruptedException {
    	 configreader = new ConfigReader();
        	Properties prop = configreader.initializeProperties();


        	driver= DriverFactory.initializeBrowser(prop.getProperty("browser"));

            //driver = DriverFactory.getDriver();
            driver.get(prop.getProperty("url"));
    }


    @After
    public void tearDown()  {
        driver.quit();
    }
}


//
