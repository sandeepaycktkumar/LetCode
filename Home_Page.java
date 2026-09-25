package project;




import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v146.domsnapshot.model.RareStringData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home_Page {
	WebDriver driver;
	
         @BeforeTest
         public void setup()
         {
	     driver=new ChromeDriver();
		driver.get("https://letcode.in");
		driver.manage().window().maximize();
         }
        @Test(priority = 1)
         public void verifyNavigation()
         {
        	 String url =driver.getCurrentUrl();
        	 Assert.assertTrue(url.contains("https://letcode.in/"));
         }
         @Test(priority = 2)
         public void verifyHeading()
         {
		String heading1=driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(heading1.contains("Master Test Automation"));
		String heading2=driver.findElement(By.tagName("h2")).getText();
		Assert.assertTrue(heading2.contains("Structured Learning Paths"));
		
         }
         @Test(priority = 3)
         public void verifyStartPracticeButton()
         {	 
        	driver.findElement(By.xpath("//a[@href='/test']")).click();
        	String url= driver.getCurrentUrl();
        	//Assert.assertTrue(url.contains("https://letcode.in/test"));
         }
         @Test(priority = 4)
         public void verifyCourseButton()
         {
        	 driver.navigate().to("https://letcode.in");
        	 driver.findElement(By.linkText("Explore Free Courses")).click();
        	 String heading3=driver.findElement(By.tagName("h1")).getText();
        	 Assert.assertTrue(heading3.contains("Courses"));
         }
        @Test(priority = 5)
         public void verifyWorkSpace()
         {
        	 driver.navigate().to("https://letcode.in");
        	 String heading4=driver.findElement(By.xpath("//h3[text()='Interactive Practice Workspace']")).getText();
        	 Assert.assertTrue(heading4.contains("Interactive Practice Workspace"));
        	WebElement element= driver.findElement(By.xpath("//a[text()='Enter Workspace']"));
        	JavascriptExecutor js =(JavascriptExecutor) driver;
        	js.executeScript("arguments[0].click();",element);
        	 String url=driver.getCurrentUrl();
        	 Assert.assertTrue(url.contains("https://letcode.in/test"));
         }
        @Test(priority = 6)
         public void verifyFreeAutomationCourse()
         {
        	 driver.navigate().to("https://letcode.in");
        	 String heading=driver.findElement(By.xpath("//h3[text()='Free Automation Courses']")).getText();
        	 Assert.assertTrue(heading.contains("Free Automation Courses"));
        	WebElement element= driver.findElement(By.linkText("View Courses"));
        	JavascriptExecutor js =(JavascriptExecutor) driver;
        	js.executeScript("arguments[0].click();",element);
        	String title=driver.getTitle();
        	Assert.assertTrue(title.contains("Courses | LetCode with Koushik"));
         }
        @Test(priority = 7)
         public void verifyGrooming()
         {
        	 driver.navigate().to("https://letcode.in");
        	 String heading=driver.findElement(By.xpath("//h3[text()='Grooming & Quiz Sandboxes']")).getText();
        	 Assert.assertTrue(heading.contains("Grooming & Quiz Sandboxes"));
        	 WebElement element1= driver.findElement(By.linkText("Take Quiz"));
         	JavascriptExecutor js =(JavascriptExecutor) driver;
         	js.executeScript("arguments[0].click();",element1);
         	String url1=driver.getCurrentUrl();
         	Assert.assertTrue(url1.contains("https://letcode.in/pw-quiz"));
         	driver.navigate().back();
         	 WebElement element2= driver.findElement(By.linkText("Interview Prep"));
          	js.executeScript("arguments[0].click();",element2);
          	String url2=driver.getCurrentUrl();
          	Assert.assertTrue(url2.contains("https://letcode.in/interview"));
         }
         @Test(priority = 8)
         public void verifyResumeBuilder()
         {
        	 driver.navigate().to("https://letcode.in");
        	String heading=driver.findElement(By.xpath("//a[@href='/resume-builder']")).getText();
        	System.out.println(heading);
        	Assert.assertTrue(heading.contains("Build Resume"));
        	 WebElement element1= driver.findElement(By.linkText("Build Resume"));
         	JavascriptExecutor js =(JavascriptExecutor) driver;
         	js.executeScript("arguments[0].click();",element1);
         	String title=driver.getTitle();
         	Assert.assertTrue(title.contains("Resume Builder | LetCode with Koushik"));
         }
         @Test(priority = 9)
         public void verifyOpenSourceProjects()
         {
        	 driver.navigate().to("https://letcode.in");
        	 String heading=driver.findElement(By.xpath("//h3[text()='Open Source Projects']")).getText();
        	 Assert.assertTrue(heading.contains("Open Source Projects"));
        	 WebElement element1= driver.findElement(By.linkText("Ortoni Report"));
          	JavascriptExecutor js =(JavascriptExecutor) driver;
          	js.executeScript("arguments[0].click();",element1);
          	String url1=driver.getCurrentUrl();
          	Assert.assertTrue(url1.contains("https://letcode.in/product/ortoni-report"));
          	driver.navigate().back();
          	WebElement element2= driver.findElement(By.linkText("LetXPath"));
         	js.executeScript("arguments[0].click();",element2);
         	String title=driver.getTitle();
         	Assert.assertTrue(title.contains("LetXPath Chrome Extension | LetCode with Koushik"));
         	driver.navigate().back();
         	 WebElement element3= driver.findElement(By.linkText("PW Runner"));
           	js.executeScript("arguments[0].click();",element3);
           	String url2=driver.getCurrentUrl();
           	Assert.assertTrue(url2.contains("https://letcode.in/product/playwright-runner"));

         }
        @Test(priority=10)
         public void verifySupportYoutube()
         {
        	WebElement element1= driver.findElement(By.xpath("//a[@href='https://buymeacoffee.com/letcode']"));
        	JavascriptExecutor js =(JavascriptExecutor) driver;
         	js.executeScript("arguments[0].click();",element1);
         	String mainwindow=driver.getWindowHandle();
         	Set<String> allWindows = driver.getWindowHandles();
    		
    		for(String window : allWindows)
    		{
    		    
    		    if(!window.equals(mainwindow))
    		    {
    		    	driver.switchTo().window(window);
    		    	String title=driver.getTitle();
    		    	Assert.assertTrue(title.contains("LetCode with Koushik is Content creator at LetCode with Koushik - Youtube channel"));
    		    }
    		}    
         }
        @ AfterTest
         public void closeWindow() 
        {
        //driver.close();	
        }
	}


