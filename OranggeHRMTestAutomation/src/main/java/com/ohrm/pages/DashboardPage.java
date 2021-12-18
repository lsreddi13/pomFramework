package com.ohrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ohrm.base.Base;

public class DashboardPage extends Base {

	//
	@FindBy(id = "welcome")
	WebElement ele_profile;

	@FindBy(xpath = "//*[@id='welcome-menu']/ul/li[3]/a")
	WebElement ele_logout;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement ele_Admin;
	
	@FindBy(xpath = "//*[@id=\"menu_leave_viewLeaveModule\"]/b")
	WebElement ele_Leave;

	public DashboardPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Enter Email id
	public void clickLogout() {
		ele_profile.click();

	}
	
	public AdminPage clickAdminBtn() throws IOException {
		//clickAdmin
		ele_Admin.click();
		return new AdminPage();
		
	}
	
	public LeavePage clickLeavenBtn() throws IOException {
		//clickAdmin
		ele_Leave.click();
		return new LeavePage();
		
	}

	// Click Login button
	public void clickLogoutBtn() {
		
		if (ele_profile.isDisplayed()) {
			ele_profile.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")));
			if (ele_logout.isDisplayed()) {
				ele_logout.click();
				System.out.println("logout button clicked.");
			}

		} else {
			System.out.println("Logout button is not displayed.");
		}
	}

}
