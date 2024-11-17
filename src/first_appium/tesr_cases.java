package first_appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class tesr_cases {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	String appiumUrl = "http://127.0.0.1:4723/wd/hub";
	
	AndroidDriver driver;
	
	@BeforeTest
	public void Setup() {
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"testDevice");
		File myApplication = new File("src/aplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP,myApplication.getAbsolutePath());
		
		
	}
	
	
	@Test(priority = 1 ,enabled = false)
	public void addTest() throws MalformedURLException {
		
		driver = new AndroidDriver(new URL(appiumUrl)  ,caps);
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		
		
	}
	
	@Test(priority = 2 ,enabled = false)
	public void clickAllTest() throws MalformedURLException {
		
		driver = new AndroidDriver(new URL(appiumUrl)  ,caps);
		
		List<WebElement> imageButtons = driver.findElements(By.cssSelector("android.widget.ImageButton"));
		
		
		for (int i = 0; i < imageButtons.size(); i++) {
			
			if(imageButtons.get(i).getAttribute("resource-id").contains("digit"))
			imageButtons.get(i).click();
		}
		
		String expectedResule = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		String actualResult = "7894561230";
		Assert.assertEquals(expectedResule, actualResult);
	}
	
	@Test(priority = 2 ,enabled = true)
	public void clickOnEvenTest() throws MalformedURLException {
		
		driver = new AndroidDriver(new URL(appiumUrl)  ,caps);
		
		
		
		
		for (int i = 0; i < 9; i+=2) {
			
			String idNum = "com.google.android.calculator:id/digit_" + i;
			driver.findElement(By.id(idNum)).click();
		}
		
		String expectedResule = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		String actualResult = "02468";
		Assert.assertEquals(expectedResule, actualResult);
	}

}
