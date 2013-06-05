#!/bin/bash
# Proper header for a Bash script.

echo "Building test project with ant..."
CURRNT_DIR=${PWD}

ant build
adb push $CURRNT_DIR/bin/OneButtonUiTest.jar /data/local/tmp/
adb shell uiautomator runtest OneButtonUiTest.jar -c com.test.TestButton1,com.test.TestButton2,com.test.TestButton3,com.test.TestButton4

exit
