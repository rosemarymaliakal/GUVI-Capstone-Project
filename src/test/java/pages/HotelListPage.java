package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HotelListPage extends ProjectSpecificationMethods {
	
	@FindBy(xpath = "(//form[@id=\"select_form\"]//td)[1]")
	WebElement tableheading;
	
	@FindBy(id = "radiobutton_0")
	WebElement hotelButton;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	

	public HotelListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HotelListPage validateWithMandatoryFields() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(tableheading));
		Assert.assertTrue(tableheading.isDisplayed(), "Hotel list not displayed, please enter valid credentials");
		return this;
	}
	
	public HotelListPage selectHotel() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(tableheading));
		hotelButton.click();
		return this;
	}
	
	public HotelBookPage clickContinue() {
		continueBtn.click();
		return new HotelBookPage(driver);
	}
	
}
