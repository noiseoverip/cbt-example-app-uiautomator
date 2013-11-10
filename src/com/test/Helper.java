package com.test;

import java.io.IOException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Helper {
	private UiAutomatorTestCase testcase;

	public Helper(UiAutomatorTestCase testcase) {
		this.testcase = testcase;
	}

	public void findAppWithName(String name, String packagename) throws UiObjectNotFoundException {

		try {
			Runtime.getRuntime().exec("am start -n " + packagename);
			testcase.sleep(1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			testcase.sleep(1000);
			if (testcase.getUiDevice().getCurrentPackageName().contains(packagename)) {
				return;
			}
		}
		return;
	}

	public void closeApp() {
		testcase.getUiDevice().pressBack();
		testcase.getUiDevice().pressBack();
	}
}
