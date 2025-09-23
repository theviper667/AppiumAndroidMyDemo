# AppiumAndroidMyDemo
Project to demonstrate functional testing with Appium in Java, TestNG, Selenide, Allure Reports and Maven on the MyDemo Android app.

This project primarily uses a Page Object Model design pattern.

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
your own choice of name and Android system image (Android 10/API 29 is strongly recommended for stability and compatibility)
2. Open `src/main/resources/config.properties`
3. Replace `DEVICE_NAME` with the device name created above
4. Replace `DEVICE_NAME_AVD` with the same name (to confirm AVD name navigate to `$ANDROID_HOME/emulator` and run `./emulator -list-avds`
    in CMD)
5. Open CMD while the AVD is open and run `adb devices` in CMD. Enter the returned emulator-XXXX text into `UDID`


## Execute Test Suite

## Scenarios Tested
LoginTest
1. A user with valid credentials logs in successfully
2. A user that has logged in can logout successfully and is alerted to it
3. A locked out user cannot login and is alerted to their status
4. Attempting to login with a username but without a password shows the correct error
5. Attempting to login with a password but without a username shows the correct error
6. Attempting to login with unauthorized credentials shows the correct error

CatalogTest
1. Verify details of each product on the catalog and product pages
2. Full checkout flow for each product