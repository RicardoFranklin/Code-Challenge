package api.framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import common.categories.ApiCategory;

@Category(ApiCategory.class)
public class TestCaseBase {
	
	@Rule 
	public TestName name = new TestName();
	
		@Before
	public void beginLog () {
		System.out.println("################################################################ " + this.getClass().getSimpleName() + " - "+ name.getMethodName() +" - Begin ################################################################");
	}
	
	@After
	public void endLog () {
		System.out.println("################################################################ " + this.getClass().getSimpleName() +  " - "+ name.getMethodName() +" - End   ################################################################");
	}


}
