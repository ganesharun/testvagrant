package pages;

import common.driverFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class browser {
    public driverFactory driverFactory = new driverFactory();
    public static WebDriver driver = null;

    public void initialize(String browser, String url) throws IOException {
        driver = driverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                30, TimeUnit.SECONDS);
        driver.get(url);

    }

}
