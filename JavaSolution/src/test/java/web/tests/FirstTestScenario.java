package web.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import api.entities.json.DeviceJSON;
import api.sharedsteps.DeviceApiSharedSteps;
import web.framework.TestCaseBase;
import web.pageobjects.HomePage;

public class FirstTestScenario extends TestCaseBase {

	//PageObjects
	private HomePage homePage = new HomePage();
	
	//Attributes
	private DeviceJSON[] devicesList;	
	
	@Before
	public void setup () {		
		devicesList = DeviceApiSharedSteps.listDevices();		
	}

	@Test
	public void checkDeviceListOnFE () throws InterruptedException {
		
		homePage.waitForHomePage();		
		
		//Check if all devices returned by API are visible on the Front-End (FE) and have the Edit and Remove Button
		for (DeviceJSON device: devicesList) {
			
			List<WebElement> deviceList = homePage.getDeviceList(device);
			
			assertTrue(deviceList.size()>=1);
			assertTrue(deviceList.get(0).isDisplayed());
			
			System.out.println("firstScenario () - device is displayed - : " + device);
			
			deviceList = homePage.getDevicesEditButtons(device);
			
			assertTrue(deviceList.size()>=1);
			assertTrue(deviceList.get(0).isDisplayed());			
			
			System.out.println("firstScenario () - device's edit button is displayed - : " + device);
			
			deviceList = homePage.getDevicesRemoveButtons(device);
			
			assertTrue(deviceList.size()>=1);
			assertTrue(deviceList.get(0).isDisplayed());			
						
			System.out.println("firstScenario () - device's remove button is displayed - : " + device);			
			
		}	

	}

}
