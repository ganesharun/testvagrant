package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import common.driverFactory;
import reportFactory.logs;
import static org.assertj.core.api.Assertions.*;

public class accuWeatherTest {
    browser oBrowser = new browser();
    logs oLog = new logs();
    driverFactory oDriverFactory = new driverFactory();

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) throws Exception {
        try {
            oBrowser.initialize("chrome", url);
            accuWeatherHome oAccuWeatherHome = PageFactory.initElements(browser.driver, accuWeatherHome.class);
            oAccuWeatherHome.accuWeathersearchLocation.isDisplayed();
            String pageTitle = oBrowser.driver.getTitle();
            assertThat(pageTitle.toLowerCase()).contains("accuweather");
            oLog.info("Browser launched and Navigation to " + url + " Completed");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("the page is loaded successfully search for {string}")
    public void thePageIsLoadedSuccessfullySearchForCity(String location) {
        try {
            accuWeatherHome oAccuWeatherHome = PageFactory.initElements(browser.driver, accuWeatherHome.class);
            accuWeatherLocationPage ocAcuWeatherLocationPage = PageFactory.initElements(browser.driver, accuWeatherLocationPage.class);
            oAccuWeatherHome.accuWeathersearchLocation.sendKeys(location);
            oAccuWeatherHome.searchResultFirstOption.click();
            String locationDetails = ocAcuWeatherLocationPage.locationName.getText();
            assertThat(locationDetails.toLowerCase()).contains(location);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
