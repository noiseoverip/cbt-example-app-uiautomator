package com.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Helper {
	private UiAutomatorTestCase testcase;
	
	public Helper(UiAutomatorTestCase testcase) {
		this.testcase = testcase;
	}
	
	public void findAppWithName(String name, String packagename) throws UiObjectNotFoundException{
		testcase.getUiDevice().pressBack();
		testcase.getUiDevice().pressHome();		
		new UiObject(new UiSelector().description("Apps")).clickAndWaitForNewWindow();
	
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));		
		appViews.setAsHorizontalList();		
		UiObject settingsApp = appViews.getChildByText(
				new UiSelector().className(android.widget.TextView.class.getName()), name);
		settingsApp.clickAndWaitForNewWindow();
		
		//UiObject settingsValidation = new UiObject(new UiSelector().packageName(packagename));
		//assertTrue("Could not validate application package", settingsValidation.exists());
	}
	
	public void closeApp() {
		testcase.getUiDevice().pressBack();
		testcase.getUiDevice().pressBack();
	}
}
