package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import api.tests.DevicesTests;

@RunWith(Suite.class)
@SuiteClasses({ 	 
	DevicesTests.class,	
})
public class DevicesRESTAPITest {	
	

}
