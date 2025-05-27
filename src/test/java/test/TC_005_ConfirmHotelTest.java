package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.ConfirmHotelPage;
import pages.HomePage;
import pages.HotelBookPage;
import pages.HotelListPage;
import pages.SearchHotelPage;

public class TC_005_ConfirmHotelTest extends ProjectSpecificationMethods {
	
	@Test
	public void ConfirmHotelPage() {
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
		
		
		HotelListPage obj2 = new HotelListPage(driver);
		
		obj2.selectHotel()
		.clickContinue();
		
		HotelBookPage obj3 = new HotelBookPage(driver);
		obj3.enterFirstname("Rohit")
		.enterLastname("Sing")
		.enterAddress("Mumbai")
		.enterCardnumber("8321893445239876")
		.selectCardtype("VISA")
		.selectMonth("May")
		.selectYear("2027")
		.enterCvv("0467")
		.clickBookButton()
		.validateConfirmBook();
		
		
		ConfirmHotelPage obj4 = new ConfirmHotelPage(driver);
		
		obj4.clickSearchButton()
		.verifySearchButton();
	
	}
}
