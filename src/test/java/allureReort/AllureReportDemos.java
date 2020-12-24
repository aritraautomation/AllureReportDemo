package allureReort;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("EP-90")
@Feature("Validation demo.nopcommerce.com website")
public class AllureReportDemos {
		WebDriver driver;
		
	@BeforeMethod
	@Severity(SeverityLevel.TRIVIAL)
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1,description="validation Image Presense")
	@Severity(SeverityLevel.NORMAL)
	public void imagePresense(){
		boolean imageLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest(){
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Assert.assertEquals(driver.getTitle(),"nopCommerce demo store");
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.CRITICAL)
	public void registrationTest(){
		throw new SkipException("Skipping the Test");
	}
	
	@AfterMethod
	@Severity(SeverityLevel.NORMAL)
	public void tearDown(){
		driver.quit();
	}
	

}
