package runner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import reportFactory.logs;



public class NGTestListener implements ITestListener {
    @Override
    public void onStart(ITestContext iTestContext) {

        logs clog = new logs();
        clog.createLogs();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
