package practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
  @Test
  public void foo() {
	  System.out.println("TestNG Demo");
	  Assert.assertEquals(2, 2);
	  Assert.assertTrue(2==2);
	  Assert.assertFalse(2==3);
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(2, 2);
	  sa.assertTrue(2!=3);
	  sa.assertFalse(2==3);
	  sa.assertAll();
	  
  }
}
