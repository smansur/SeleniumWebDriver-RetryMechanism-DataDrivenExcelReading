package retryFailScenario;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int maxRetries=1;
    int count=0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()) {
             if (count < maxRetries) {
                 count++;
                 return true;
             }
        }return false;
    }
}
