package steps;

import Base.BaseUtil;





import io.cucumber.java.*;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeClass;
import reportFactory.logs;
import pages.browser;

import java.io.File;
import java.io.IOException;


public class Hook extends BaseUtil{


    private BaseUtil base;
    private int counter = 0;
    logs log = new logs();


    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {

        String path = scenario.getId();
        String featureFile = path.substring(path.lastIndexOf("/")+1, path.length()).split(":")[0];
        if(cucumberFeatures.size()!=0) {
            if (!cucumberFeatures.contains(featureFile)) {
                cucumberFeatures.add(featureFile);
                log.startTestCase(featureFile);
            }
        }
        else
        {
            cucumberFeatures.add(featureFile);
            log.startTestCase(featureFile);
        }
        log.info(scenario.getName());



    }
    @BeforeClass
    public void beforeMethod() {

    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed())  {
            byte[] screenshot = ((TakesScreenshot) browser.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        browser.driver.quit();
    }

    @BeforeStep
    public  void BeforeEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
    }

    @AfterStep
    public void afterStepHook(Scenario scenario) throws IOException {

    }
    @AfterTest
    public void end()
    {
        System.out.println("End");
    }


}
