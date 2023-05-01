package web.framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.utils.PropertiesReader;
import web.entities.WebEnvironment;

public abstract class PageObjectBase {

	private static WebDriver driver = null;
	private static WebEnvironment webEnvironmentFile;

	public PageObjectBase() {
	}

	public static synchronized WebDriver getDriverInstance() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

		if (driver == null) {

			try {
				
				webEnvironmentFile = PropertiesReader.getWebEnvironment();

				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(webEnvironmentFile.getImplicityTimeout(), TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return driver;

	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static WebDriverWait createWebDriverWait() {
		return new WebDriverWait(getDriverInstance(), webEnvironmentFile.getExplicityTimeout(),
				webEnvironmentFile.getExplicityAttemptTime());
	}
	
	public static void browserBack() {
		getDriverInstance().navigate().back();
	}

	public static void browserForward() {
		getDriverInstance().navigate().forward();
	}

	public static void browserRefresh() {
		getDriverInstance().navigate().refresh();
	}

	public static void deleteAllCookies() {
		getDriverInstance().manage().deleteAllCookies();
	}

	public static WebElement getWebElemet(By locator) {
		return getDriverInstance().findElement(locator);
	}
	
	public static List<WebElement> getWebElemets(By locator) {
		return getDriverInstance().findElements(locator);
	}


	public static Select getSelectElement(By locator) {
		WebElement element = getDriverInstance().findElement(locator);
		Select selectElement = new Select(element);
		return selectElement;
	}

	public static String getCurrentURL() {
		return getDriverInstance().getCurrentUrl();
	}

	public static String getTitle() {
		return getDriverInstance().getTitle();
	}

	public static void startApp() {
		getDriverInstance().navigate().to(webEnvironmentFile.getUrl());
		getDriverInstance().manage().window().maximize();
	}

	public static void startApp(String url) {
		getDriverInstance().navigate().to(url);
		getDriverInstance().manage().window().maximize();
	}

	public static void goToURL(String url) {
		getDriverInstance().get(url);
	}

}
