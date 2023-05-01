package common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import api.entities.ApiEnvironment;
import web.entities.WebEnvironment;

public class PropertiesReader {
	
	private static final String API_PROPERTIES = "api.properties";
	private static final String WEB_PROPERTIES = "web.properties";

	private static Properties loadPropertiesFile(String fileName) throws IOException {

		Properties propertiesFile = new Properties();
		InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(fileName);

		propertiesFile.load(inputStream);
		inputStream.close();

		return propertiesFile;
	}

	public static WebEnvironment getWebEnvironment() throws IOException {

		Properties webPropertyFile = loadPropertiesFile(WEB_PROPERTIES);

		WebEnvironment webEnvironment = new WebEnvironment(
				webPropertyFile.getProperty("url"),
				webPropertyFile.getProperty("remove.server.url"),
				Integer.parseInt(webPropertyFile.getProperty("implicit.timeout.seg").trim()),
				Integer.parseInt(webPropertyFile.getProperty("explicit.timeout.seg").trim()),
				Integer.parseInt(webPropertyFile.getProperty("explicit.attempt.time.mili").trim()));

		return webEnvironment;
	}
	
	public static ApiEnvironment getApiEnvironment() throws IOException {

		Properties apiPropertyFile = loadPropertiesFile(API_PROPERTIES);

		ApiEnvironment apiEnvironment = new ApiEnvironment(apiPropertyFile.getProperty("url"));

		return apiEnvironment;
	}
}
