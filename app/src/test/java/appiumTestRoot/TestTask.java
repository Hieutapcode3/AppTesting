package appiumTestRoot;

import appiumTestRoot.Task.LoginTesting;
import io.appium.java_client.android.AndroidDriver;



public class TestTask {
    private final AndroidDriver driver;

    public TestTask(AndroidDriver driver) {
        this.driver = driver;
    }

    public void runLoginTesting() {
        try {
            LoginTesting loginTesting = new LoginTesting(driver);
            loginTesting.clickImageView();
            System.out.println("Click ImageView test completed.");
        } catch (Exception e) {
            System.err.println("Error during LoginTesting: " + e.getMessage());
        }
    }
}
