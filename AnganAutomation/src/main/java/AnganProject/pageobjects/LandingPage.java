package AnganProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AnganProject.Utility.CommonMethos;

public class LandingPage extends CommonMethos{

	WebDriver driver;
	 public LandingPage(WebDriver driver) {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	public void loginPage(String Email,String password) {
		email.sendKeys(Email);
		Password.sendKeys(password);
		Submit.click();
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
