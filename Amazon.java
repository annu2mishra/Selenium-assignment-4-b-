      
package com.ibm.SeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {


	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,60);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Laptops");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> linksEle = driver.findElements(By.tagName("a"));
		int noOffLinks= linksEle.size();
		
		System.out.println(noOffLinks);
		
		for(int i=0; i<noOffLinks;i++)
		{
			WebElement linkEle= linksEle.get(i);
					
					String link= linkEle.getAttribute("href");
					System.out.println(link);
					
					String text = linkEle.getText();
					System.out.println(text);
					
							
					
		}		
			
			
		
			
		{
			
		}
			
		
		
		
		
		
	
		
		
		
}
}