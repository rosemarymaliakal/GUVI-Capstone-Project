package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_LoginTest extends ProjectSpecificationMethods {
	
	@Test
	public void LoginTest() {
		HomePage obj = new HomePage(driver);
		obj.enterUsername()
		.enterPassword()
		.clickLogin();
	}

}
