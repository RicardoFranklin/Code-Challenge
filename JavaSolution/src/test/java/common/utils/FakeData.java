package common.utils;

import com.github.javafaker.Faker;

import api.entities.json.DeviceJSON;
import api.utils.Utils;

public class FakeData {
	
	public static DeviceJSON createDeviceWithoutId () {		
		
		Faker faker = new Faker();
		
		DeviceJSON device = new DeviceJSON(
				null, 
				faker.app().name(),
				Utils.getRandomDeviceType().getDeviceType(), 
				Long.valueOf(Utils.getRandomInt(1000)));			
		
		System.out.println("createDeviceWithoutId () - " + device.toString());
		
		return device;		
	}

}
