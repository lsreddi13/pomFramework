package com.ohrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.base.Base;

public class AdminPage extends Base {

	//
	@FindBy(id = "btnAdd")
	WebElement ele_AddBtn;

	public AdminPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAddButton() {
		
		return ele_AddBtn.isDisplayed();
	}

}
