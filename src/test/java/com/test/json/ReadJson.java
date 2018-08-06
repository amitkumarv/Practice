package com.test.json;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {
	public static void main(String[] args) {
		//Reading a JSON
		String JSONFile = ".\\APIResponses\\JSONData.json";
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSONFile));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
				result = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		// Parsing JSON
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(result);
			JSONObject job = (JSONObject)obj;
			System.out.println(job.get("responseCode"));
			System.out.println(job.get("responseData"));
			
			JSONArray jarrray = (JSONArray)job.get("responseData");
			System.out.println(jarrray.get(0));
			
			int x = 0;
			Boolean iterateLangArr = true;
			while (iterateLangArr) {
				JSONObject job2 = (JSONObject)jarrray.get(x);
				System.out.println(job2.get("value"));
				if(job2.get("value").toString().trim().equals("Portuguese")) {
					iterateLangArr = false;
				}
				x++;
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
