package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class ConfirmHotelPage extends ProjectSpecificationMethods{
	
	@FindBy(xpath = "//td[contains(text(),'Order')]")
	WebElement ordernum;
	
	@FindBy(id = "search_hotel")
	WebElement searchbutton;
	
	@FindBy(id = "my_itinerary")
	WebElement itinerarybutton;
	
	@FindBy(id = "logout")
	WebElement logoutbtn;

	public ConfirmHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmHotelPage validateConfirmBook() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ordernum));
		return this;
	}
	
	public SearchHotelPage clickSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbutton));
		searchbutton.click();
		return new SearchHotelPage(driver);
	}

}
