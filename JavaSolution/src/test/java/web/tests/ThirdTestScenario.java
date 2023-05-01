package web.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import api.entities.json.DeviceJSON;
import api.sharedsteps.DeviceApiSharedSteps;
import web.framework.TestCaseBase;
import web.pageobjects.HomePage;

public class ThirdTestScenario extends TestCaseBase {

	//PageObjects
	private HomePage homePage = new HomePage();
	
	//Attributes
	private DeviceJSON[] devicesList;	
	
	@Before
	public void setup () {		
		devicesList = DeviceApiSharedSteps.listDevices();
		System.out.println(Arrays.asList(devicesList));				
	}

	@Test
	public void renameDeviceAndCheck () throws Exception {
		
		homePage.waitForHomePage();		
		
		if (devicesList.length==0) {
			throw new Exception("There is no Device registered on the system");
						
		}
		
		//Rename
		DeviceJSON deviceToBeRenamed = devicesList[0];
		
		deviceToBeRenamed.setSystemName("Renamed Device");
		
		DeviceApiSharedSteps.updateDevice(deviceToBeRenamed);		
		
		homePage.reloadHomePage();		
			
		List<WebElement> deviceList = homePage.getDeviceList(deviceToBeRenamed);
		
		assertTrue(deviceList.size()>=1);
		assertTrue(deviceList.get(0).isDisplayed());
		
		System.out.println("renameDeviceAndCheck () - device is renamed and displayed - : " + deviceToBeRenamed);		


	}

}
