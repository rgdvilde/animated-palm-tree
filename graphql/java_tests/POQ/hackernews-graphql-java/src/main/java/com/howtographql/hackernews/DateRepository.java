package com.howtographql.hackernews;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.*;


public class DateRepository {

	public DateRepository() {

	}

	public Date addTemperature(Date d) throws java.io.UnsupportedEncodingException, java.net.MalformedURLException {
		try {

			String baseUrl = "https://query.yahooapis.com/v1/public/yql?q=";
			String query = "select item.condition from weather.forecast where woeid = 2487889";
			String fullUrlStr = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";
			System.out.println(fullUrlStr);
			System.out.println("1");
			URL fullUrl = new URL(fullUrlStr);
			
			
			JSONObject jsonObject = JsonReader.readJsonFromUrl(fullUrlStr);
			//
		   
			System.out.println("2");
		System.out.println("3");
		
			
			JSONObject een = (JSONObject)jsonObject.get("query");
			JSONObject twee = (JSONObject)een.get("results");
			JSONObject drie = (JSONObject)twee.get("channel");
			JSONObject vier = (JSONObject)drie.get("item");
			JSONObject vijf = (JSONObject)vier.get("condition");
			int tempe = (int)vijf.get("temp");
			// ,java.net.MalformedURLException a,,,)
			System.out.println("3");
			System.out.print(""+tempe);
			System.out.println("___NEWDAT:" + d.getDay() + " " + d.getMonth() + " " + d.getYear() + " "+ tempe);
			return new Date(d.getDay(), d.getMonth(), d.getYear(), tempe);
		} catch (java.io.IOException | org.json.JSONExceptiona) {
			System.out.println("ERROR");
		}
		return null;
	}
}
