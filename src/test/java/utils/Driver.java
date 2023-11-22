package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class Driver {

	static String url ="https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = dataReader.getData("browser");
		}
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			switch(browser) {
			
			case "chrome" :
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "chrome-headless" :
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
				break;
			case "firefox" :
				FirefoxDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "firefox-headless" :
				FirefoxDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
				break;
			case "safari" :
				driver = new SafariDriver();
				break;
			case "edge" :
				EdgeDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "sauceLabs" :
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setCapability("platformName", "Windows 8.1");
				browserOptions.setCapability("browserVersion", "108");
				Map<String, Object> sauceOptions = new HashMap<>();
				sauceOptions.put("build", "firstBuild");
				sauceOptions.put("name", "amazonSearch");
				sauceOptions.put("username", "oauth-m.muhaidat877-03861");
				sauceOptions.put("accessKey", "dc5a3a8d-40b2-46f7-ab58-739934e47793");
				browserOptions.setCapability("sauce:options", sauceOptions);
				
				try {
					driver = new RemoteWebDriver(new URL(url), browserOptions);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			default:
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions Options = new ChromeOptions();
				Options.addArguments("--headless");
				driver = new ChromeDriver(Options);
				break;
			}
			
		}
		
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

}
}
