package test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_004_HotelBookTest extends ProjectSpecificationMethods {
	
	public void HotelBook() {
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
