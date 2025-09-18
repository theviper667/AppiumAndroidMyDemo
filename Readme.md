# AppiumAndroidMyDemo
Project to demonstrate functional testing with Appium in Java, TestNG, Allure Reports and Maven on the MyDemo Android app.

This project primarily uses a Page Object Model design pattern.

The project also demonstrates basic data driving but with a single data set to preserve brevity of smoke testing.

## Prerequisites

1. Java JDK installed and configured in `PATH`.
2. Maven installed and configured in `PATH`.
3. Node.js and npm installed and configured in `PATH`.
4. Android Studio and AVD Manager installed and Android SDK configured in `PATH`.
5. Appium Server installed via npm (`npm install -g appium@latest`)
6. Appium Driver installed via npm (`appium driver install uiautomator2`)
7. An Android Virtual Device setup and configured in project (instructions below)

## Emulated Device Setup (Once Prerequisites are in place)
1. Follow the steps here https://developer.android.com/studio/run/managing-avds to create an AVD through Android Studio  
OR  
Open CMD and execute `avdmanager create avd --name MyAVDName --package "system-images;android-29;google_apis;x86"` replacing the name with
your own choice of name and Android system image (Android 10 is highly recommended for stability and compatibility)
2. Open `src/main/resources/config.properties`
3. Replace `DEVICE_NAME` with the device name created above
4. Replace `DEVICE_NAME_AVD` with the same name (to confirm AVD name navigate to `$ANDROID_HOME/emulator` and run `./emulator -list-avds`
    in CMD)
5. Open CMD while the AVD is open and run `adb devices` in CMD. Enter the returned emulator-XXXX text into `UDID`


## Execute Test Suite

## Scenarios Tested