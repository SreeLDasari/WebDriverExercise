package practise;

import org.testng.annotations.Test;

public class TestNG_TestParallel1 {
  @Test
  public void testMethod1() throws InterruptedException {
	  System.out.println("TestNG_TestParallel1->testMethod1");
	  Thread.sleep(6000);
	  System.out.println("TestNG_TestParallel1->testMethod1->More steps");

  }
  
  @Test
  public void testMethod2() throws InterruptedException {
	  
	  System.out.println("TestNG_TestParallel1->testMethod2");
	  Thread.sleep(6000);
	  System.out.println("TestNG_TestParallel1->testMethod2->More steps");
	  
  }
}
