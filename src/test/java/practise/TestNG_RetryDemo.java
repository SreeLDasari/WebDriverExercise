package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_RetryDemo {


	@Test(retryAnalyzer=practise.RetryAnalyzer.class)
	public void test1() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void test2() {
		Assert.assertEquals(false, true);

	}
}
