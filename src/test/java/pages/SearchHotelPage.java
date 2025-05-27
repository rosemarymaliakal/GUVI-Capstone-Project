package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SearchHotelPage extends ProjectSpecificationMethods {
	
	@FindBy(id = "location")
	WebElement locationlist;
	
	@FindBy(id = "hotels")
	WebElement hotellist;
	
	@FindBy(id = "room_type")
	WebElement roomlist;
	
	@FindBy(id = "room_nos")
	WebElement roomnumber;
	
	@FindBy(id = "datepick_in")
	WebElement checkindate;
	
	@FindBy(id = "datepick_out")
	WebElement checkoutdate;
	
	@FindBy(id = "adult_room")
	WebElement adutlsnumber;
	
	@FindBy(id = "child_room")
	WebElement childnumber;
	
	@FindBy(id = "Submit")
	WebElement searchbutton;
	
	@FindBy(id = "location_span")
	WebElement locationerr;
	
	@FindBy(id = "num_room_span")
	WebElement roomerr;
	
	@FindBy(id = "checkin_span")
	WebElement checkin;
	
	@FindBy(id = "checkout_span")
	WebElement checkout;
	
	@FindBy(id = "search_form")
	WebElement hotelform;
	
	@FindBy(xpath = "//a[contains(text(),'Booked')]")
	WebElement itinerarymenu;
	
	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public SearchHotelPage selectLocation(int locationIndex) {
		Select select = new Select(locationlist);
		select.selectByIndex(locationIndex);
		return this;
	}
	
	public SearchHotelPage selectHotel(int hotelIndex) {
		Select select = new Select(hotellist);
		select.selectByIndex(hotelIndex);
		return this;
	}
	
	public SearchHotelPage selectRoomtype(int roomIndex) {
		Select select = new Select(roomlist);
		select.selectByIndex(roomIndex);
		return this;
	}
	
	public SearchHotelPage selectRoomNumber(int roomnumIndex) {
		Select select = new Select(roomnumber);
		select.selectByIndex(roomnumIndex);
		return this;
	}
	
	public SearchHotelPage enterCheckindate(String indate) {
		checkindate.sendKeys(indate);
		return this;
	}
	
	public SearchHotelPage enterCheckoutDate(String outdate) {
		checkoutdate.sendKeys(outdate);
		return this;
	}
	
	public SearchHotelPage selectAdultNumber(int adultIndex) {
		Select select = new Select(adutlsnumber);
		select.selectByIndex(adultIndex);
		return this;
	}
	
	public SearchHotelPage selectChildNumber(int childIndex) {
		Select select = new Select(childnumber);
		select.selectByIndex(childIndex);
		return this;
	}
	
	public HotelListPage clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbutton));
		searchbutton.click();
		return new HotelListPage(driver);
	}
	
	
	public SearchHotelPage validateNoLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(locationerr));
		Assert.assertTrue(locationerr.isDisplayed(), "Error message not displayed if location not selected");
		return this;
	}
	
	public SearchHotelPage validateNoRoomNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(roomerr));
		Assert.assertTrue(roomerr.isDisplayed(), "Error message not displayed if Number of Rooms not Selected");
		return this;
	}
	
	public SearchHotelPage clearCheckinDate() {
		checkindate.clear();
		return this;
	}
	
	public SearchHotelPage validateNocheckinDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkin));
		Assert.assertTrue(checkin.isDisplayed(), "Error message not displayed if check-in date not entered");
		return this;
	}
	
	public SearchHotelPage clearCheckoutDate() {
		checkoutdate.clear();
		return this;
	}
	
	public SearchHotelPage validateNocheckoutDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkout));
		Assert.assertTrue(checkout.isDisplayed(), "Error message not displayed if checkout date not displayed");
		return this;
	}
	
	public SearchHotelPage validatecheckoutDateAfter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkout));
		String error_msg = checkout.getText();
		Assert.assertEquals(error_msg, "Check-Out Date shall be after than Check-In Date","Error message not displayed if check out date is not after check in date");
		return this;
	}
	
	public SearchHotelPage verifySearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hotelform));
		Assert.assertTrue(hotelform.isDisplayed(), "Not redirected to Hotel Search page");
		return this;
	}
	
	public ItineraryPage clickonMyItinerary() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(itinerarymenu));
		itinerarymenu.click();
		return new ItineraryPage(driver);
	}
}
