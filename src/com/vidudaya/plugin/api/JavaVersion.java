package com.vidudaya.plugin.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JavaVersion extends BrowserFunction {

	// http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fbrowser%2FBrowserFunction.html

	/*
	 * BrowserFunction : Instances of this class represent java-side "functions"
	 * that are invokable from javascript. Browser clients define these
	 * functions by subclassing BrowserFunction and overriding its
	 * function(Object[]) method. This method will be invoked whenever
	 * javascript running in the Browser makes a call with the function's name.
	 */

	// Good resource of BrowserFunction :
	// http://ramkulkarni.com/blog/using-java-objects-in-javascript-in-eclipse-swt-browser-control/
	// Good resource of BrowserFunction :
	// http://blog.vogella.com/2009/12/21/javascript-swt/
	// When adding a new JAR :
	// https://stackoverflow.com/questions/5744520/adding-jars-to-a-eclipse-plugin

	Browser browser = null;
	String functionName = null;

	public JavaVersion(Browser browser, String name) {
		super(browser, name);
		this.browser = browser;
		this.functionName = name;
	}

	/**
	 * This function will be called as 'getJavaVersion'
	 * 
	 */
	@Override
	public Object function(Object[] args) {
		String javaVersion = System.getProperty("java.version");
		String response = "Successfully called a Java function : Java Version = "
				+ javaVersion;

		String output = getsMap();

		return output;
	}

	public String gets() {
		String[] sentences = new String[3];
		sentences[0] = "Hi";
		sentences[1] = "Hello";
		sentences[2] = "How";

		Gson gson = new GsonBuilder().create();
		String jsonArray = gson.toJson(sentences);

		System.out.println("array in  : " + jsonArray);

		return jsonArray;
	}

	public String getsMap() {

		Map<String, Integer> map = new HashMap<>();
		map.put("key1", 100);
		map.put("key2", 300);
		map.put("key3", 400);

		Gson gson = new GsonBuilder().create();
		String jsonArray = gson.toJson(map);

		System.out.println("array in  : " + jsonArray);

		return jsonArray;
	}
}
