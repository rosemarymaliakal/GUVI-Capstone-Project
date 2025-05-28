package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_007_LogoutTest extends ProjectSpecificationMethods{
	
	@Test
	
	public void LogoutTest() {
		HomePage obj = new HomePage(driver);
		obj.enterUsername()
		.enterPassword()
		.clickLogin();
		
		SearchHotelPage obj1 = new SearchHotelPage(driver);
		obj1.clickonLogoutbtn();
	}
	
	

}
