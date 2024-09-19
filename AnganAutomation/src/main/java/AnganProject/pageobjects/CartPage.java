package AnganProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AnganProject.Utility.CommonMethos;

public class CartPage extends CommonMethos{

	WebDriver driver;
	 public CartPage(WebDriver driver) {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productsinCartPage;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkOutBtn;
	
	public Boolean ProductDisplaying(String Product_Name) {
		Boolean match=productsinCartPage.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(Product_Name));
		return match;
	}
	
	public void ClickOnCheckOut() {
		checkOutBtn.click();
	}
	
}
