package web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import web.framework.PageObjectBase;

public class NewDevicePage extends PageObjectBase {

	@FindBy(css = "button.submitButton")
	public WebElement saveButton;

	@FindBy(id = "system_name")
	public WebElement systemNameInput;
	
	@FindBy(id = "hdd_capacity")
	public WebElement hddCapacity;

	public NewDevicePage() {
		PageFactory.initElements(getDriverInstance(), this);
	}
		
	public Select typeSelect () {
		return getSelectElement(By.id("type"));
	}

	/**
	 * WAITS
	 * 
	 */

	public void waitForNewDevicePage() {
		createWebDriverWait().until(ExpectedConditions.visibilityOf(saveButton));
	}

}
