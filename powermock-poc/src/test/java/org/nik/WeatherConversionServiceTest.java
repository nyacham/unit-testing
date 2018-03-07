package org.nik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="org.nik.*")
public class WeatherConversionServiceTest {
	
	private WeatherconversionService weatherCnvrsnService = new WeatherconversionService();
	
	@Spy
	private WeatherconversionService spy = new WeatherconversionService();
	
	
	private static final String DEGREE = "\u00b0";
	
	
	@Before
	public void setup(){
		PowerMockito.mockStatic(WeatherConversionUtil.class);
	}
	/**
	 * mocking static method here
	 */
	@Test
	public void testConversionMethodReturnsValidFormat(){
		PowerMockito.when(WeatherConversionUtil.convertToFahrenheit(Mockito.anyDouble())).thenReturn(200.00);
		Assert.assertTrue(weatherCnvrsnService.convertToFahrenheit(15.00).matches("\\d*.\\d+"+DEGREE+"[CF]"));
		Assert.assertTrue(weatherCnvrsnService.convertToFahrenheit(15.00).matches("\\d*.\\d+"+DEGREE+"[CF]"));
		PowerMockito.verifyStatic(Mockito.times(2));// should be used in the combination to the below step, 
													// which will essentially verify if the below invocation 
													// is done for specified number of times
		WeatherConversionUtil.convertToFahrenheit(15.0);
	}
	
	@Test
	public void testGetWeatherFormattedStringPrivateMethod() throws Exception{
		Mockito.when(WeatherConversionUtil.convertToFahrenheit(Mockito.anyDouble())).thenReturn(200.00);
        PowerMockito.when(spy, "getWeatherFormattedstring",Mockito.anyDouble(), Mockito.anyChar()).thenReturn("200.00"+DEGREE+"C");
		String convertToFahrenheit = spy.convertToFahrenheit(200.00);
		Assert.assertEquals("200.00"+DEGREE+"C", convertToFahrenheit);
	}
	
}
