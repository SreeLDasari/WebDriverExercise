package practise;

import org.testng.annotations.Test;

public class TestNGPriority {
  @Test(priority=1)
  public void test1() {
	  System.out.println("Priority1");
  }
  @Test(priority=2)

  public void test2() {
	  System.out.println("Priority2");

  }
  @Test(priority=3)

  public void test3() {
	  System.out.println("Priority3");

  }
}
