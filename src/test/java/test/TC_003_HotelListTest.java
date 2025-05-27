package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_003_HotelListTest extends ProjectSpecificationMethods {
	
	@Test
	
	public void HotelListTest() {
		HomePage obj1 = new HomePage(driver);
		obj1.enterUsername()
		.enterPassword()
		.clickLogin();
		
		SearchHotelPage obj = new SearchHotelPage(driver);
		
		obj.selectLocation(1)
		.selectHotel(1)
		.selectRoomtype(1)
		.selectRoomNumber(1)
		.enterCheckindate("23-07-2025")
		.enterCheckoutDate("24-07-2025")
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
	}

}
