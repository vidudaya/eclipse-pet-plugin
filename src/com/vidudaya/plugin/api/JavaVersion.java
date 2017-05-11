package com.vidudaya.plugin.api;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

public class JavaVersion extends BrowserFunction {

	// http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fbrowser%2FBrowserFunction.html

	/*
	 * BrowserFunction : Instances of this class represent java-side "functions"
	 * that are invokable from javascript. Browser clients define these
	 * functions by subclassing BrowserFunction and overriding its
	 * function(Object[]) method. This method will be invoked whenever
	 * javascript running in the Browser makes a call with the function's name.
	 */
	
	// Good resource of BrowserFunction : http://ramkulkarni.com/blog/using-java-objects-in-javascript-in-eclipse-swt-browser-control/
	// Good resource of BrowserFunction : http://blog.vogella.com/2009/12/21/javascript-swt/
	
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
		return response;
	}
}
