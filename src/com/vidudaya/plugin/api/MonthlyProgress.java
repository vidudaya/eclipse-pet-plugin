package com.vidudaya.plugin.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

public class MonthlyProgress extends BrowserFunction {

	Browser browser = null;
	String functionName = null;

	public MonthlyProgress(Browser browser, String name) {
		super(browser, name);
		this.browser = browser;
		this.functionName = name;
	}

	/**
	 * This function will be called as 'getMonthlyBugCounts'
	 * 
	 */
	@Override
	public Object function(Object[] args) {
		System.out.println("listing the monthly bug counts of category " + args[0]);
		try {
			return getArray(String.valueOf(args[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object[] getArray(String category) throws IOException {
		Object[] bugs = readFlatFileDB(category);
		return bugs;
	}

	private String[] readFlatFileDB(String category) throws IOException {
		File file = new File("C:\\phoenix-skill-tracker\\monthly-" + category
				+ ".txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		ArrayList<String> list = new ArrayList<>();
		while ((st = br.readLine()) != null) {
			System.out.println(st);
			list.add(st);
		}
		br.close();

		return list.toArray(new String[list.size()]);
	}

}
