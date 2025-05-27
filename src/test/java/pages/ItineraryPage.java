package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ItineraryPage extends ProjectSpecificationMethods {
	
	@FindBy(id = "booked_form")
	WebElement bookedItinerary;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkbox1;
	
	@FindBy(id = "order_id_1332036")
	WebElement firstorder;
	
	@FindBy(xpath = "//input[@name='cancelall']")
	WebElement cancelBtn;
	
	public ItineraryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ItineraryPage validateItinerarypageRedirection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(bookedItinerary));
		Assert.assertTrue(bookedItinerary.isDisplayed(), "Not redirected to booked Itinerary page");
		return this;
	}
	
	public ItineraryPage clickonCheckbox1() {
		checkbox1.click();
		return this;
	}
	
	
}
