package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	
	 @BeforeTest
	  public void beforeTest() {
		  System.out.println("before test");

	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("after test");

	  }
  @Test
  public void f() {
	  System.out.println("Test");
  }
  @Test(dependsOnMethods= {"f"})
  public void f2() {
	  System.out.println("Test2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before mthd");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after mtd");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before new test1 clas");

  }
  

  @AfterClass
  public void afterClass() {
	  System.out.println("after new test1 class");

  }

 

}
