package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;

public class TC_002_SearchHotelTest extends ProjectSpecificationMethods {
	
	@Test
	
	public void SearchHotelTest() {
		HomePage obj1 = new HomePage(driver);
		obj1.enterUsername()
		.enterPassword()
		.clickLogin();
		
		SearchHotelPage obj = new SearchHotelPage(driver);
		
		obj.selectHotel(1) //no location selected
		.selectRoomtype(1)
		.selectRoomNumber(1)
		.enterCheckindate("23-07-2025")
		.enterCheckoutDate("24-07-2025")
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
		
		SearchHotelPage obj2 = new SearchHotelPage(driver);
		obj2.validateNoLocation();
		
		obj.selectLocation(1) //Number of rooms not selected
		.selectHotel(1)
		.selectRoomtype(1)
		.selectRoomNumber(0)
		.enterCheckindate("23-07-2025")
		.enterCheckoutDate("24-07-2025")
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
		obj2.validateNoRoomNumber();
		
		obj.selectLocation(1)//no check-in date
		.selectHotel(1)
		.selectRoomtype(1)
		.selectRoomNumber(1)
		.clearCheckinDate()
		.enterCheckoutDate("24-07-2025")
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
		obj2.validateNocheckinDate();
		
		obj.selectLocation(1) //no check-out date
		.selectHotel(1)
		.selectRoomtype(1)
		.selectRoomNumber(1)
		.enterCheckindate("23-07-2025")
		.clearCheckoutDate()
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
		obj2.validateNocheckoutDate();
		
		obj.selectLocation(1) //check-in date is after that check-out date
		.selectHotel(1)
		.selectRoomtype(1)
		.selectRoomNumber(0)
		.enterCheckindate("23-07-2025")
		.enterCheckoutDate("21-07-2025")
		.selectAdultNumber(2)
		.selectChildNumber(2)
		.clickSearch();
		obj2.validatecheckoutDateAfter();
		
//		obj.selectLocation(1)
//		.selectHotel(1)
//		.selectRoomtype(1)
//		.selectRoomNumber(1)
//		.enterCheckindate("23-07-2025")
//		.enterCheckoutDate("24-07-2025")
//		.selectAdultNumber(2)
//		.selectChildNumber(2)
//		.clickSearch()
//		.validateWithMandatoryFields(); //all fields entered
		
	}
	

}
