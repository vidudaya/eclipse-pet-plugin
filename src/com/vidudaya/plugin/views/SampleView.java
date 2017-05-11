package com.vidudaya.plugin.views;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.vidudaya.plugin.api.JavaVersion;

public class SampleView extends ViewPart {

	Browser browser;

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);

		parent.setLayout(gridLayout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(gridData);
		comp.setLayout(new FillLayout());
		Browser browser = new Browser(comp, SWT.NONE);

		ClassLoader classLoader = getClass().getClassLoader();
		String content;
		try {
			content = IOUtils.toString(classLoader
					.getResourceAsStream("com/vidudaya/plugin/html/home.html"),
					"UTF-8");

			browser.setText(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new JavaVersion(browser, "getJavaVersion");

		parent.pack();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}