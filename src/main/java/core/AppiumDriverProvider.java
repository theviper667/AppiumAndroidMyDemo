package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import utils.ConfigReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class AppiumDriverProvider {
    public static AppiumDriver driver;

    public static AppiumDriver startAppiumDriver() {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(ConfigReader.get("DEVICE_NAME"))
                .setUdid(ConfigReader.get("UDID"))
                .setPlatformName(ConfigReader.get("OPERATING_SYSTEM"))
                .setPlatformVersion(ConfigReader.get("OS_VERSION"))
                .setAvd(ConfigReader.get("DEVICE_NAME_AVD"))
                .setApp(ConfigReader.getPath("APP_PATH"))
                .setAppPackage(ConfigReader.get("APP_PACKAGE"))
                .setAppActivity(ConfigReader.get("APP_ACTIVITY"))
                .setAvdLaunchTimeout(Duration.ofMillis(60000))
                .noSign();

        try {
            driver = new AndroidDriver(new URL(ConfigReader.get("LOCAL_URL")), options);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeVirtualDevice() {
        try {
            Path adbPath = Paths.get(System.getenv("ANDROID_HOME"), "platform-tools", "adb");
            String adbCommand = adbPath.toString();

            String command = adbCommand + " -s " + ConfigReader.get("UDID") + " emu kill";

            ProcessBuilder processBuilder = new ProcessBuilder(
                    adbPath.toString(),
                    "-s",
                    ConfigReader.get("UDID"),
                    "emu",
                    "kill"
            );
            processBuilder.start();

        } catch (IOException e) {
            throw new RuntimeException("Failed to close virtual device via adb command.", e);
        }
    }
}
