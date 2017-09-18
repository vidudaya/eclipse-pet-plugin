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
import com.vidudaya.plugin.api.LowBugs;

public class SampleView extends ViewPart {

	// Browser :
	// https://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fbrowser%2FBrowser.html
	Browser browser;

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);

		// Understanding Layouts in SWT :
		// http://www.eclipse.org/articles/article.php?file=Article-Understanding-Layouts/index.html
		
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
			// Read the file content from the actual html file to a String
			// https://www.mkyong.com/java/java-read-a-file-from-resources-folder/
			content = IOUtils.toString(classLoader
					.getResourceAsStream("com/vidudaya/plugin/html/home.html"),
					"UTF-8");

			browser.setText(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Associate the 'getJavaVersion' function in 'JavaVersion.java' with the browser control
		new JavaVersion(browser, "getJavaVersion");
		new LowBugs(browser, "getLowBugs");
		
		parent.pack();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}