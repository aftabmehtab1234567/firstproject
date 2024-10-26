package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver ldriver;

	public loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "user-name")
	WebElement txtUsername;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(name = "login-button")
	WebElement btnLogin;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement productlink;

	public void setusername(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickproductlink() {
		productlink.click();
	}

}
