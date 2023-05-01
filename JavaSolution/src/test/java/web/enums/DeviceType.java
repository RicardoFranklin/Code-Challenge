package web.enums;

public enum DeviceType {
	
	WINDOWS_WORKSTATION ("WINDOWS_WORKSTATION"),
	WINDOWS_SERVER ("WINDOWS_SERVER"),
	MAC ("MAC");
	
	private String deviceType;

	private DeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceType() {
		return deviceType;
	}

}
