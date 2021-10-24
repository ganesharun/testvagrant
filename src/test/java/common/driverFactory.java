package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class driverFactory {

    WebDriver test;


    public WebDriver createDriver(String browser) {
        switch (browser) {
            case "firefox":
                return getFirefoxDriver();
            case "chrome":
                return getChromeDriver();
            case "edge":
                return getEdgeDriver();
            case "iexplorer":
                return getIEDriver();
            case "safari":
                return getSafariDriver();
            case "htmlunit":
                return htmlUnitDriver();
            default:
                throw new RuntimeException("Invalid Browser");
        }
    }

    private WebDriver getSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("safari.cleanSession", true);
        return new SafariDriver(safariOptions);
    }

    private WebDriver htmlUnitDriver(){
        WebDriver driver = new HtmlUnitDriver(true);
        return driver;
    }

    private WebDriver getIEDriver() {
        //need to configure driver details
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        ieOptions.setCapability("requireWindowFocus", true);
        ieOptions.takeFullPageScreenshot();
        ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        ieOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
        ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        ieOptions.setCapability("ignoreProtectedModeSettings", true);
        return new InternetExplorerDriver(ieOptions);

    }

    private WebDriver getEdgeDriver() {
        //need to configure driver details
        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }


    private WebDriver getChromeDriver() {
        //need to configure driver details
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver getFirefoxDriver() {
        //need to configure driver details
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }

}
