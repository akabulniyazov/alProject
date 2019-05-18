package test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonTest {
	
	WebDriver driver;
	@Before
	public void beforeM() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
	}
	@Test
	public void test1() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("camera"+Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("p_89/Kodak"))).click();
		String searchText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sg-col-inner']//div[@class='a-section a-spacing-small a-spacing-top-small']"))).getText();
		System.out.println(searchText);
	}

}
