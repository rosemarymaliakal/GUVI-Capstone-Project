package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class HotelBookPage extends ProjectSpecificationMethods {
	
	@FindBy(id = "book_hotel_form")
	WebElement bookform;
	
	@FindBy(id = "first_name" )
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;
	
	@FindBy(id = "address")
	WebElement cust_address;
	
	@FindBy(id = "cc_num")
	WebElement cardNum;
	
	@FindBy(id = "cc_type")
	WebElement cardType;
	
	@FindBy(id = "cc_exp_month")
	WebElement card_month;
	
	@FindBy(id = "cc_exp_year")
	WebElement card_year;
	
	@FindBy(id = "cc_cvv")
	WebElement cvv;
	
	@FindBy(id = "book_now")
	WebElement bookbtn;

	public HotelBookPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public HotelBookPage enterFirstname(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(bookform));
		firstname.sendKeys(fname);
		return this;
	}
	
	public HotelBookPage enterLastname(String lname) {
		lastname.sendKeys(lname);
		return this;
	}
	
	public HotelBookPage enterAddress(String address) {
		cust_address.sendKeys(address);
		return this;
	}
	
	public HotelBookPage enterCardnumber(String cnumber) {
		cardNum.sendKeys(cnumber);
		return this;
	}
	
	public HotelBookPage selectCardtype(String ctype) {
		Select select = new Select(cardType);
		select.selectByVisibleText(ctype);
		return this;
	}
	
	public HotelBookPage selectMonth(String cmonth) {
		Select select = new Select(card_month);
		select.selectByVisibleText(cmonth);
		return this;
	}
	
	public HotelBookPage selectYear(String cyear) {
		Select select = new Select(card_year);
		select.selectByVisibleText(cyear);
		return this;
	}
	
	public HotelBookPage enterCvv(String cardcvv) {
		cvv.sendKeys(cardcvv);
		return this;
	}
	
	public ConfirmHotelPage clickBookButton() {
		bookbtn.click();
		return new ConfirmHotelPage(driver) ;
	}
}
