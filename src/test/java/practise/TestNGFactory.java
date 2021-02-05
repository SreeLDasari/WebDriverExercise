package practise;

import org.testng.annotations.Factory;

public class TestNGFactory {
	
	@Factory()
	public Object[] getTestClasses(){
		return new Object[] {new TestNG_FactoryMthd(),new TestNG_FactoryMthd2()};
		
	}

}
