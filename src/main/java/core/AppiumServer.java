package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import utils.ConfigReader;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;


public class AppiumServer {
    public static String logFilePath = "target/appium-log/appium" + LocalDateTime.now() + ".log";
    public static AppiumDriverLocalService service;
    static Map<String, String> env = new HashMap<String, String>(System.getenv());

    public static void startServer() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(env.get("APPIUM_PATH")))
                .withIPAddress(ConfigReader.get("LOCAL_APPIUM_SERVER_IP"))
                //.usingPort(ConfigReader.getInt("APPIUM_DEFAULT_PORT"))
                .withArgument(BASEPATH, ConfigReader.get("APPIUM_SERVER_BASEPATH"))
                .withArgument(SESSION_OVERRIDE)
                .withEnvironment(env)
                .withTimeout(Duration.ofSeconds(60))
                .usingDriverExecutable(new File(env.get("NODE_PATH")))
                //.withLogFile(new File(logFilePath))
                .build();
        service.start();
    }

    public static void stopServer() {
        service.stop();
    }
}
