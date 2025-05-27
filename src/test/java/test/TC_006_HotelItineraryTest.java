package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.ItineraryPage;
import pages.SearchHotelPage;

public class TC_006_HotelItineraryTest extends ProjectSpecificationMethods {
	
	@Test
	public void HotelItineraryTest() {
		HomePage obj1 = new HomePage(driver);
		obj1.enterUsername()
		.enterPassword()
		.clickLogin();
		
		SearchHotelPage obj = new SearchHotelPage(driver);
		obj.clickonMyItinerary()
		.validateItinerarypageRedirection();
		
	}

}
