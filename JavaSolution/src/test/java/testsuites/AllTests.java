package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import api.tests.DevicesTests;
import web.tests.FirstTestScenario;
import web.tests.FourthTestScenario;
import web.tests.SecondTestScenario;
import web.tests.ThirdTestScenario;

@RunWith(Suite.class)
@SuiteClasses({
	DevicesTests.class,
	FirstTestScenario.class,
	SecondTestScenario.class,
	ThirdTestScenario.class,
	FourthTestScenario.class
})
public class AllTests {

}
