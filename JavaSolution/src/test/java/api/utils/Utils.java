package api.utils;

import java.util.Random;

import api.entities.json.DeviceJSON;
import web.enums.DeviceType;

public class Utils {

	public static int getRandomInt(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}	

	public static DeviceJSON getRandomDevice(DeviceJSON[] devices) {

		if (devices.length > 0)
			return devices[Utils.getRandomInt(devices.length)];
		else
			return null;
	}
	
	public static DeviceType getRandomDeviceType () {		
				
		DeviceType[] values = DeviceType.values();
		
		int index = getRandomInt(values.length);
		
		return values[index];	
		
	}

}
