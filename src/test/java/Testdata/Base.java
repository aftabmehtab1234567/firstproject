package Testdata;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pageobject.loginpage;
import Utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	Readconfig readconfig = new Readconfig();
	public String Url = readconfig.URL();
	public String Username = readconfig.Username();
	public String Password = readconfig.Password();
	public String Fname = readconfig.Fname();
	public String Lname = readconfig.Lname();
	public static WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().driverVersion("latest").setup();

		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() throws InterruptedException {

		loginpage lp = new loginpage(driver);

		lp.setusername(Username);
		lp.setPassword(Password);
		lp.clickLogin();

		Thread.sleep(3000);

		String actualTitle = driver.getTitle();
		if (actualTitle.equals("Swag Labs")) {
			Assert.assertTrue(true, "Login successful, title matched.");
		} else {
			Assert.assertTrue(false, "Login failed, title did not match.");
		}
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
