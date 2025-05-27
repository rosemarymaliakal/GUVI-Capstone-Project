package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility {
	
	@Parameters("url")
	
	@BeforeMethod
	public void launchBrowser(String url) {
		openUrl(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeUrl();
	}

}
