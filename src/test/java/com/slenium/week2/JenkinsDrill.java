package com.slenium.week2;

	import java.util.concurrent.TimeUnit;



	import org.apache.log4j.LogManager;
	import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;



	public class JenkinsDrill {
	
	private WebDriver driver;
	String baseURL = "http://www.google.com/";
	private static final Logger logger = LogManager.getLogger(JenkinsDrill.class);



	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
	try {
	if (browser.equalsIgnoreCase("Firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();

	} else if (browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();

	}

	} catch (WebDriverException e) {
	System.out.println(e.getMessage());
	}
	}
	@Test
	public void logintest() throws InterruptedException {

	WebElement username=driver.findElement(By.cssSelector("#user-name"));
	username.sendKeys("standard_user");
	Thread.sleep(3000);
	WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys("secret_sauce");
	Thread.sleep(3000);
	WebElement login=driver.findElement(By.cssSelector("#login-button"));
	login.click();
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);//WaitFor Page loads
	String expectedTitle = "Swag Labs";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);//HomePageTitle verification using Assertion
	Thread.sleep(3000);
	WebElement sort=driver.findElement(By.className("product_sort_container"));
	sort.click();
	Thread.sleep(3000);
	WebElement sortingbyprice=driver.findElement(By.xpath("//option[contains(text(),'Price (high to low)')]"));
	sortingbyprice.click();
	Thread.sleep(3000);
	/*
	* WebElement product_sort_container =
	* driver.findElement(By.className("product_sort_container")); Select
	* dropdownsort = new Select(product_sort_container);
	* //dropdownsort.selectByVisibleText("Price (high to low)");
	* dropdownsort.selectByValue("Price (high to low)");
	* dropdownsort.selectByIndex(3);
	*/
	WebElement addtocart1=driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
	addtocart1.click();
	Thread.sleep(3000);
	WebElement addtocart2=driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt"));
	addtocart2.click();
	Thread.sleep(3000);
	WebElement yourcart=driver.findElement(By.className("shopping_cart_link"));
	yourcart.click();
	Thread.sleep(3000);
	WebElement removefromcart=driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
	removefromcart.click();
	
	Alert alert = driver.switchTo().alert(); // switch to alert

	String alertMessage= driver.switchTo().alert().getText(); // capture alert message

	System.out.println("Do yo want to remove the item?"); // Print Alert Message
	Thread.sleep(5000);
	alert.accept();
	
	/*
	* JavascriptExecutor delete = (JavascriptExecutor) driver;
	* //delete.executeScript("alert('HI!')"); //Thread.sleep(3000);
	* delete.executeScript("return confirm('One Item got deleted successfully!')");
	* Thread.sleep(3000);
	*/
	//delete.confirm();
	// Switching to Alert
	/*
	* Alert alert = driver.switchTo().alert();
	*
	* // Capturing alert message. String alertMessage=
	* "One Item got deleted successfully!"; driver.switchTo().alert().getText();
	*
	* // Displaying alert message
	* System.out.println("One Item got deleted successfully!"+alertMessage);
	* Thread.sleep(5000);
	*/

	// Accepting alert
	//alert.accept();
	WebElement checkout=driver.findElement(By.cssSelector("#checkout"));
	checkout.click();
	Thread.sleep(3000);
	WebElement firstname=driver.findElement(By.cssSelector("#first-name"));
	firstname.sendKeys("vinodhini");
	Thread.sleep(3000);
	WebElement lastname=driver.findElement(By.cssSelector("#last-name"));
	lastname.sendKeys("Uthandisami");
	Thread.sleep(3000);
	WebElement postalcode=driver.findElement(By.cssSelector("#postal-code"));
	postalcode.sendKeys("123456");
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement CONTINUE = driver.findElement(By.cssSelector("#continue"));
	js.executeScript("arguments[0].scrollIntoView();", CONTINUE);
	CONTINUE.click();
	Thread.sleep(3000);
	WebElement FINISH = driver.findElement(By.cssSelector("#finish"));
	js.executeScript("arguments[0].scrollIntoView();", FINISH);
	FINISH.click();
	Thread.sleep(3000);
	WebElement back=driver.findElement(By.cssSelector("#back-to-products"));
	back.click();
	Thread.sleep(3000);
	WebElement menu=driver.findElement(By.cssSelector("#react-burger-menu-btn"));
	menu.click();
	Thread.sleep(3000);
	WebElement logout=driver.findElement(By.cssSelector("#logout_sidebar_link"));
	logout.click();
	Thread.sleep(3000);

	}
	@AfterTest
	public void closeBrowser() {
	driver.quit();
	}



	}
