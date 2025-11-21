package com.flipkart;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TvPurchase {
	
	@DataProvider (name="TV")
	public Object[][] tvName(){
		return new Object[][] {{"Samsung TV"}};
	}
	static WebDriver driver;
	static long start;

@Parameters("URL")	
@BeforeClass
	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Browser Launch");
	}

@AfterClass
	public static void browserQuit() {
//		driver.quit();
		System.out.println("Browser Quit");
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

@Test (priority =0)
	public void popupWindow() {
		try {
			driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l') and contains(@class,'_2doB4z')]")).click();
		}
		catch (Exception e) {
			
		}
		System.out.println("Method1 executed");
		}

@Test (priority = 1, dataProvider="TV")
	public void search(String name) throws InterruptedException {
	Thread.sleep(5000);
	try {
        driver.findElement(By.xpath("//button[contains(text(),'X')]")).click();
    } catch (Exception e) {
        
    }
	
	WebElement search =driver.findElement(By.xpath("//input[@type=\"text\"]"));
	search.sendKeys(name);
	search.sendKeys(Keys.ENTER);
	System.out.println("Method2 executed");
	}

@Test (priority = 2)
	public void selectTv() {
		driver.findElement(By.xpath("//div[text()=\"Samsung 80 cm (32 inch) HD Ready LED Smart Tizen TV 2025 Edition with Voice Assistance Remote Control ...\"]")).click();
		System.out.println("Method 3 executed");
	}

@Test (priority = 3)
	public void addProduct() {
		String Pwin=driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		
		for(String x: allwin) {
			if (!x.equals(Pwin)) {
				driver.switchTo().window(x);
				}
		}
		driver.findElement(By.xpath("//button[text()=\"Add to cart\"]")).click();
		System.out.println("Method 4 executed");
	}


}