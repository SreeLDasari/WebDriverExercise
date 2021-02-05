package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Grouping {
	
	

  @Test(groups= {"smoke","Reg"})
  public void test1() {
	  System.out.println("smoke,reg");
  }
  @Test(groups= {"Reg"})
  public void test2() {
	  System.out.println("Reg");

  }
  @Test
  public void test3() {
	  System.out.println("smoke");

	  
  }
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("after class");
  }

}
