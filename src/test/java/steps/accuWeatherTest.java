package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import Exception.differenceException;
import common.driverFactory;
import reportFactory.logs;
import static org.assertj.core.api.Assertions.*;
/*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    class for all accu weather related features
 */
public class accuWeatherTest {
    browser oBrowser = new browser();
    logs oLog = new logs();
    driverFactory oDriverFactory = new driverFactory();
    public static double accuWeatherTemp = 0.0;

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
            accuWeatherHome oAccuWeatherHome = PageFactory.initElements(browser.driver, accuWeatherHome.class);
            accuWeatherLocationPage ocAcuWeatherLocationPage = PageFactory.initElements(browser.driver, accuWeatherLocationPage.class);
            oAccuWeatherHome.accuWeathersearchLocation.sendKeys(location);
            oAccuWeatherHome.searchResultFirstOption.click();
            String locationDetails = ocAcuWeatherLocationPage.locationName.getText();
            assertThat(locationDetails.toLowerCase()).contains(location.toLowerCase());
    }

    @Then("get the temperature details of the location")
    public void getAccuWeatherTemperature()
    {
        accuWeatherLocationPage ocAcuWeatherLocationPage = PageFactory.initElements(browser.driver, accuWeatherLocationPage.class);
        accuWeatherTemp=Double.parseDouble(ocAcuWeatherLocationPage.currentTempElement.getText().substring(0,2));
    }

    @Then("check if the difference in temperature is less than {string}")
    public void checkDifference(String diffVal) throws differenceException
    {
        double expectedDiffValue = Double.parseDouble(diffVal);

        System.out.println(apiTests.apiTemp);
        System.out.println(accuWeatherTemp);
        double actDiffVal = Math.abs(apiTests.apiTemp-accuWeatherTemp);
        if(actDiffVal>expectedDiffValue)
        {
            throw new differenceException("The difference in temperature is "+actDiffVal+" which is higher than permissible limit mentioned "+diffVal+" temperature from accuWeather is "+accuWeatherTemp+ "temperature from API is "+apiTests.apiTemp);
        }
    }


}
