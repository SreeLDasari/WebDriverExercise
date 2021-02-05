package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {
	
	@DataProvider(name="inputs")
	public Object[][] getData(){
		return new Object[][] {
			{"bmw","m3"},
			{"audi","a33"},
			{"benz","c300"}
			
		};
	}
	
  @Test(dataProvider="inputs")
  public void test(String input1,String input2) {
	  System.out.println("Input 1: "+input1);
	  System.out.println("Input 2: "+input2);

  }
}
