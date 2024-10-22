package Testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pageobject.loginpage;
import org.testng.annotations.Listeners;

import Utilities.Readconfig;
@Listeners(TestNGListener.class)

public class Testdata extends Base {
	Readconfig config=new Readconfig();
	@Test(priority = 1)
    public void data() throws InterruptedException {
        loginpage lp1 = new loginpage(driver);
        lp1.clickproductlink();
        Thread.sleep(3000);
        
        
    WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
      Assert.assertTrue(remove.isDisplayed());
        
    }


}
