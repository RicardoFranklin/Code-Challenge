package web.sharedsteps;

import api.entities.json.DeviceJSON;
import web.pageobjects.HomePage;
import web.pageobjects.NewDevicePage;

public class DeviceWebSharedSteps {
	
	public static void createDevice (DeviceJSON device) {		
		
		HomePage homePage = new HomePage();
		NewDevicePage newDevicePage = new NewDevicePage();
		
		homePage.addDeviceButton.click();
		newDevicePage.waitForNewDevicePage();
		
		newDevicePage.systemNameInput.sendKeys(device.getSystemName());
		newDevicePage.typeSelect().selectByValue(device.getType());
		newDevicePage.hddCapacity.sendKeys(device.getHddCapacity().toString());
		newDevicePage.saveButton.click();		
	}


}
