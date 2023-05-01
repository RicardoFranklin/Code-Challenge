package api.enums;

import java.util.Arrays;
import java.util.List;

/**
 * This enum manages the services actions and their required files. Below a complete list with all actions and their required fields.
 * 
 *      CREATE_DEVICE (1): {HOST}
 *      LIST_DEVICES (1): {HOST}
 *      LIST_DEVICE (2): {HOST} {DEVICE_ID} 
 *   	PUT_DEVICE (2): {HOST} {DEVICE_ID} 
 *      DELETE_DEVICE (2): {HOST} {DEVICE_ID} 
 * 
 * @author ricardo.cordeiro
 * @since April, 26th, 2023
 *
 */
public enum EndpointAction {	
	
	CREATE_DEVICE (
			Arrays.asList(
					Parameter.HOST), 
			"HOST/devices", 
			Method.POST),	
	
	LIST_DEVICES (
			Arrays.asList(Parameter.HOST), 
			"HOST/devices",
			Method.GET),
	
	LIST_DEVICE (
			Arrays.asList(
					Parameter.HOST,
					Parameter.DEVICE_ID
					), 
			"HOST/devices/DEVICE_ID",
			Method.GET),
	
	PUT_DEVICE (
			Arrays.asList(
					Parameter.HOST, 
					Parameter.DEVICE_ID), 
			"HOST/devices/DEVICE_ID", 
			Method.PUT),
	
	DELETE_DEVICE(
			Arrays.asList(
					Parameter.HOST, 
					Parameter.DEVICE_ID), 
			"HOST/devices/DEVICE_ID", 
			Method.DELETE);	
	

	private final List<Parameter> parameterList;
	private final String urlPattern;
	private final Method method;

	private EndpointAction(List<Parameter> parameterList, String urlPattern, Method method) {
		this.parameterList = parameterList;
		this.urlPattern = urlPattern;
		this.method = method;
	}

	public List<Parameter> getParameterList() {	
		return this.parameterList;
	}

	public String getUrlPattern() {
		return this.urlPattern;
	}

	public Method getMethod() {
		return this.method;
	}
}

