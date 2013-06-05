package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * @author esauali
 * 
 */
public class TestButton2 extends UiAutomatorTestCase {

	private static final String TAG = "PushButtonTest";
	private Helper helper;
	private static final String buttonText = "button3";
	
	public void test1() throws UiObjectNotFoundException {

		Log.d(TAG, "Starting test");
		helper = new Helper(this);	
		helper.findAppWithName("CbtTestApp1", "com.cbttestapp1");
		
		new UiObject(new UiSelector().description(buttonText)).clickAndWaitForNewWindow(2000);			
		//new UiObject(new UiSelector().text("Apps")).click();
		
		// Find message and verify that it contains valid string
		UiObject message = new UiObject(new UiSelector().description("message"));
		assertTrue(message.exists());
		assertEquals(buttonText, message.getText());		
		helper.closeApp();
		Log.d(TAG, "Finish test");
	}

}
