package AnganProject.Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AnganProject.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		String Product_Name="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage page1=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("dasanganmohan2014@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Angan@1996");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement p1=products.stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(Product_Name)).findFirst().orElse(null);
		
		p1.findElement(By.cssSelector(".card-body button:Last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> p2=driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match=p2.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(Product_Name));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		
		
		
		
		
		

	}

}
