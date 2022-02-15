package com.demo.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class git {


	WebDriver driver;
	JavascriptExecutor js;
	Actions action;
	@Parameters("browserName")
	@Test
	public void openBrowser(String browserName) throws Exception {
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.err.println("Invalid browser name!");
			break;
		}
		js = (JavascriptExecutor)driver;
		action = new Actions(driver);
		driver.get("https://www.brakeworld.com/");
//		driver.get("https://www.brakeworld.com/login?returnUrl=%2F");
		js.executeScript("scroll(0,590)");
		js.executeScript("scroll(0,1680)");
		js.executeScript("scroll(0,10000)");
		driver.findElement(By.id("goToTop")).click();
		Thread.sleep(1000);
		
	}
	
	@Test
	public void registerTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		js.executeScript("scroll(0,100)");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Vishal");
		driver.findElement(By.id("LastName")).sendKeys("Kachale");
		driver.findElement(By.id("Email")).sendKeys("vishal14@sevebits.in");
		driver.findElement(By.id("Company")).sendKeys("Seven Bits Technologies LLP");
		driver.findElement(By.id("Password")).sendKeys("Vishal@26");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Vishal@26");
		js.executeScript("scroll(0,100)");
		Thread.sleep(7000);
		driver.findElement(By.id("register-button")).click();
					
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")).click();
	}
	
	@Test
	public void searchTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//span[contains(text(),'YEAR')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'2020')]")).click();			
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'MAKE')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'jaguar')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'MODEL')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'f-pace')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'SubModel0')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'with 325mm front disc')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(4000);
	}
	
	@Test
	public void listPageTest() throws Exception {
		//PriceRange
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(3000);
		WebElement up = driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/span[2]"));
		int ywidth = up.getSize().width;
		Actions s = new Actions(driver);
		s.dragAndDropBy(up, -ywidth*6,0);
		s.build().perform();
		
		//SortBy
		Thread.sleep(2000);
		WebElement sort = driver.findElement(By.xpath("//select[@id='products-orderby']"));
		Select sortBy = new Select(sort);
		sortBy.selectByValue("10");
		js.executeScript("scroll(0,1180)");
		driver.findElement(By.id("goToTop")).click();
		Thread.sleep(3000);
		
		//Add-to-CompareList
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[2]")).click();
		js.executeScript("scroll(0,1100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[4]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/button[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'product comparison')]")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		js.executeScript("scroll(0,-1100)");
		Thread.sleep(2000);
		
		//QuickView
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[3]")).click();
		driver.findElement(By.id("ui-id-1")).click();
		driver.findElement(By.id("ui-id-5")).click();
		driver.findElement(By.xpath("//body/div[15]/div[1]/div[1]/a[1]")).click();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void detailPageTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/button[2]")).click();
		js.executeScript("scroll(0,1000)");
		driver.findElement(By.id("ui-id-2")).click();
		driver.findElement(By.id("ui-id-3")).click();
		driver.findElement(By.id("AddProductReview_Title")).sendKeys("Amazing Product");			
		driver.findElement(By.id("AddProductReview_ReviewText")).sendKeys("Amazing Product With Reasonable Price.");
		driver.findElement(By.id("add-review")).click();
		driver.findElement(By.id("ui-id-5")).click();
		driver.findElement(By.id("ui-id-6")).click();
		driver.findElement(By.id("goToTop")).click();
		Thread.sleep(2000);
		
		//AddToWishlist
		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[15]/div[1]/div[1]/a[1]")).click();
		//AddToCart
		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/input[1]")).clear();
		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/input[1]")).sendKeys("2");
		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[15]/div[1]/div[1]/a[1]")).click();
		WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
		action.moveToElement(shoppingCart).build().perform();
		Thread.sleep(4000);
	}
	
	@Test
	public void wishlistTest() throws Exception {
		driver.findElement(By.xpath("//span[contains(text(),'Wishlist')]")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[15]/div[2]/div[3]/div[1]/input[1]")).click();

		//Quantity
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/input[1]")).clear();
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")).click();

		//AddToCart
		driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[2]")).click();
//		//ShoppingCart
//		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/input[1]")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(4000);
	}		
	
	@Test
	public void checkoutTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Vrajdham Society");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Vapi");
		js.executeScript("scroll(0,650)");
		Thread.sleep(4000);
		WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("gu");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("396193");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("7600768118");
		js.executeScript("scroll(0,650)");
		driver.findElement(By.id("goToTop")).click();
		driver.findElement(By.id("ShipToSameAddress_ship")).click();
		js.executeScript("scroll(0,650)");
		driver.findElement(By.id("step1-continue")).click();
		driver.findElement(By.id("checkout-shipping-method-btn")).click();

		//CardDetails
		driver.findElement(By.id("CardholderName")).sendKeys("Test Card");
		driver.findElement(By.id("CardNumber")).sendKeys("4030000010001234");
		WebElement month = driver.findElement(By.id("ExpireMonth"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("06");
		driver.findElement(By.id("CardCode")).sendKeys("123");
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/ol[1]/li[3]/div[2]/div[1]/div[3]/input[1]")).click();
		Thread.sleep(3000);
		//ConfirmOrder
		//driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[3]/ol[1]/li[4]/div[2]/div[3]/input[1]")).click();
		driver.findElement(By.id("goToTop")).click();
		Thread.sleep(2000);
		
		//Home
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		Thread.sleep(1000);
		
		driver.quit();
	}
	
	@Ignore
	@Test
	public void test() throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Vishal@26");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]")).click();
		Thread.sleep(2000);
		
		//AddToCart
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//body/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[2]")).click();
//		Thread.sleep(2000);
//		//ShoppingCart
//		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/input[1]")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//body[1]/div[9]/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/input[1]")).sendKeys("1");
//		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(4000);
	}	
	
}
