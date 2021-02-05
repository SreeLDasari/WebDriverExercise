package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestNG_TestParameters {
  @Test
  public void f() {
	  
	  System.out.println("TestNG_TestParameters -> test mthd ");
	  System.out.println("1. Parameter value from xml file: ");
	  System.out.println("2. Parameter value from xml file: ");

	  
  }
  @BeforeMethod
  @Parameters({"bowser"})
  public void beforeClass(String bowser) {
	  System.out.println(bowser+" chrome");
	  System.out.println("TestNG_TestParameters -> before class");
	  System.out.println("1. Parameter value from xml file: ");
	
  }

}
