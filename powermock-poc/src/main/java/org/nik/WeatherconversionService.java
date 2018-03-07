package org.nik;

public class WeatherconversionService {

	private static final String DEGREE = "\u00b0";

	/**
	 * Converts Celcius to Fahrenheit
	 * 
	 * @param celcius
	 * @return
	 */
	public String convertToFahrenheit(double celcius) {
		System.out.println("Converting: "+getWeatherFormattedstring(celcius, 'C'));
		return getWeatherFormattedstring(WeatherConversionUtil.convertToFahrenheit(celcius), 'F');
	}

	private String getWeatherFormattedstring(double celcius, char unit) {
		return String.format("%s%s%s", celcius, DEGREE, unit);
	}
}