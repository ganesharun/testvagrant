package runner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import reportFactory.logs;

import java.util.Locale;

public class NGTestListener implements ITestListener {
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
        logs clog = new logs();
        clog.createLogs();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
