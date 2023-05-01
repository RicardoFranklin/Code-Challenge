package api.entities;

import java.io.IOException;

import common.utils.PropertiesReader;

public class TestInfo {

	private String host;
	private String deviceId;
	private Integer expectedResultCode;

	public TestInfo() {

		ApiEnvironment apiEnvironment;

		try {
			apiEnvironment = PropertiesReader.getApiEnvironment();
			this.host = apiEnvironment.getUrl();
			this.expectedResultCode = 200;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public TestInfo(String deviceId) {
		this();
		this.deviceId = deviceId;
	}

	public TestInfo(String deviceId, Integer expectedResultCode) {
		this();
		this.deviceId = deviceId;
		this.expectedResultCode = expectedResultCode;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getExpectedResultCode() {
		return expectedResultCode;
	}

	public void setExpectedResultCode(Integer expectedResultCode) {
		this.expectedResultCode = expectedResultCode;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "TestInfo [host=" + host + ", deviceId=" + deviceId + ", expectedResultCode=" + expectedResultCode + "]";
	}

}
