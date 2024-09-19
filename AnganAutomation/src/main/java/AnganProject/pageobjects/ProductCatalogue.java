package AnganProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AnganProject.Utility.CommonMethos;

public class ProductCatalogue extends CommonMethos{

	WebDriver driver;
	 public ProductCatalogue(WebDriver driver) {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement disappearmessage;
	
	By Products1=By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".card-body button:Last-of-type");
	By toast=By.cssSelector("#toast-container");
	
	public List<WebElement> getListOfProducts()
	{
		
		waitFortheElement(Products1);
		return products;
		
	}
	
	public WebElement gettheProductfromList(String Product_Name) {
		
		WebElement p1=getListOfProducts().stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(Product_Name)).findFirst().orElse(null);
		
		return p1;
	}
	
	public void addProductToCart(String Product_Name) {
		
		WebElement wb=gettheProductfromList(Product_Name);
		wb.findElement(addtoCart).click();
		waitForEelementtoDisaapear(disappearmessage);
		//waitFortheElement(toast);
	}
	
	
	
	
	
	
}
