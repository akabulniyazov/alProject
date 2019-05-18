package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class testMyWebsite {
	WebDriver driver;
	
	@Before
	public void beforeMethod() {
		System.out.println("1");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/akabu/Desktop/Techtorial.html");
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		System.out.println("2");
		Thread.sleep(3000);
		String welcomeText = driver.findElement(By.id("WelcomeText")).getText();
		System.out.println(welcomeText);
		String expectedText="Welcome to my Website";
		Assert.assertEquals(expectedText, welcomeText);
		Assert.assertFalse(!welcomeText.equals(expectedText));
		Assert.assertTrue(welcomeText.equals(expectedText));
	}
	@Test
	public void test2() throws InterruptedException {
		System.out.println("4");
		Thread.sleep(3000);
		List<WebElement> tableRows=driver.findElements(By.xpath("//*/tr"));
		tableRows.remove(0);
		for(WebElement element: tableRows) {
			System.out.println(element.getText());
		}
		
	}
	
	@After
	public void afterMethod() {
		System.out.println("3");
		driver.close();
	}
	
	

}
