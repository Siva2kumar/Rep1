package DriverFactory;

import org.testng.annotations.Test;

public class AppTest {
@Test
	public void kickstart() throws Throwable
	{
		DriverScript ds=new DriverScript();
		try{
			ds.startTest();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
