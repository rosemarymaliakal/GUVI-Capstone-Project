package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {
	
	@FindBy(id = "username")
	WebElement loginuname;
	
	@FindBy(id = "password")
	WebElement loginpwd;
	
	@FindBy(id = "login")
	WebElement loginbutton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage enterUsername() {
		loginuname.sendKeys("rosemaliakal");
		return this;
	}
	
	public HomePage enterPassword() {
		loginpwd.sendKeys("rose1234");
		return this;
	}
	
	
	
	public SearchHotelPage clickLogin() {
		loginbutton.click();
		return new  SearchHotelPage(driver);
	}

}
