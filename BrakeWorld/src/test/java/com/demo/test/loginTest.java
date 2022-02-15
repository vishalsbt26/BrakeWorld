package com.demo.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {

	WebDriver driver;
	@Test
	public void browserTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://www.brakeworld.com/");
	}
	
	@DataProvider
	public Object[][] dataTest() {
		Object data[][] = dataSupplier.getData("login");
		return data;
	}
	
	@Test(dataProvider = "dataTest")
	public void login(String username, String password) throws Exception {
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void exitTest() {
		driver.quit();
	}

}
