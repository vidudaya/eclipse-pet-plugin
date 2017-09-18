package com.vidudaya.plugin.api;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

public class LowBugs extends BrowserFunction {

	Browser browser = null;
	String functionName = null;

	public LowBugs(Browser browser, String name) {
		super(browser, name);
		this.browser = browser;
		this.functionName = name;
	}

	/**
	 * This function will be called as 'getBugs'
	 * 
	 */
	@Override
	public Object function(Object[] args) {
		return getArray();
	}

	public Object[] getArray() {
		Object[] sentences = new String[3];
		sentences[0] = "type_1 30";
		sentences[1] = "type_2 44";
		sentences[2] = "type_3 26";

		return sentences;
	}

}
