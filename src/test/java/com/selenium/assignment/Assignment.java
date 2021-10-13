package com.selenium.assignment;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	
		WebDriver driver;

		@Test
		public void JAQUILINE() throws InterruptedException 
			{
			

				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				  	//Implicit wait 
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("https://www.saucedemo.com/");
				Thread.sleep(3000);
				
						//maximizing window 
				driver.manage().window().maximize();
				Thread.sleep(1000);
				
				WebElement username = driver.findElement(By.name("user-name"));
				username.sendKeys("standard_user");
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("secret_sauce");
				Thread.sleep(2000);
				WebElement Login= driver. findElement(By.name ("login-button"));
				Login.click();	
				Thread.sleep(2000);
				
				
				//Verify we are in home page
				boolean Logo = driver.findElement(By.className("app_logo")).isDisplayed();//To check whether Logo is displayed or not
		        
		        if (Logo)
		        {
		        	System.out.println("Logo is displayed");//It used to print the value when logo is displayed
		        }else
		        {
		        	System.out.println("Logo is not displayed");//It used to print the value when the logo is not displayed
		        }
				
		        
		        //select an item an add to cart
				Thread.sleep(3000);
				WebElement bag=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
				bag.click();
				Thread.sleep(3000);
				WebElement check=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
				check.click();
				Thread.sleep(3000);
				
				
				//check out
				WebElement checkout=driver.findElement(By.cssSelector("#checkout"));
				checkout.click();
				Thread.sleep(3000);
				
				
				//add shipping details
				
				WebElement details=driver.findElement(By.id("first-name"));
				details.sendKeys("Jaquiline");
				WebElement lastname=driver.findElement(By.id("last-name"));
				lastname.sendKeys("Boney");
				WebElement zipcode=driver.findElement(By.id("postal-code"));
				zipcode.sendKeys("600116");
				Thread.sleep(3000);
				
				//scroll down
				
				 js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(3000);
				
				
				WebElement continue1= driver.findElement(By.id("continue"));
				continue1.click();
				
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(3000);
				
				WebElement finish= driver.findElement(By.id("finish"));
				finish.click();
				
				
				
				Thread.sleep(3000);
				WebElement Back= driver.findElement(By.cssSelector("#back-to-products"));
				Back.click();
				
				Thread.sleep(3000);
				
				// Menu
				
				WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
				menu.click();
				Thread.sleep(2000);
				
				//Logout
				WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
				logout.click();
				Thread.sleep(2000);
				
				driver.quit();
				
				
		
			}	
				
			}

	