package com.test.API;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Simple GET request without headers
public class GetRequest {

	public static void main(String[] args) throws Exception {
		URL getLanguages = new URL("http://mastermicroapp.azurewebsites.net/api/v1/master/languages");
		URLConnection languages = getLanguages.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(languages.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			try {
				FileWriter writer = new FileWriter(".\\APIResponses\\GETLanguagesAPI.json", true);
				writer.write(inputLine);
				writer.write("\r\n"); // write new line
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sb.append(inputLine);
			System.out.println(inputLine);
		}
		in.close();

		System.out.println(sb.toString());

		// Parsing JSON
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(sb.toString());
			JSONObject job = (JSONObject) obj;
			System.out.println(job.get("responseCode"));
			System.out.println(job.get("responseData"));

			JSONArray jarrray = (JSONArray) job.get("responseData");
			System.out.println(jarrray.get(0));

			int x = 0;
			Boolean iterateLangArr = true;
			while (iterateLangArr) {
				JSONObject job2 = (JSONObject) jarrray.get(x);
				System.out.println(job2.get("value"));
				if (job2.get("value").toString().trim().equals("Portuguese")) {
					iterateLangArr = false;
				}
				x++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
