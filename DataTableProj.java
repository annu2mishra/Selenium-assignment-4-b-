package com.ibm.SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataTableProj {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./driver/IEDriverServer.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver,60);
		driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       
       driver.get("https://datatables.net");
     
       List<WebElement> rows =  (List<WebElement>) driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
       		
       int rowCount= rows.size();
       
       List<WebElement> cols= (List<WebElement>) driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
       		
       int colCount= cols.size();
       
      System.out.println("rows : " +rowCount);
      System.out.println("cols : " +colCount);
      
      int total=0;
      
      
      for (int i=1 ;i<=rowCount;i++)
      {
    	  
    	  int j= i+1;
       
      WebElement nameEle= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
      nameEle.click();
      
      WebElement salEle= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[1]/descendant::span[2]"));
      
      String salary= salEle.getText().trim().replace("$", "").replace(",", "");
      total= total+Integer.parseInt(salary);
      nameEle.click();             
		
      }
		System.out.println("Total salary in page1 = " +total);
		
		
	}

}
