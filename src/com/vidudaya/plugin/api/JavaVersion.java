package com.vidudaya.plugin.api;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

public class JavaVersion extends BrowserFunction {

	Browser browser = null;
	String functionName = null;

	public JavaVersion(Browser browser, String name) {
		super(browser, name);
		this.browser = browser;
		this.functionName = name;
	}

	@Override
	public Object function(Object[] args) {
		String javaVersion = System.getProperty("java.version");
		String response = "Successfully called a Java function : Java Version = "
				+ javaVersion;
		return response;
	}
}
