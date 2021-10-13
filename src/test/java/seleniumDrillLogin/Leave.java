package seleniumDrillLogin;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Leave {
		
		public static void main(String[] args) throws InterruptedException  {
			//Set the path
			System.setProperty("webdriver.chrome.driver","C:\\Users\\jaquilined\\eclipse-Selenium\\MyFirstProject\\drivers\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();//Instance
	        driver.get("https://opensource-demo.orangehrmlive.com/");//To which web site to access that URL
	        driver.manage().window().maximize();//It will maximize the window
	        
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");//Send the text for user name
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.name("txtPassword")).sendKeys("admin123");//Send the text for password
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.className("button")).click();//Click on login button it will return to the home page
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        boolean Logo = driver.findElement(By.tagName("img")).isDisplayed();//To check whether Logo is displayed or not
	        
	        if (Logo)
	        {
	        	System.out.println("Logo is displayed");//It used to print the value when logo is displayed
	        }else
	        {
	        	System.out.println("Logo is not displayed");//It used to print the value when the logo is not displayed
	        }
	        
	        driver.findElement(By.linkText("My Info")).click();//Navigate to the My Info tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.partialLinkText("Dashb")).click();//Navigate to the Dashboard tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]/img[1]")).click();//Click on Assign leave quick launch
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.xpath("//input[@id='assignleave_txtEmployee_empName']")).sendKeys("John Smith");//Send the text for user name
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        Select leavetype = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));//Instance
	        leavetype.selectByIndex(9);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        WebElement date = driver.findElement(By.id("assignleave_txtFromDate"));//Add the date for the leave request
	        date.click();
	        driver.findElement(By.className("ui-state-default")).click();
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        WebElement ddownd = driver.findElement(By.className("leave_duration_dropdown"));//Select the duration from the drop down
	        Select elect = new Select(ddownd);
	        elect.selectByIndex(1);
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("assignleave_txtComment")).sendKeys("admin12");//Add the text in the comments
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.linkText("view details")).click();//Click on view details it will open new pop up
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("closeButton")).click();//Click on ok button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("assignBtn")).click();//Click on assign button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.partialLinkText("Director")).click();//Navigate to the Directory tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Add the text in name column
	        driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']")).sendKeys("Chenzira Chuki");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        Select jobtitle = new Select(driver.findElement(By.id("searchDirectory_job_title")));//Instance
	        jobtitle.selectByIndex(17);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        Select location = new Select(driver.findElement(By.id("searchDirectory_location")));//Instance
	        location.selectByVisibleText("    Canadian Regional HQ");//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("searchBtn")).click();//Click on search button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.partialLinkText("Admi")).click();//Navigate to the Admin tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Enter the text in user name column
	        driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Alice.Duval");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        Select userRole = new Select(driver.findElement(By.id("searchSystemUser_userType")));//Instance
	        userRole.selectByIndex(2);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        //Enter the text in Employee name column
	        driver.findElement(By.className("ac_input")).sendKeys("Alice Duval");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        Select Status = new Select(driver.findElement(By.id("searchSystemUser_status")));//Instance
	        Status.selectByIndex(1);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("searchBtn")).click();//Click on search button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.linkText("Time")).click();//Navigate to the Time tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        WebElement EmployeeName = driver.findElement(By.id("employee"));//Enter the text in employee name column
	        EmployeeName.clear();
	        EmployeeName.sendKeys("Russel Hamilton");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("btnView")).click();//click on view button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("btnSubmit")).click();//Click on submit button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.linkText("Buzz")).click();//Navigate to the Buzz tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Click Upload the image
	        driver.findElement(By.xpath("//a[@id='images-tab-label']")).click();
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Provide the path which we want to upload
	        driver.findElement(By.xpath("//input[@id='imageUploadBtn']")).sendKeys("C:\\Users\\irfanbs\\Pictures\\Screenshots\\OrangeHrm.PNG");
	        Thread.sleep(5000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("imageUploadBtn")).click();//Click on post button
	        Thread.sleep(9000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.linkText("PIM")).click();//Navigate to the PIM tab
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Enter the text in employee name column
	        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Lisa Andrews");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Enter the text in Id column
	        driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys("0208");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        //Enter the text in employment status
	        Select EmploymentStatus = new Select(driver.findElement(By.xpath("//select[@id='empsearch_employee_status']")));//Instance
	        EmploymentStatus.selectByIndex(4);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        Select Include = new Select(driver.findElement(By.id("empsearch_termination")));//Instance
	        Include.selectByIndex(0);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        //Enter the text in Supervisor name column
	        WebElement Supervisor = driver.findElement(By.id("empsearch_supervisor_name"));
	        Supervisor.clear();
	        Supervisor.sendKeys("Fiona Grace");
	        Thread.sleep(2000);//sleep time(it will wait for some time)
	        
	        Select JobTitle = new Select(driver.findElement(By.id("empsearch_job_title")));//Instance
	        JobTitle.selectByIndex(17);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        Select SubUnit = new Select(driver.findElement(By.id("empsearch_sub_unit")));//Instance
	        SubUnit.selectByIndex(3);//Select the value in the drop down
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.findElement(By.id("searchBtn")).click();//Click on search button
	        Thread.sleep(3000);//sleep time(it will wait for some time)
	        
	        driver.quit();//It will close the window
		}
		 
	}


