package main.java.kr.co.weather.common.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainService {
	
	private static final String API_KEY = "98cbd528c3567d033b5add1992086892";
	
	// 날씨api를 연결해 입력받은 지역의 현재날씨를 보여줌
	public void getWeatherInfo() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("지역을 입력하세요 : ");
		String location = sc.next();
		
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + ",KR&APPID=" + API_KEY + "&units=metric");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200 && conn.getResponseCode() != 404) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}else if(conn.getResponseCode() == 404) { // TODO : exception 처리하기
				System.out.println("올바른 지역을 다시 입력해주세요");
				this.getWeatherInfo();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("\n[현재 날씨]");
			while ((output = br.readLine()) != null) {
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(output);
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject weatherObj = (JSONObject) ((JSONArray) jsonObj.get("weather")).get(0);
				JSONObject temperObj = (JSONObject) jsonObj.get("main");
				
				
				
				System.out.println("지역 : " + jsonObj.get("name"));
				System.out.println("날씨 : " + weatherObj.get("description"));
				System.out.println("기온 : " + temperObj.get("temp_min"));
			}

			conn.disconnect();

		  } catch (MalformedURLException e) { // TODO : exception 처리하기
			e.printStackTrace(); 
		  } catch (IOException e) {
			e.printStackTrace();
		  }
	}

}