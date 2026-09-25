package project;


	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


	public class Courses{
		WebDriver driver;
       @BeforeTest
       public void launch()
       {

	       driver = new ChromeDriver();
           driver.get("https://letcode.in/courses");
           driver.manage().window().maximize();
	      
	    }
       @Test(priority = 1)
       public void verifyNavigation()
       {
      	 String url =driver.getCurrentUrl();
      	 Assert.assertTrue(url.contains("https://letcode.in/courses"));
       }
       @Test(priority = 2)
       public void verifySeleniumPlaywright()
       {
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   WebElement element1=driver.findElement(By.linkText("View Course"));
    	   JavascriptExecutor js =(JavascriptExecutor) driver;
       	js.executeScript("arguments[0].click();",element1);
    	  String title=driver.getTitle();
    	 Assert.assertTrue(title.contains("Selenium VS Playwright | LetCode with Koushik"));
    	  
    	   
    	 WebElement fname = driver.findElement(By.xpath("//iframe[contains(@src,'youtube.com/embed/videoseries')]"));

    			driver.switchTo().frame(fname);
    			wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ytp-large-play-button")));
    			//driver.findElement(By.cssSelector(".ytp-large-play-button")).click();
    	  //driver.findElement(By.xpath("//div[@id='player-control-overlay']")).click();
    	   WebElement element2= driver.findElement(By.cssSelector(".ytp-large-play-button"));
       	    js.executeScript("arguments[0].click();",element2);
       }
       @Test(priority = 2)
       public void verifyNPMpackage()
       {
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   driver.findElement(By.xpath("//a[@href='/course/npm-package']")).click();
    	   String title=driver.getTitle();
    	   Assert.assertTrue(title.contains("NPM Package - Ortoni Report | LetCode with Koushik")); 
    	   WebElement fname = driver.findElement(By.xpath("//iframe[@title='NPM Package - Ortoni Report English Playlist']"));

			driver.switchTo().frame(fname);
			//driver.findElement(By.xpath("//button[@title='Play video']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[@title='Play video']")));
			driver.findElement(By.xpath("//button[@title='Play video']")).click();
       }
       @Test(priority = 3)
       public void verifyJavaBasics()
       {
    	   driver.findElement(By.xpath("//a[@href='/course/java']")).click();
    	   String title=driver.getTitle();
    	  Assert.assertTrue(title.contains("Courses | LetCode with Koushik")); 
       }
}
