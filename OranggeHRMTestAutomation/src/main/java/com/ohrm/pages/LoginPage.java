package com.ohrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.base.Base;

public class LoginPage extends Base {

	@FindBy(id = "txtUsername")
	WebElement ele_email;

	@FindBy(id = "txtPassword")
	WebElement ele_password;

	@FindBy(id = "btnLogin")
	WebElement ele_loginBtn;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Enter Email id
	public void enterEmail(String Email) {
		ele_email.clear();
		ele_email.sendKeys(Email);
	}

	// Enter password
	public void enterPassword(String pwd) {
		ele_password.clear();
		ele_password.sendKeys(pwd);
	}

	// verify Login button
	public boolean verifyLoginBtn() {
		return ele_loginBtn.isDisplayed();
	}

	// Click Login button
	public DashboardPage clickLoginBtn() throws IOException {
		if (ele_loginBtn.isDisplayed()) {
			ele_loginBtn.click();
		} else {
			System.out.println("Login button is not displayed.");
		}
		return new DashboardPage();
	}

	public void login(String EmailID, String password) throws InterruptedException, IOException {
		enterEmail(EmailID);
		enterPassword(password);
		clickLoginBtn();		
	}

}
