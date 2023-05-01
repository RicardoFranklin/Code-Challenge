package web.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import api.entities.json.DeviceJSON;
import web.framework.PageObjectBase;

public class HomePage extends PageObjectBase {
	
	@FindBy(css = "select#device_type")
	public WebElement deviceTypeSelect;
	
	@FindBy(css = "a.submitButton")
	public WebElement addDeviceButton;	
	
	private static final String devicesValidation = 
			"//div[@class='device-info']"
					+ "//span[@class='device-name' and contains(.,'%s')]"
					+ "/../span[@class='device-type' and contains(.,'%s')]"
					+ "/../span[@class='device-capacity' and contains(.,'%s')]";
	
	private static final String devicesValidationEditButton = 
			"//div[@class='device-info']"
					+ "//span[@class='device-name' and contains(.,'%s')]"
					+ "/../span[@class='device-type' and contains(.,'%s')]"
					+ "/../span[@class='device-capacity' and contains(.,'%s')]"
					+ "/ancestor::div[@class='device-main-box']"
					+ "//a[@class='device-edit']";
	
	private static final String devicesValidationRemoveButton = 
			"//div[@class='device-info']"
					+ "//span[@class='device-name' and contains(.,'%s')]"
					+ "/../span[@class='device-type' and contains(.,'%s')]"
					+ "/../span[@class='device-capacity' and contains(.,'%s')]"
					+ "/ancestor::div[@class='device-main-box']"
					+ "//button[@class='device-remove']";
	
			
	public List<WebElement> getDeviceList (DeviceJSON device) {
		
		String xpathLocator = String.format(devicesValidation, device.getSystemName(), device.getType(), device.getHddCapacity());
		
		System.out.println("getDeviceList (DeviceJSON:device) - xpath: " + xpathLocator);
		
		List<WebElement> webElemets = getWebElemets(By.xpath(xpathLocator));
		
		System.out.println("getDeviceList (DeviceJSON:device) - list size: " + webElemets.size());
		
		return webElemets;
	}
	
	public List<WebElement> getDevicesEditButtons (DeviceJSON device) {
		
		String xpathLocator = String.format(devicesValidationEditButton, device.getSystemName(), device.getType(), device.getHddCapacity());
		
		System.out.println("getDevicesEditButtons (DeviceJSON:device) - xpath: " + xpathLocator);
		
		return getWebElemets(By.xpath(xpathLocator));
	}
	
	public List<WebElement> getDevicesRemoveButtons (DeviceJSON device) {
		
		String xpathLocator = String.format(devicesValidationRemoveButton, device.getSystemName(), device.getType(), device.getHddCapacity());
		
		System.out.println("getDevicesRemoveButtons (DeviceJSON:device) - xpath: " + xpathLocator);
		
		return getWebElemets(By.xpath(xpathLocator));
	}
	
	
	public Boolean isDevicePresent (DeviceJSON device) {
		
		Boolean result;		
		List<WebElement> deviceList = getDeviceList(device);		
		
		if (deviceList.size() > 0) {
			result = true;
		}else {
			result = false;
		}
		
		System.out.println("isDevicePresent (DeviceJSON:device) : " + result);
		
		return result;
	}
	
	public Boolean isEditButtonPresentInDeviceRow (DeviceJSON device) {
		
		Boolean result;
		List<WebElement> deviceList = getDevicesEditButtons(device);				
		
		if (deviceList.size() > 0) {
			result = true;
		}else {
			result = false;
		}
		
		System.out.println("isEditButtonPresentInDeviceRow (DeviceJSON:device) : " + result);
		
		return result;	
	}
	
	public Boolean isRemoveButtonPresentInDeviceRow (DeviceJSON device) {
		
		Boolean result;
		List<WebElement> deviceList = getDevicesRemoveButtons(device);
		
		if (deviceList.size() > 0) {
			result = true;
		}else {
			result = false;
		}
		
		System.out.println("isRemoveButtonPresentInDeviceRow (DeviceJSON:device) : " + result);
		
		return result;	
	}
	

	
	public HomePage() {
		PageFactory.initElements(getDriverInstance(), this);
	}
		
	
	public void reloadHomePage() {
		browserRefresh();
	}


	/**
	 * WAITS
	 * 
	 */	
	
	public void waitForHomePage() {
		createWebDriverWait().until(ExpectedConditions.visibilityOf(deviceTypeSelect));
	}	

}
