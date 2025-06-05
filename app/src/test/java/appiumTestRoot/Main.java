package appiumTestRoot;

import appiumTestRoot.Task.LoginTesting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Main {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("Pixel_9")
                .setPlatformVersion("16")
                .setAppPackage("com.google.android.youtube")
                .setAppActivity("com.google.android.youtube.app.honeycomb.Shell$HomeActivity")
                .setAutomationName("UiAutomator2")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        System.out.println("YouTube app opened successfully.");
    }

    @Test
    public void openYouTubeApp() throws InterruptedException {
        TestTask testTask = new TestTask(driver);
        testTask.runLoginTesting();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium session ended.");
        }
    }
}
