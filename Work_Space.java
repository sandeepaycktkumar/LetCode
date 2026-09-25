package project;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Work_Space {

	WebDriver driver;
    @BeforeTest
    public void launch()
    {

	       driver = new ChromeDriver();
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
	      
	    }
    @Test(priority = 1,enabled = true)
    public void verifyNavigation()
    {
    	String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://letcode.in/test"));
    }
    @Test(priority = 2,enabled = true)
    public void verifyHeading()
    {
    	String heading1=driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(heading1.contains("Practice Workspace"));
		String heading2=driver.findElement(By.tagName("p")).getText();
		Assert.assertTrue(heading2.contains("Choose from 21 interactive compliance sandboxes to build, debug, and run Selenium, Playwright, and Cypress tests"));
		
    }
    @Test(priority = 3,enabled = true)
    public void verifySearch()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement searchElement =driver.findElement(By.xpath("//input[@type='text']"));
    	Assert.assertTrue(searchElement.isDisplayed());
    	Assert.assertTrue(searchElement.isEnabled());
    	searchElement.sendKeys("Button");
    	driver.navigate().refresh();
    	//WebElement searchElement2 =driver.findElement(By.xpath("//input[@type='text']"));
    	searchElement = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//input[@type='text']")));
    	searchElement.sendKeys("Alex");
    	String errormsg=driver.findElement(By.xpath("//p[text()='No practice labs matched your search.']")).getText();
    	Assert.assertTrue(errormsg.contains("No practice labs matched your search."));
    	driver.navigate().refresh();
    	
    }
    @Test(priority = 4,enabled = true)
    public void verifyInputEditField()
    {
    	String heading=driver.findElement(By.xpath("//h3[text()='Edit Fields']")).getText();
    	Assert.assertTrue(heading.contains("Edit Fields"));
        WebElement element=driver.findElement(By.xpath("//a[@href='/edit']"));	
        JavascriptExecutor js =(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",element);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Edit Fields | LetCode with Koushik"));
        String heading2=driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(heading2.contains("Input"));
        String heading3=driver.findElement(By.xpath("//label[@for='fullName']")).getText();
       Assert.assertTrue(heading3.contains("Enter your full Name"));
       driver.findElement(By.id("fullName")).sendKeys("Ananthu");
       String heading4=driver.findElement(By.xpath("//label[@for='join']")).getText(); 
       Assert.assertTrue(heading4.contains("Append a text and press keyboard tab"));
     // String text1=driver.findElement(By.id("join")).getText();
       //System.out.println(text1);
       String heading5=driver.findElement(By.xpath("//label[@for='clearMe']")).getText(); 
       Assert.assertTrue(heading5.contains("Clear the text"));
     // String text= driver.findElement(By.id("clearMe")).getText();
      //System.out.println(text);
       driver.findElement(By.id("clearMe")).clear();
       String heading6=driver.findElement(By.xpath("//label[@for='dontwrite']")).getText(); 
       Assert.assertTrue(heading6.contains("Confirm text is readonly"));
       WebElement element3=driver.findElement(By.id("noEdit"));
       Assert.assertFalse(element3.isEnabled());
       String heading7=driver.findElement(By.tagName("h3")).getText();
       Assert.assertTrue(heading7.contains("Learning Points"));
       WebElement element2=driver.findElement(By.linkText("Watch Tutorial"));
       js.executeScript("arguments[0].click();",element2);
       String url=driver.getCurrentUrl();
       Assert.assertTrue(url.contains("https://letcode.in/video/edit"));
    }
    @Test(priority = 5,enabled = true)
    public void verifyAlert()
    {
    	driver.navigate().to("https://letcode.in/test");
    	String heading=driver.findElement(By.xpath("//h3[text()='Dialog Box']")).getText();
    	Assert.assertTrue(heading.contains("Dialog Box"));
    	WebElement element= driver.findElement(By.xpath("//a[@href='/alert']"));
    	Assert.assertTrue(element.isEnabled());
    	 JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	String title =driver.getTitle();
     	Assert.assertTrue(title.contains("Alert | LetCode with Koushik"));
     	WebElement element2=driver.findElement(By.id("accept"));
     	Assert.assertTrue(element2.isEnabled());
     	element2.click();
     	driver.switchTo().alert().accept();
     	WebElement element3 =driver.findElement(By.id("prompt"));
        Assert.assertTrue(element3.isEnabled());
        element3.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Anil");
        alert.accept();
        String name=driver.findElement(By.id("myName")).getText();
        Assert.assertTrue(name.contains("Anil"));
        WebElement element4=driver.findElement(By.linkText("Watch Tutorial"));
        js.executeScript("arguments[0].click();",element4);
        String url=driver.getCurrentUrl();
        //Assert.assertTrue(url.contains("https://letcode.in/video/edit"));
    }
    @Test(priority = 6,enabled = true)
    public void verifyButton()
    {
    	driver.navigate().to("https://letcode.in/test");
    	String heading=driver.findElement(By.xpath("//h3[text()='Click Actions']")).getText();
    	Assert.assertTrue(heading.contains("Click Actions"));
    	WebElement element= driver.findElement(By.xpath("//a[@href='/button']"));
    	Assert.assertTrue(element.isEnabled());
    	 JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	String title =driver.getTitle();
     	Assert.assertTrue(title.contains("Buttons | LetCode with Koushik"));
     	WebElement element2=driver.findElement(By.id("home"));
     	Assert.assertTrue(element2.isEnabled());
     	js.executeScript("arguments[0].click();",element2);
     	String title2=driver.getTitle();
     	Assert.assertTrue(title2.contains("LetCode with Koushik | Software Test Automation Hub"));
     	driver.navigate().to("https://letcode.in/button");
     	Point location=driver.findElement(By.id("position")).getLocation();
     	System.out.println(location);
     	//Assert.assertTrue(location.equals("(125, 349)"));
     	WebElement element3=driver.findElement(By.id("color"));
        String color=	element3.getCssValue("color");
        System.out.println(color);
        WebElement element4=driver.findElement(By.id("isDisabled"));
        Assert.assertFalse(element4.isEnabled());
        WebElement button=driver.findElement(By.linkText("Watch Tutorial"));
        js.executeScript("arguments[0].click();",button);
     	
    }
    @Test(priority = 7,enabled = true)
    public void verifyDropDowns()
    {
    	driver.navigate().to("https://letcode.in/test");
    	String heading=driver.findElement(By.xpath("//h3[text()='Drop-Down']")).getText();
    	Assert.assertTrue(heading.contains("Drop-Down"));
    	WebElement element= driver.findElement(By.xpath("//a[@href='/dropdowns']"));
    	Assert.assertTrue(element.isEnabled());
    	 JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	String title =driver.getTitle();
     	Assert.assertTrue(title.contains("Dropdowns | LetCode with Koushik"));
     	WebElement dropdown=driver.findElement(By.id("fruits"));
     	Select s=new Select(dropdown);
     	s.selectByVisibleText("Apple");
     	WebElement dropdown2=driver.findElement(By.id("superheros"));
     	Select s2=new Select(dropdown2);
     	s2.selectByValue("sm");
     	WebElement dropdown3=driver.findElement(By.id("lang"));
     	Select s3=new Select(dropdown3);
     	s3.selectByValue("sharp");
     	List<WebElement> options = s3.getOptions();

     	for (WebElement option : options) 
     	{
     	    System.out.println(option.getText());
     	}
     	WebElement dropdown4=driver.findElement(By.id("country"));
     	Select s4=new Select(dropdown4);
     	s4.selectByValue("India");
     	WebElement selected = s4.getFirstSelectedOption();
        System.out.println(selected.getText());
     }
    @Test(priority = 8,enabled = true)
    public void verifyNestedFrame()
    {
    	driver.navigate().to("https://letcode.in/test");
    	String heading=driver.findElement(By.xpath("//h3[text()='Nested Frames']")).getText();
    	Assert.assertTrue(heading.contains("Nested Frames"));
    	WebElement element= driver.findElement(By.xpath("//a[@href='/frame']"));
    	Assert.assertTrue(element.isEnabled());
    	 JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	String title =driver.getTitle();
     	Assert.assertTrue(title.contains("Frame | LetCode with Koushik"));
     	driver.switchTo().frame("firstFr");
     	driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Alex");
     	driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Pandian");
     	WebElement frame = driver.findElement(By.xpath("//iframe[@title='Inner Frame']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("alexpandian@gmail.com");
     	}
    @Test(priority = 9,enabled = true)
    public void verifyWindowHandler() throws InterruptedException
    {
    	driver.navigate().to("https://letcode.in/test");
    	String heading=driver.findElement(By.xpath("//h3[text()='Tabs Handler']")).getText();
    	Assert.assertTrue(heading.contains("Tabs Handler"));
    	WebElement element= driver.findElement(By.xpath("//a[@href='/window']"));
    	Assert.assertTrue(element.isEnabled());
    	 JavascriptExecutor js =(JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();",element);
     	String title =driver.getTitle();
     	Assert.assertTrue(title.contains("Windows | LetCode with Koushik"));
     	WebElement element1=driver.findElement(By.id("home"));
     	String mainwindow=driver.getWindowHandle();
     	js.executeScript("arguments[0].click();",element1);
      	Set<String> allWindows1 = driver.getWindowHandles();
		
		for(String window : allWindows1)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	Thread.sleep(2000);
		    	driver.close();
		    }
		    driver.switchTo().window(mainwindow);
		}  
		WebElement element2=driver.findElement(By.id("multi"));
		js.executeScript("arguments[0].click();",element2);
      	Set<String> allWindows2 = driver.getWindowHandles();
      	for(String window : allWindows2)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	Thread.sleep(2000);
		    	driver.close();
		    }
		    driver.switchTo().window(mainwindow);
		}  
    }
}
