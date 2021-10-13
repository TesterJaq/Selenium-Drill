package seleniumDrillLogin;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Orange {



private WebDriver driver;
String baseURL = "https://opensource-demo.orangehrmlive.com/";
//driver.get("https://opensource-demo.orangehrmlive.com/");

private static final Logger logger = LogManager.getLogger(Orange.class);



@Parameters({ "browser" })
@BeforeTest
public void openBrowser(String browser) {
try {
if (browser.equalsIgnoreCase("Firefox")) {
WebDriverManager.firefoxdriver().setup();

driver = new FirefoxDriver();
} else if (browser.equalsIgnoreCase("chrome")) {
WebDriverManager.chromedriver().setup();

driver = new ChromeDriver();
}

} catch (WebDriverException e) {
System.out.println(e.getMessage());
}
}



@Test
public void login_TestCase() throws InterruptedException, AWTException {
driver.navigate().to(baseURL);
driver.manage().window().maximize();
BasicConfigurator.configure();
logger.info("Inside login test case");
logger.info("navigating to page");

// LOGIN
//Test login page with invalid credentials - Wrong username, correct password.

	WebElement username=driver.findElement(By.id("txtUsername"));
	username.sendKeys ("Admin1");
	WebElement Password=driver.findElement(By.id("txtPassword"));
	Password.sendKeys("admin123");
	WebElement Button =driver.findElement(By.id("btnLogin"));
	Button.click();

	Thread.sleep(5000);

	//Test login page with invalid credentials - Correct username, wrong password.

	WebElement username1=driver.findElement(By.id("txtUsername"));
	username1.sendKeys ("Admin1");
	WebElement Password1=driver.findElement(By.id("txtPassword"));
	Password1.sendKeys("admin1235");
	WebElement login =driver.findElement(By.id("btnLogin"));
	login.click();

	boolean errorMessage = driver.findElement(By.id("spanMessage")).isDisplayed();
	if(errorMessage)
	System.out.println("Error message is displayed");

	Thread.sleep(5000);

	//Test login page with invalid credentials - Wrong Username, wrong Password
	WebElement username2=driver.findElement(By.id("txtUsername"));
	username2.sendKeys ("Admin1");
	WebElement Password2=driver.findElement(By.id("txtPassword"));
	Password2.sendKeys("admin1234");
	WebElement Submit =driver.findElement(By.id("btnLogin"));
	Submit.click();
	Thread.sleep(5000);


	//Test login page with invalid credentials - Username & Password interchanged
	WebElement username3=driver.findElement(By.id("txtUsername"));
	username3.sendKeys ("admin123");
	WebElement Password3=driver.findElement(By.id("txtPassword"));
	Password3.sendKeys("Admin");
	WebElement SUBMIT =driver.findElement(By.id("btnLogin"));
	SUBMIT.click();
	Thread.sleep(5000);

	//Test login page with valid credentials
		WebElement username4=driver.findElement(By.id("txtUsername"));
		username4.sendKeys ("Admin");
		WebElement Password4=driver.findElement(By.id("txtPassword"));
		Password4.sendKeys("admin123");
		WebElement submit =driver.findElement(By.id("btnLogin"));
		submit.click();
		Thread.sleep(3000);

//LEAVE

WebElement leave = driver.findElement(By.xpath("//b[contains(text(),'Leave')]"));
leave.click();
Thread.sleep(2000);
WebElement configure =driver.findElement(By.cssSelector("#menu_leave_Configure"));
configure.click();
Thread.sleep(3000);
WebElement holiday=driver.findElement(By.partialLinkText("Holida"));
holiday.click();
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_END);
robot.keyRelease(KeyEvent.VK_END);
robot.keyRelease(KeyEvent.VK_CONTROL);
Thread.sleep(3000);
// Scroll Up using Robot class
/*
* robot.keyPress(KeyEvent.VK_PAGE_UP); robot.keyRelease(KeyEvent.VK_PAGE_UP);
*/
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,-250)", "");
//WebElement Welcome = driver.findElement(By.linkText("Welcome Boney?"));
//js.executeScript("arguments[0].scrollIntoView();", Welcome);
//Thread.sleep(3000);
//Boolean eleSelect = driver.findElement(By.linkText("New Year's Day")).isDisplayed();
// WebElement welcome=driver.findElement(By.linkText("Welcome Boney"));
// welcome.click();
Thread.sleep(3000);
//WebElement logout=driver.findElement(By.tagName("input"));
//logout.click();
//do something


//Edit info page
WebElement Myinfo=driver.findElement(By.linkText("My Info"));
Myinfo.click();
WebElement Save=driver.findElement(By.id("btnSave"));
Save.click();
Thread.sleep(3000);
WebElement EmpFirstName = driver.findElement(By.cssSelector("#personal_txtEmpFirstName"));
EmpFirstName.clear();
WebElement FirstName =driver.findElement(By.cssSelector("#personal_txtEmpFirstName"));
FirstName.sendKeys("Boney");
WebElement EmpLastName =driver.findElement(By.cssSelector("#personal_txtEmpLastName"));
EmpLastName.clear();
WebElement LastName =driver.findElement(By.cssSelector("#personal_txtEmpLastName"));
LastName.sendKeys("Xavier");
WebElement EmployeeId=driver.findElement(By.cssSelector("#personal_txtEmployeeId"));
EmployeeId.clear();
WebElement Id=driver.findElement(By.cssSelector("#personal_txtEmployeeId"));
Id.sendKeys("6423");
WebElement radio1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/ol[3]/li[1]/ul[1]/li[2]/label[1]"));
WebElement radio2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/ol[3]/li[1]/ul[1]/li[1]/label[1]"));
//Radio Button1 is selected
radio1.click();
//Radio Button1 is de-selected and Radio Button2 is selected
radio2.click();
WebElement Save1=driver.findElement(By.id("btnSave"));
Save1.click();
//Edit Blood group
WebElement EditCustom =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/p[1]/input[1]"));
EditCustom.click();
Thread.sleep(3000);
Select dropdown = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/ol[1]/li[1]/select[1]")));
dropdown.selectByVisibleText("A+");
Thread.sleep(3000);
WebElement EditCustom1= driver.findElement(By.xpath("//*[@id=\"btnEditCustom\"]"));
EditCustom1.click();
Thread.sleep(5000);
//Yamuna
WebElement Myinfo1=driver.findElement(By.linkText("My Info"));
Myinfo1.click();
Thread.sleep(2000);
WebElement Immigration=driver.findElement(By.xpath("//a[contains(text(),'Immigration')]"));
Immigration.click();
Thread.sleep(2000);

			//find xpath using absolutexpath 
WebElement Add=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/p[1]/input[1]"));
Add.click();
Thread.sleep(2000);
WebElement Number=driver.findElement(By.cssSelector("#immigration_number"));
Number.sendKeys("9080120");
Thread.sleep(3000);

		//javascriptexecutor using to scroll down webpage 
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,400)", "");
Thread.sleep(3000);


		    		//isenabled and is displayed method to check for save button 
boolean Savebuttonispresent = driver.findElement(By.id("btnSave")).isDisplayed();
boolean Savebuttonenabled= driver.findElement(By.id("btnSave")).isEnabled();

if (Savebuttonispresent==true && Savebuttonenabled==true)
{
       // click on the save button
       WebElement savebutton = driver.findElement(By.id("btnSave"));
       savebutton.click();
}

Thread.sleep(3000);

//BUZZZ
WebElement buzz=driver.findElement(By.xpath("//*[@id=\"menu_buzz_viewBuzz\"]/b"));
buzz.click();
Thread.sleep(3000);
WebElement createpost= driver.findElement(By.id ("createPost_content"));
createpost.sendKeys("Hey there! We are Vayu Tent....! ");
createpost.sendKeys("#drillday#GA_evaluation#exicted ");
Thread.sleep(2000);
//WebElement uploadimages= driver.findElement(By.xpath("//*[@id=\"tabLink2\"]"));
//uploadimages.click();
//WebElement uploadbutton= driver.findElement(By.xpath ("//*[@id=\"image-upload-button\"]"));
// uploadbutton.click();
//uploadbutton.sendKeys("‪C:\\Users\\nandhinig\\Pictures\\GAvayu.jpg");
//Thread.sleep(2000);
WebElement post= driver.findElement(By.id("postSubmitBtn"));
post.click();
Thread.sleep(3000);



//LINKS
WebElement Welcome=driver.findElement(By.partialLinkText("Welcome"));
Welcome.click();
Thread.sleep(5000);
WebElement About=driver.findElement(By.linkText("About"));
About.click();
Thread.sleep(3000);
WebElement Close=driver.findElement(By.className("close"));
Close.click();
Thread.sleep(5000);
WebElement Support=driver.findElement(By.partialLinkText("Support"));
Support.click();
Thread.sleep(3000);
WebElement welcome=driver.findElement(By.partialLinkText("Welcome"));
welcome.click();
Thread.sleep(3000);

}


@Test
public void search_TestCase() {
driver.navigate().to(baseURL);
//do something
}



@AfterTest
public void closeBrowser() {
driver.quit();
}
}