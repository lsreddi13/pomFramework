package com.ohrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.base.Base;

public class LeavePage extends Base {
	
	@FindBy(id = "btnSearch")
	WebElement ele_SearchBtn;

	public LeavePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
public boolean verifySearchButton() {
		
		return ele_SearchBtn.isDisplayed();
	}
}
