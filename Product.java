package project;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Product {
	WebDriver driver;
    @BeforeTest
    public void launch()
    {

	       driver = new ChromeDriver();
        driver.get("https://letcode.in/product/ortoni-report");
        driver.manage().window().maximize();
	      
	    }
    @Test(priority = 1,enabled = true)
    public void verifyNavigation()
    {
    	String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://letcode.in/product/ortoni-report"));
    }
    @Test(priority = 2,enabled = true)
    public void verifyHeading()
    {
    	String heading=driver.findElement(By.tagName("h1")).getText();
    	Assert.assertTrue(heading.contains("Ortoni Report"));
    	String para=driver.findElement(By.xpath("//p[contains(text(),'A visually stunning HTML')]")).getText();
    	Assert.assertTrue(para.contains("A visually stunning HTML report generator built specifically for Playwright tests"));
    }
    @Test(priority = 3,enabled = true)
    public void verifyImage()
    {
    	WebElement image = driver.findElement(By.xpath("//img[@alt='Ortoni Report Preview']"));
    	Assert.assertTrue(image.isDisplayed());
    }
    @Test(priority = 4,enabled = true)
    public void verifyKeyFeatures()
    {
    	String heading1 =driver.findElement(By.xpath("//span[text()='Key Features']")).getText();
    	Assert.assertTrue(heading1.contains("Key Features"));
    	String heading2 =driver.findElement(By.xpath("//h3[text()='Hierarchical Grouping']")).getText();
    	Assert.assertTrue(heading2.contains("Hierarchical Grouping"));
    	String para1=driver.findElement(By.xpath("//p[text()='Organize tests by files, suites, and nesting levels cleanly.']")).getText();
    	Assert.assertTrue(para1.contains("Organize tests by files, suites, and nesting levels cleanly."));
    	String heading3 =driver.findElement(By.xpath("//h3[text()='Flexible Configuration']")).getText();
    	Assert.assertTrue(heading3.contains("Flexible Configuration"));
    	String para2=driver.findElement(By.xpath("//p[text()='Supports custom titles, project names, and output paths.']")).getText();
    	Assert.assertTrue(para2.contains("Supports custom titles, project names, and output paths."));
    	String heading4 =driver.findElement(By.xpath("//h3[text()='Filtering & Search']")).getText();
    	Assert.assertTrue(heading4.contains("Filtering & Search"));
    	String para3=driver.findElement(By.xpath("//p[text()='Instantly filter skipped, failed, or specific tests with search bounds.']")).getText();
    	Assert.assertTrue(para3.contains("Instantly filter skipped, failed, or specific tests with search bounds."));
    	String heading5 =driver.findElement(By.xpath("//h3[text()='Dashboard & Insights']")).getText();
    	Assert.assertTrue(heading5.contains("Dashboard & Insights"));
    	String para4=driver.findElement(By.xpath("//p[text()='Detailed summary charts and status trends for test cycles.']")).getText();
    	Assert.assertTrue(para4.contains("Detailed summary charts and status trends for test cycles."));
    	String heading6 =driver.findElement(By.xpath("//h3[text()='Themes & Branding']")).getText();
    	Assert.assertTrue(heading6.contains("Themes & Branding"));
    	String para5=driver.findElement(By.xpath("//p[text()='Light/dark configuration with option for custom logo display.']")).getText();
    	Assert.assertTrue(para5.contains("Light/dark configuration with option for custom logo display."));
    	String heading7 =driver.findElement(By.xpath("//h3[text()='Themes & Branding']")).getText();
    	Assert.assertTrue(heading7.contains("Themes & Branding"));
    	String para6=driver.findElement(By.xpath("//p[text()='Light/dark configuration with option for custom logo display.']")).getText();
    	Assert.assertTrue(para6.contains("Light/dark configuration with option for custom logo display."));
    	String heading8 =driver.findElement(By.xpath("//h3[text()='Detailed Attachments']")).getText();
    	Assert.assertTrue(heading8.contains("Detailed Attachments"));
    	String para7=driver.findElement(By.xpath("//p[text()='Embedded trace logs, screenshots, and videos on test details.']")).getText();
    	Assert.assertTrue(para7.contains("Embedded trace logs, screenshots, and videos on test details."));
    	
    	
    }
    @Test(priority = 5,enabled = true)
    public void verifyInstallation()
    {
    	String heading1 =driver.findElement(By.xpath("//span[text()='Installation & Configuration']")).getText();
    	Assert.assertTrue(heading1.contains("Installation & Configuration"));
    	String steps1 =driver.findElement(By.xpath("//h3[text()='1. Install the package via npm']")).getText();
    	Assert.assertTrue(steps1.contains("1. Install the package via npm"));
    	String steps2 =driver.findElement(By.xpath("//h3[text()='2. Configure in ']")).getText();
    	Assert.assertTrue(steps2.contains("2. Configure in "));
    	String heading2 =driver.findElement(By.xpath("//span[text()='Using the Ortoni Report CLI']")).getText();
    	Assert.assertTrue(heading2.contains("Using the Ortoni Report CLI"));
    }
    @Test(priority = 6,enabled = true)
    public void verifySupportDeveloper()
    {
    	String heading1 =driver.findElement(By.xpath("//span[text()='Support the Developer']")).getText();
    	Assert.assertTrue(heading1.contains("Support the Developer"));
    	WebElement button=driver.findElement(By.linkText("Buy me a Coffee"));
    	Assert.assertTrue(button.isEnabled());
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",button);
    	
    	String mainwindow=driver.getWindowHandle();
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String url=driver.getCurrentUrl();
		    	Assert.assertTrue(url.contains("https://buymeacoffee.com/letcode"));
		    }
		} 
		driver.close();
    	driver.switchTo().window(mainwindow);
    }
    @Test(priority = 7,enabled = true)
    public void verifyXpathNavigation()
    {
    	driver.navigate().to("https://letcode.in/product/letxpath");
    	String title=driver.getTitle();
    	Assert.assertTrue(title.contains("LetXPath Chrome Extension | LetCode with Koushik"));
    }
    @Test(priority = 8,enabled = true)
    public void verifyHeading_IMG()
    {
    	String heading1=driver.findElement(By.tagName("h1")).getText();
    	Assert.assertTrue(heading1.contains("LetXPath Extension"));
    	WebElement img=driver.findElement(By.xpath("//img[@alt='LetXPath Developer Interface']"));
    	Assert.assertTrue(img.isDisplayed());
    	String heading2=driver.findElement(By.xpath("//span[text()='How to Use LetXPath']")).getText();
    	Assert.assertTrue(heading2.contains("How to Use LetXPath"));
    	String heading3=driver.findElement(By.xpath("//span[text()='Features & Capabilities']")).getText();
    	Assert.assertTrue(heading3.contains("Features & Capabilities"));
    }
    @Test(priority = 9,enabled = true)
    public void verifyDownload()
    {
    	WebElement button=driver.findElement(By.linkText("Download Extension"));
    	Assert.assertTrue(button.isDisplayed());
    	Assert.assertTrue(button.isEnabled());
    	String mainwindow=driver.getWindowHandle();
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",button);
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String url=driver.getCurrentUrl();
		    	//System.out.println(url);
		    	//Assert.assertTrue(url.contains("https://chromewebstore.google.com/detail/ortoni-studio/bekehlnepmijedippfibbmbglglbmlgk"));
		    }
		}  
		driver.close();
    	driver.switchTo().window(mainwindow);
    	
    }
    @Test(priority = 10,enabled = true)
    public void verifyVideoTutorial()
    {
    	WebElement button=driver.findElement(By.linkText("Video Tutorial"));
    	Assert.assertTrue(button.isDisplayed());
    	Assert.assertTrue(button.isEnabled());
    	String mainwindow=driver.getWindowHandle();
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",button);
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains("Ortoni Studio - video"));
		    }
		}  
		driver.close();
    	driver.switchTo().window(mainwindow);
    	
    }
    @Test(priority = 11,enabled = true)
    public void verifyGitHub()
    {
    	WebElement button=driver.findElement(By.linkText("View Source (GitHub)"));
    	Assert.assertTrue(button.isDisplayed());
    	Assert.assertTrue(button.isEnabled());
    	String mainwindow=driver.getWindowHandle();
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",button);
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String title=driver.getTitle();
		    	//Assert.assertTrue(title.contains(""));
		    }
		} 
		driver.close();
    	driver.switchTo().window(mainwindow);
    	
    }
    @Test(priority = 12,enabled = true)
    public void verifyPlayWrightNavigation()
    {
    	driver.navigate().to("https://letcode.in/product/playwright-runner");
    	String title=driver.getTitle();
    	Assert.assertTrue(title.contains("Playwright Runner VS Code Extension | LetCode with Koushik"));
    	
    }
    @Test(priority = 13,enabled = true)
    public void verifyHeading_IMGS()
    {
    	WebElement img=driver.findElement(By.xpath("//img[@alt='VS Code Settings JSON example']"));
    	Assert.assertTrue(img.isDisplayed());
    }
    @Test(priority = 14,enabled = true)
    public void verifyDownloadExtension()
    {
    	WebElement button=driver.findElement(By.linkText("Download Extension"));
    	Assert.assertTrue(button.isDisplayed());
    	Assert.assertTrue(button.isEnabled());
    	String mainwindow=driver.getWindowHandle();
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",button);
     	Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
		    
		    if(!window.equals(mainwindow))
		    {
		    	driver.switchTo().window(window);
		    	String url=driver.getCurrentUrl();
		    	System.out.println(url);
		    	
		    }
		}  
		driver.close();
    	driver.switchTo().window(mainwindow);
    	
    }
    	
    

}
