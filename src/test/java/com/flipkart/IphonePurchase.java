package com.flipkart;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IphonePurchase {
	static WebDriver driver;
	static long start;
	
	@BeforeClass
	public static void browserLaunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();  
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println("Browser Launched");
	}
	
	@AfterClass
	public static void browserQuit() {
		driver.quit();
	}
	@BeforeMethod
	public void startTime() {
		start = System.currentTimeMillis();
		System.out.println("Before");
	}
	@AfterMethod
	public void endTime() {
		long end = System.currentTimeMillis();
		System.out.println("Running time "+(end - start));
	}
	@Test (priority =-2)
	public void popHandle() {
		
		try {
			driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l') and contains(@class,'_2doB4z')]")).click();
		}
		catch (Exception e) {
			
		}
		System.out.println("Method1 executed");

	}
	@Test (priority =-1)
	public void productSearch() throws InterruptedException {
		Thread.sleep(5000);
		try {
            driver.findElement(By.xpath("//button[contains(text(),'X')]")).click();
        } catch (Exception e) {
            
        }
		
		WebElement search =driver.findElement(By.xpath("//input[@type=\"text\"]"));
		search.sendKeys("Iphone");
		search.sendKeys(Keys.ENTER);
		System.out.println("Method2 executed");
	}
	@Test(priority =0)
	public void selectProduct() {
		driver.findElement(By.xpath("//div[text()='Apple iPhone 14 (Starlight, 128 GB)']")).click();
		System.out.println("Method3 executed");
		
	}
	@Test (priority =1)
	public void windowHandle() {
		String Pwin =driver.getWindowHandle();
		Set<String> allwin =driver.getWindowHandles();
		
		for(String x: allwin) {
			if (!x.equals(Pwin)) {
				driver.switchTo().window(x);
			}
		}
		
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		System.out.println("Method4 executed");
	}
	@Test (priority =2)
	public void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File ("C:\\Users\\Divyalakshmi\\eclipse-workspace\\JunitProject\\target\\dvya.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Method5 executed");
	}

}
