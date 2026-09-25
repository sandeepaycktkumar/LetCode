package project;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grooming {
	WebDriver driver;
    @BeforeTest
    public void launch()
    {

	       driver = new ChromeDriver();
        driver.get("https://letcode.in/test-practice");
        driver.manage().window().maximize();
	      
	    }
    @Test(priority = 1,enabled = true)
    public void verifyNavigation()
    {
    	String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://letcode.in/test-practice"));
    }
    @Test(priority = 2,enabled = true)
    public void verifyHeading()
    {
    	String heading=driver.findElement(By.tagName("h1")).getText();
    	Assert.assertTrue(heading.contains("Test Practice Scenarios"));
    	String para=driver.findElement(By.xpath("//p[contains(text(),'Enhance your automation coding ')]")).getText();
    	Assert.assertTrue(para.contains("Enhance your automation coding confidence by scripting real-world test cases."));
    }
    @Test(priority = 3,enabled = true)
    public void verifyPrecondition()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Pre-Condition']")).getText();
    	Assert.assertTrue(heading.contains("Pre-Condition"));
    	String para=driver.findElement(By.xpath("//h3[contains(text(),'Create a Service Now Instance')]")).getText();
    	Assert.assertTrue(para.contains("Create a Service Now Instance and start Practice"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Pre-Condition']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=t1etgfBmBf8']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }
    @Test(priority = 4,enabled = true)
    public void verifyPositiveNegative()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Login Positive & Negative']")).getText();
    	Assert.assertTrue(heading.contains("Login Positive & Negative"));
    	String para=driver.findElement(By.xpath("//h3[contains(text(),'Login Positive')]")).getText();
    	Assert.assertTrue(para.contains("Login Positive"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Login Positive & Negative']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=NKFBGpQ4EPY']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
	  
    }
    @Test(priority = 5,enabled = true)
    public void verifyForgotPassword()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Forgot Password']")).getText();
    	Assert.assertTrue(heading.contains("Forgot Password"));
    	String para=driver.findElement(By.xpath("//h3[contains(text(),'Forgot Password Flow')]")).getText();
    	Assert.assertTrue(para.contains("Forgot Password Flow"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Forgot Password']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=DIQqgm3qU7o']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }
    @Test(priority = 6,enabled = true)
    public void verifyCreateIncident()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Create Incident']")).getText();
    	Assert.assertTrue(heading.contains("Create Incident"));
    	String para=driver.findElement(By.xpath("//h3[contains(text(),'Incident Creation')]")).getText();
    	Assert.assertTrue(para.contains("Incident Creation"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Create Incident']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=3V8ejGFa5A0']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }
   /* @Test(priority = 7,enabled = true)
    public void verifyComputerDatabase()
    {
    	//String heading=driver.findElement(By.xpath("//h2[contains(text(),'Computer Database')]")).getText();
    	//Assert.assertTrue(heading.contains("Computer Database"));
    	String para=driver.findElement(By.xpath("//h3[contains(text(),'Database Interaction')]")).getText();
    	Assert.assertTrue(para.contains("Database Interaction"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Computer Database']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=N9uJlLaSR5M']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }*/
    @Test(priority = 8,enabled = true)
    public void verifyQANavigation()
    {
    	driver.navigate().to("https://letcode.in/interview");
    	String title=driver.getTitle();
        Assert.assertTrue(title.contains("Interview Questions | LetCode with Koushik"));
    }
    @Test(priority = 9,enabled = true)
    public void verifyQAHeading()
    {
    	String heading=driver.findElement(By.tagName("h1")).getText();
    	System.out.println(heading);
    	Assert.assertTrue(heading.contains("Interview Q & A"));
    }
    @Test(priority = 10,enabled = true)
    public void verifyQA1()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Q & A Part 1']")).getText();
    	Assert.assertTrue(heading.contains("Q & A Part 1"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Q & A Part 1']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=hQvU3DW8T_k']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }
    @Test(priority = 11,enabled = true)
    public void verifyQA2()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Q & A Part 2']")).getText();
    	Assert.assertTrue(heading.contains("Q & A Part 2"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Q & A Part 2']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("//a[@href='https://www.youtube.com/watch?v=i-t7COgw7_o']"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }
    @Test(priority = 12,enabled = true)
    public void verifyQA3()
    {
    	String heading=driver.findElement(By.xpath("//h2[text()='Q & A Part 3']")).getText();
    	Assert.assertTrue(heading.contains("Q & A Part 3"));
    	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Q & A Part 3']"));
        driver.switchTo().frame(frame);
        WebElement element=driver.findElement(By.xpath("https://www.youtube.com/watch?v=BLhHxj9YqLw"));
        String mainwindow=driver.getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
    	
     	Set<String> allWindows = driver.getWindowHandles();
     	for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Tutorial isn't enough! Selenium Practice Site | Test Automation - YouTube"));
		    }
		  
		}  
		 driver.close();
	    driver.switchTo().window(mainwindow);
    }

}
