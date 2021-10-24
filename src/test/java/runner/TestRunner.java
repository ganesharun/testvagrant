package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;



@CucumberOptions(features = {"src/test/java/features"} , plugin= {"com.report.CucumberExtent:target/cucumber-extent-reports/report.html"},
        tags = "not @ignore",glue = {"steps"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}



