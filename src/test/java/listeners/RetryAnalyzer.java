package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	private int currentRetry = 0;
	private static final int maxRetry = 2;
	@Override
	public boolean retry(ITestResult result) {
		if(currentRetry < maxRetry) {
			currentRetry++;
			
			TestListener.getTest()
		    .warning("Retrying test attempt: " 
			+ result.getName() 
			+ "|Attempt: " 
			+ currentRetry);
			
			return true;
		}
		return false;
	}

}
