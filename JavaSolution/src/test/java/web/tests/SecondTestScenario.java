package web.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import api.entities.json.DeviceJSON;
import common.utils.FakeData;
import web.framework.TestCaseBase;
import web.pageobjects.HomePage;

public class SecondTestScenario extends TestCaseBase {

	//PageObjetcs
	private HomePage homePage = new HomePage();
		
	//Attributes
	private DeviceJSON deviceWithoutId;
	private DeviceJSON[] devicesList;
		
	@Before
	public void createDeviceData () {		
		deviceWithoutId = FakeData.createDeviceWithoutId();
		devicesList = api.sharedsteps.DeviceApiSharedSteps.listDevices();
	}

	@Test
	public void createDeviceByUI () throws InterruptedException {
		
		homePage.waitForHomePage();	
		
		web.sharedsteps.DeviceWebSharedSteps.createDevice(deviceWithoutId);
			
		List<WebElement> deviceList = homePage.getDeviceList(deviceWithoutId);
		
		assertTrue(deviceList.size()>=1);
		assertTrue(deviceList.get(0).isDisplayed());
		assertEquals(devicesList.length+1, api.sharedsteps.DeviceApiSharedSteps.listDevices().length);
		
		System.out.println("createDeviceByUI () - device is created and displayed - : " + deviceWithoutId);		

	}

}
