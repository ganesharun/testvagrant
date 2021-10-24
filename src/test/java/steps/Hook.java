package steps;

import Base.BaseUtil;




import com.report.CucumberExtentOptions;
import io.cucumber.java.*;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeClass;
import reportFactory.logs;
import pages.browser;

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
        log.createLogs();
        CucumberExtentOptions.getInstance().setDocumentTitle("Test Vagrant");
        CucumberExtentOptions.getInstance().setReportLevel("Feature");
        CucumberExtentOptions.getInstance().setReportName("WeatherMan");
    }


    @After
    public void TearDownTest(Scenario scenario) {
    }

    @BeforeStep
    public  void BeforeEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
    }

    @AfterStep
    public void afterStepHook(Scenario scenario) throws IOException {
        if(scenario.isFailed()==true) {
            scenario.embed(((TakesScreenshot)browser.driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
    }
    @AfterTest
    public void end()
    {
        System.out.println("End");
    }


}
