package api.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.junit.Test;

import api.entities.Device;
import api.entities.json.DeviceJSON;
import api.framework.TestCaseBase;
import api.sharedsteps.DeviceApiSharedSteps;
import api.utils.Utils;
import common.utils.FakeData;

/**
 * 
 * This class is in charge of testing the basic services of the API.
 * 
 * @author ricardo.cordeiro
 * @since April, 26th, 2023
 *
 */

public class DevicesTests extends TestCaseBase {

	@Test
	public void createDevice() throws MalformedURLException {

		// List all Devices in the system.
			// Reason: get device amount before creating a new Device.
		DeviceJSON[] deviceListBefore = DeviceApiSharedSteps.listDevices();

		// Get a random Device.
		DeviceJSON device = FakeData.createDeviceWithoutId();

		// TEST GOAL : Create a new device in the system.
		DeviceJSON createdDevice = DeviceApiSharedSteps.createDevice(device);

		// List all Device in the system again - after creation .
			// Reason: get device amount after device creation.
		DeviceJSON[] deviceListAfter = DeviceApiSharedSteps.listDevices();

		// Validations
		assertEquals(new Device(device), new Device(createdDevice));
		assertEquals(deviceListBefore.length + 1, deviceListAfter.length);
		assertTrue(Arrays.asList(deviceListAfter).contains(createdDevice));
		assertTrue(!Arrays.asList(deviceListBefore).contains(createdDevice));
	}
	
	@Test
	public void deleteDevice() throws MalformedURLException {

		// List all Devices in the system.
			// Reason: get device amount before deleting a Device.
		DeviceJSON[] devicesListBeforeCreation = DeviceApiSharedSteps.listDevices();

		// Get a random Device from FakeData API 
			// Reason: ensure there is at least one device in the system.
			// Reason: it will be used to the test goal.
		DeviceJSON deviceBeforeCreation = FakeData.createDeviceWithoutId();
		DeviceJSON deviceAfterCreation = DeviceApiSharedSteps.createDevice(deviceBeforeCreation);

 		// List all Devices in the system.
			// Reason: get device amount after creation.
		DeviceJSON[] deviceListAfterCreation = DeviceApiSharedSteps.listDevices();

		// Validations
		assertEquals(new Device(deviceBeforeCreation) , new Device(deviceAfterCreation));
		assertEquals(devicesListBeforeCreation.length + 1, deviceListAfterCreation.length);
		assertTrue(!Arrays.asList(devicesListBeforeCreation).contains(deviceAfterCreation));
		assertTrue(Arrays.asList(deviceListAfterCreation).contains(deviceAfterCreation));

		// Get a random device from the existing ones .
			//Reason: it will improve the chance to get different kind of devices.
		DeviceJSON deviceToBeDeleted = deviceListAfterCreation[Utils.getRandomInt(deviceListAfterCreation.length)];

		// TEST GOAL : Delete a device from the existing ones.
		DeviceApiSharedSteps.deleteDevice(deviceToBeDeleted);

		// List all Features into a created Space (After Delete the Feature)
		DeviceJSON[] deviceListAfterDeletion = DeviceApiSharedSteps.listDevices();

		//Validations
		assertEquals(deviceListAfterCreation.length - 1, deviceListAfterDeletion.length);
		assertTrue(!Arrays.asList(deviceListAfterDeletion).contains(deviceToBeDeleted));

	}

	@Test
	public void updateDevice () throws MalformedURLException {

		// List all Devices in the system.
			// Reason: get device amount before deleting a Device.
		DeviceJSON[] devicesListBeforeCreation = DeviceApiSharedSteps.listDevices();

		// Get a random Device from FakeData API 
			// Reason: ensure there is at least one device in the system.
			// Reason: it will be used to the test goal.
		DeviceJSON deviceBeforeCreation = FakeData.createDeviceWithoutId();
		DeviceJSON deviceAfterCreation = DeviceApiSharedSteps.createDevice(deviceBeforeCreation);

		// List all Devices in the system.
			// Reason: get device amount after creation.
		DeviceJSON[] deviceListAfterCreation = DeviceApiSharedSteps.listDevices();

		// Validations
		assertEquals(new Device(deviceBeforeCreation) , new Device(deviceAfterCreation));
		assertEquals(devicesListBeforeCreation.length + 1, deviceListAfterCreation.length);
		assertTrue(!Arrays.asList(devicesListBeforeCreation).contains(deviceAfterCreation));
		assertTrue(Arrays.asList(deviceListAfterCreation).contains(deviceAfterCreation));		
		
		// Get a random device from the existing ones .
			//Reason: it will improve the chance to get different kind of devices.
		DeviceJSON deviceBeforeUpdating = deviceListAfterCreation[Utils.getRandomInt(deviceListAfterCreation.length)];
		DeviceJSON deviceToBeUpdated = FakeData.createDeviceWithoutId();

		//Set devideId on the device that will be updated.
		deviceToBeUpdated.setId(deviceBeforeUpdating.getId());		

		// TEST GOAL : Update a device from the device pool.
		DeviceApiSharedSteps.updateDevice(deviceToBeUpdated);		

		// List all Devices in the system.
			// Reason: get device amount after updating devices.
		DeviceJSON deviceAfterUpdating = DeviceApiSharedSteps.listDevice(deviceToBeUpdated.getId());
		
		//Validations
		assertEquals(deviceToBeUpdated , deviceAfterUpdating);		
				
		// List all Devices in the system.
			// Reason: get device amount after creation.
		DeviceJSON[] deviceListAfterUpdating = DeviceApiSharedSteps.listDevices();
		
		//Validations		
		assertEquals(deviceListAfterCreation.length , deviceListAfterUpdating.length);
		assertTrue(Arrays.asList(deviceListAfterUpdating).contains(deviceToBeUpdated));		
		assertTrue(!Arrays.asList(deviceListAfterCreation).contains(deviceToBeUpdated));		 
	}

}
