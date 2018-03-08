package org.nik;

import java.text.DecimalFormat;

public class WeatherconversionService {
	
	
	private WeatherUtilName waUtilName = new WeatherUtilName();

	private static final String DEGREE = "\u00b0";

	/**
	 * Converts Celcius to Fahrenheit
	 * 
	 * @param celcius
	 * @return
	 */
	public String convertToFahrenheit(double celcius) {
		System.out.println("Converting: " + getWeatherFormattedstring(celcius, 'C'));
		return getWeatherFormattedstring(WeatherConversionUtil.convertToFahrenheit(celcius), 'F');
	}

	private String getWeatherFormattedstring(double celcius, char unit) {
		return String.format("%s%s%s", new DecimalFormat("0.00").format(celcius), DEGREE, unit);
	}
	
	public String message(){
		System.out.println("Going to Invoke final Method");
		return waUtilName.printWeatherConversionUtilClassName();
	}
}