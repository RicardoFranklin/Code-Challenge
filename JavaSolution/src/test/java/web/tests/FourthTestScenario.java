package web.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.entities.json.DeviceJSON;
import api.sharedsteps.DeviceApiSharedSteps;
import web.framework.TestCaseBase;
import web.pageobjects.HomePage;

public class FourthTestScenario extends TestCaseBase {

	private HomePage homePage = new HomePage();
	private DeviceJSON[] devicesList;	
	
	@Before
	public void listDevices () {
		
		devicesList = DeviceApiSharedSteps.listDevices();
		System.out.println(Arrays.asList(devicesList));
				
	}

	@Test
	public void deleteDeviceAndCheck () throws Exception {
		
		homePage.waitForHomePage();		
		
		if (devicesList.length==0) {
			throw new Exception("There is no Device registered on the system");
						
		}
		
		//Rename device 
		DeviceJSON deviceToBeDeleted = devicesList[devicesList.length -1];
					
		DeviceApiSharedSteps.deleteDevice(deviceToBeDeleted);		
		
		homePage.reloadHomePage();		
		
		assertTrue(!homePage.isDevicePresent(deviceToBeDeleted));
		assertEquals(devicesList.length -1, DeviceApiSharedSteps.listDevices().length);		
		
		System.out.println("deleteDeviceAndCheck () - device has been deleted - : " + deviceToBeDeleted);

	}

}
