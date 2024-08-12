package funcTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {
	public static void main(String[] args) throws Exception {
		
	   ScreenRecorderUtil.startRecord("main");	
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       driver.get("https://demo.dealsdray.com/");
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
       WebElement btnUserName = driver.findElement(By.xpath("//input[@name='username']"));
       btnUserName.sendKeys("prexo.mis@dealsdray.com");
       
       WebElement btnPassword = driver.findElement(By.xpath("//input[@name='password']"));
       btnPassword.sendKeys("prexo.mis@dealsdray.com");
	
	   WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
	   btnLogin.click();
	   
	   WebElement btnThreeDot = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[1]"));
	   btnThreeDot.click();

	   WebElement btnOrders = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
	   btnOrders.click();

	   WebElement btn2Order = driver.findElement(By.xpath("(//button[@name='child'])[2]"));
	   btn2Order.click();
	   
	   WebElement btnAddBulkOrder = driver.findElement(By.xpath("//button[@align='right']"));
	   btnAddBulkOrder.click();
	   
	   WebElement btnChooseFile = driver.findElement(By.xpath("//input[@type='file']"));
	   btnChooseFile.sendKeys("C:\\Users\\91978\\eclipse-workspace\\FunctionalTest\\File\\demo-data.xlsx");
	   
	   WebElement btnImport = driver.findElement(By.xpath("//button[text()='Import']"));
	   btnImport.click();
	   
	   WebElement btnValidateData = driver.findElement(By.xpath("//button[text()='Validate Data']"));
	   btnValidateData.click();
	   
	   Thread.sleep(3000);
	   Alert alert = driver.switchTo().alert();
	   alert.accept();
	   
	   TakesScreenshot screenshot = (TakesScreenshot) driver;
	   File src = screenshot.getScreenshotAs(OutputType.FILE);
	   File des = new File("C:\\Users\\91978\\eclipse-workspace\\FunctionalTest\\Screenshot.png");
	   FileUtils.copyFile(src, des);
	   
	   ScreenRecorderUtil.stopRecord();
	   

	}

}


