package com.test.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPStatusCode {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.w3schools.com/tags/ref_httpmethods.asp");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		System.out.println(code);
	}

}
