package main.java.kr.co.weather.common.model;

public class Weather {
	
	public Weather() {}
	
	// 지역
	private String location;
	// 기상 상태
	private String condition;
	// 현재 온도
	private String temperature;
	// 체감 온도
	private String feelsLike;
	// 최저 기온
	private String minTemperature;
	// 최고 기온
	private String maxTemperature;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(String feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(String minTemperature) {
		this.minTemperature = minTemperature;
	}
	public String getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(String maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	
}
