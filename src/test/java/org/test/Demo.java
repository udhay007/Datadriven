package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	WebDriver driver;
	@BeforeMethod
	public void browserconf() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/");
	}
	@Test(dataProvider="datas")
	public void openmethod(String user, String pass) {
		WebElement txtuser = driver.findElement(By.name("username"));
		txtuser.sendKeys(user);
		
		WebElement txtpass = driver.findElement(By.name("password"));
		txtpass.sendKeys(pass);
		
		WebElement btn = driver.findElement(By.xpath(" //button[contains(@type,'submit')]"));
        btn.click();
		
	}
	
	@DataProvider(name="datas")
	public Object[][] data() {
		return new Object[][] {
			
			
			{"user1","password1"},
			{"user2","password2"},
			{"user3","password3"},
			{"user4","password4"}
		

	};
	}
	//main using website alone using the code
	
	
	@AfterMethod
	public void closebrowser() {
		driver.close();

	}
	
	

}
