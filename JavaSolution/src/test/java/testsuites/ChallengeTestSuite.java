package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import web.tests.FirstTestScenario;
import web.tests.FourthTestScenario;
import web.tests.SecondTestScenario;
import web.tests.ThirdTestScenario;

@RunWith(Suite.class)
@SuiteClasses({
	FirstTestScenario.class,
	SecondTestScenario.class,
	ThirdTestScenario.class,
	FourthTestScenario.class
})
public class ChallengeTestSuite {

}
