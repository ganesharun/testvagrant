package steps;

import io.cucumber.java.en.Given;
import pages.browser;
import common.driverFactory;
import reportFactory.logs;
import static org.assertj.core.api.Assertions.*;


import java.io.IOException;

public class accuWeatherTest {
    browser oBrowser = new browser();
    logs oLog = new logs();
    driverFactory oDriverFactory = new driverFactory();
    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) throws IOException {
        oBrowser.initialize("chrome",url);
    }
}
