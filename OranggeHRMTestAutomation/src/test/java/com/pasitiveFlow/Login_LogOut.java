package com.pasitiveFlow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.base.Base;
import com.ohrm.pages.AdminPage;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LeavePage;
import com.ohrm.pages.LoginPage;

public class Login_LogOut extends Base {
	public Login_LogOut() throws IOException {
		super();
	}

	public LoginPage lp;
	public DashboardPage dp;
	public AdminPage ap;
	public LeavePage lvp;

	@BeforeClass
	public void setUp() {
		initialize();
		String url = prop.getProperty("url");
//		String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 0, enabled = false)
	public void verifyLoginLogout() throws InterruptedException, IOException {
		lp = new LoginPage();
		dp = new DashboardPage();
		lp.login(prop.getProperty("userEmail"), prop.getProperty("userpwd"));
		dp.clickLogoutBtn();
	}

	// navigate to Admin page and logout.
	@Test(priority = 1)
	public void verifyAdminTab() throws InterruptedException, IOException {
		lp = new LoginPage();
		dp = new DashboardPage();
		ap = new AdminPage();

		lp.login(prop.getProperty("userEmail"), prop.getProperty("userpwd"));
		dp.clickAdminBtn();
		System.out.println("Verify Add button in the Admin tab : "+ap.verifyAddButton());
		dp.clickLogoutBtn();

	}
	@Test(priority = 2)
	public void verifyLeaveTab() throws InterruptedException, IOException {
		lp = new LoginPage();
		dp = new DashboardPage();
		ap = new AdminPage();
		lvp = new LeavePage();

		lp.login(prop.getProperty("userEmail"), prop.getProperty("userpwd"));
		dp.clickLeavenBtn();
		System.out.println("Verified search button in the Leave tab : "+lvp.verifySearchButton());		
		dp.clickLogoutBtn();

	}

	public void logout() {
		// logout code.

	}

}
