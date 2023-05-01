package api.entities;

import java.net.URL;

import org.openqa.selenium.NotFoundException;

import api.enums.EndpointAction;
import api.enums.Parameter;

public class ServiceTest {

	private EndpointAction endpointAction;
	private TestInfo testInfo;

	public ServiceTest(EndpointAction endpointAction, TestInfo testInfo) {
		super();
		this.endpointAction = endpointAction;
		this.testInfo = testInfo;
	}

	public URL getUrl() {
		return createURL();
	}

	public EndpointAction getEndpointAction() {
		return endpointAction;
	}

	public TestInfo getTestInfo() {
		return testInfo;
	}

	private URL createURL() {

		String url = endpointAction.getUrlPattern();

		for (Parameter parameter : endpointAction.getParameterList()) {

			switch (parameter) {

			case HOST:
				if (testInfo.getHost() != null && !testInfo.getHost().isEmpty()) {
					url = url.replace(Parameter.HOST.toString(), testInfo.getHost());
				} else
					throw new NotFoundException("The required field 'HOST' is missing on the 'TestInfo' object.");
				break;
			case DEVICE_ID:
				if (testInfo.getDeviceId() != null && !testInfo.getDeviceId().isEmpty()) {
					url = url.replace(Parameter.DEVICE_ID.toString(), testInfo.getDeviceId());
				} else
					throw new NotFoundException("The required field 'DEVICE_ID' is missing on the 'TestInfo' object.");
				break;
			default:
				break;
			}

		}
		
		URL urlfinal = null;
		
		try {
			urlfinal = new URL(url);
		} catch (Exception e) {
		}

		return urlfinal;
	}

}
