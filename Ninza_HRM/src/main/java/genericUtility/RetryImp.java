package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{
	int limit=6;
	int start=0;
	@Override
	public boolean retry(ITestResult result) {
		if(start<limit) {
			start++;
			return true;
		}
		return false;
	}

}
