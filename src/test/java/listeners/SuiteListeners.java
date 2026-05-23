package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import utils.ExtentManager;

public class SuiteListeners implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		
		ExtentManager.getInstance();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentManager.getInstance().flush();
	}

}
