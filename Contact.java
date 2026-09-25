package project;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

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

public class Contact {
	WebDriver driver;
    @BeforeTest
    public void launch()
    {

	       driver = new ChromeDriver();
        driver.get("https://letcode.in/contact");
        driver.manage().window().maximize();
	      
	    }
    @Test(priority = 1,enabled = true)
    public void verifyNavigation()
    {
    	String url=driver.getCurrentUrl();
    	Assert.assertTrue(url.contains("https://letcode.in/contact"));
    }
    @Test(priority = 2,enabled = true)
    public void verifyLogo()
    {
    	WebElement logo = driver.findElement(By.xpath("//img[@alt='LetCode logo']"));
    	Assert.assertTrue(logo.isDisplayed());
    	String heading=driver.findElement(By.tagName("h1")).getText();
    	Assert.assertTrue(heading.contains("Koushik Chatterjee"));

    }
    @Test(priority = 3,enabled = true)
    public void verifyEmail()
    {
    	WebElement emailElement=driver.findElement(By.xpath("//span[text()='koushik350@gmail.com']"));
    	Assert.assertTrue(emailElement.isDisplayed());
    	//WebElement iconElement=driver.findElement(By.xpath("//svg[contains(@class,'lucide-copy')]"));
    	//Assert.assertTrue(iconElement.isEnabled());
    			
    }
    @Test(priority = 4,enabled = true)
    public void verifyLinkedin()
    {
    	String mainwindow=driver.getWindowHandle();
    	driver.findElement(By.xpath("//a[@title='LinkedIn']")).click();
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	Assert.assertTrue(title.contains("Sign Up | LinkedIn"));
		    }
		} 
		driver.close();
		driver.switchTo().window(mainwindow);
		
    }
    @Test(priority = 5,enabled = true)
    public void verifyGitHub()
    {
    	driver.navigate().refresh();
    	String mainwindow1=driver.getWindowHandle();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='GitHub']")));
    	WebElement element=driver.findElement(By.xpath("//a[@title='GitHub']"));
    	JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	Set<String> allWindows1 = driver.getWindowHandles();
		
		for(String window : allWindows1)
		{
		    
		    if(!window.equals(mainwindow1))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	Assert.assertTrue(title.contains("ortoniKC (Koushik Chatterjee) · GitHub"));
		    }
		} 

		driver.switchTo().window(mainwindow1);
		
		
    }
    @Test(priority = 6,enabled = true)
    public void verifySupportWork()
    {
    	WebElement element1= driver.findElement(By.xpath("//a[@href='https://buymeacoffee.com/letcode']"));
    	Assert.assertTrue(element1.isEnabled());
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
		    	//Assert.assertTrue(title.contains("LetCode with Koushik is Content creator at LetCode with Koushik - Youtube channel"));
		    }
		}    
    }

}
