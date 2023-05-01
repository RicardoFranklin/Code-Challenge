package api.sharedsteps;

import static io.restassured.RestAssured.given;

import api.entities.ServiceTest;
import api.entities.TestInfo;
import api.entities.json.DeviceJSON;
import api.enums.EndpointAction;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class DeviceApiSharedSteps {	
	
	
	public static DeviceJSON createDevice (DeviceJSON device){
		
		TestInfo testInfo = new TestInfo();
			
		ServiceTest serviceTest = new ServiceTest(EndpointAction.CREATE_DEVICE, testInfo);
			
		JsonPath jsonPath = 
				given()
					.contentType(ContentType.JSON)
					.body(device)
				.expect()
					.statusCode(serviceTest.getTestInfo().getExpectedResultCode())
				.when()
					.post(serviceTest.getUrl())
					.andReturn()
					.jsonPath();
		
		DeviceJSON deviceCreated  = jsonPath.getObject("", DeviceJSON.class);
		
		System.out.println("createDevice (DeviceJSON): " + deviceCreated.toString());
		
		return deviceCreated;
	}	
	
	public static DeviceJSON[] listDevices () {
		
		TestInfo testInfo = new TestInfo();
		
		ServiceTest serviceTest = new ServiceTest(EndpointAction.LIST_DEVICES, testInfo);
		
		JsonPath jsonPath = 
				given()
				.expect()
						.statusCode(serviceTest.getTestInfo().getExpectedResultCode())
				.when()
					.get(serviceTest.getUrl())
					.andReturn()
					.jsonPath();
		
		DeviceJSON[] devicesJson= jsonPath.getObject("", DeviceJSON[].class);
		
		System.out.println("listDevices () - Devices list size: " + devicesJson.length);
		
		return devicesJson;
		
	}
	
	public static DeviceJSON listDevice (String deviceId) {
		
		TestInfo testInfo = new TestInfo(deviceId);
		
		ServiceTest serviceTest = new ServiceTest(EndpointAction.LIST_DEVICE, testInfo);
		
		JsonPath jsonPath = 
				given()
				.expect()
						.statusCode(serviceTest.getTestInfo().getExpectedResultCode())
				.when()
					.get(serviceTest.getUrl())
					.andReturn()
					.jsonPath();
		
		DeviceJSON deviceJson= jsonPath.getObject("", DeviceJSON.class);
		
		System.out.println("listDevice (String:deviceId) - Device" + deviceJson.toString());
		
		return deviceJson;
		
	}
	

	public static void updateDevice (DeviceJSON device) {

		TestInfo testInfo = new TestInfo(device.getId());

		ServiceTest serviceTest = new ServiceTest(EndpointAction.PUT_DEVICE, testInfo);

		given()
			.contentType(ContentType.JSON)
			.body(device)
		.expect()
			.statusCode(serviceTest.getTestInfo().getExpectedResultCode())
		.when()
			.put(serviceTest.getUrl());
		
		System.out.println("updateDevice (DeviceJSON): " + device);
		
	}
	
	public static void deleteDevice (DeviceJSON device) {
		
		TestInfo testInfo = new TestInfo(device.getId());
		
		ServiceTest serviceTest = new ServiceTest(EndpointAction.DELETE_DEVICE, testInfo);

		given()
		.expect()
			.statusCode(serviceTest.getTestInfo().getExpectedResultCode())
		.when()
			.delete(serviceTest.getUrl());
		
		System.out.println("deleteFeature (DeviceJSON) - Device: " + device.toString());
		
	}
	
	


}
