package AnganProject.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AnganProject.pageobjects.CartPage;
import AnganProject.pageobjects.LandingPage;
import AnganProject.pageobjects.ProductCatalogue;
import TestComponents.BaseTest;


public class StandAloneTest2 extends BaseTest{

	@Test
	 public void order() throws IOException {
		String Product_Name="ZARA COAT 3";
		
		
		LandingPage page1=LaunchApplication();
		page1.loginPage("dasanganmohan2014@gmail.com", "Angan@1996");
		
		//Product-catalogue page code 
		ProductCatalogue page2=new ProductCatalogue(driver);
		List<WebElement> products=page2.getListOfProducts();
		
		//adding product to cart
		page2.addProductToCart(Product_Name);
		
		//click on cart icon
		page2.GoTocartpage();
		
		//cartpage checkout 
        CartPage p3=new CartPage(driver);
        Boolean match=p3.ProductDisplaying(Product_Name);
		Assert.assertTrue(match);
		p3.ClickOnCheckOut();
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='select country']")),"india").build().perform();
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item'])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage=driver.findElement(By.xpath(".hero-primary")).getText();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER"));
		driver.close();	

	}

}
