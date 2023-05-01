package web.framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import common.categories.WebCategory;

@Category (WebCategory.class)
public class TestCaseBase {
	
	@Rule 
	public TestName name = new TestName();	

	@Before
	public void openApp () {
		System.out.println("################################################################ " + this.getClass().getSimpleName() + " - "+ name.getMethodName() +" - Begin ################################################################");
		PageObjectBase.startApp();
	}
		
	@After
	public void tearDown () {		
		PageObjectBase.closeDriver();
		System.out.println("################################################################ " + this.getClass().getSimpleName() +  " - "+ name.getMethodName() +" - End   ################################################################");
	}	
	
}
