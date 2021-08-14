package org.desiredcapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchApp {
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		WebDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel 5 API 24"); // Emulator Device Name
		cap.setCapability("platformName", "Android");  // Platform name (Android or IOS)
		cap.setCapability("platformVersion", "7.0");   // Platform Version (Software version)
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome"); // Browser type (Chrome/Firefox/Edge)
		 
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Connecting to Appium Server & Driver will invoke
		System.out.println("***** Android Chrome Browser Launch *****");
		
		// Launching URL (Amazon)
		driver.get("https://www.amazon.in");
		System.out.println("****** Successfully Amazon URL is launched in Chrome Browser *****");
		Thread.sleep(10000);
		
		// Searching Product
		WebElement searchbox = driver.findElement(By.xpath("//input[contains(@id,'search-keywords')]"));
		searchbox.click();
		Thread.sleep(2000);
		searchbox.sendKeys("iphone");
		System.out.println("***** Searching iphone product *****");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@aria-label='Go']"));
		searchbtn.click();
		System.out.println("***** Click search button *****");
		Thread.sleep(10000);
		
		//Click Product
		WebElement product = driver.findElement(By.xpath("//img[@class='s-image'][1]"));
		product.click();
		System.out.println("***** Click on product *****");
		Thread.sleep(10000);
		
		//Add to cart
		WebElement addtocart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addtocart.click();
		System.out.println("***** Click on add to cart *****");
		System.out.println("***** Successfully product added into cart *****");
	}
	
}
