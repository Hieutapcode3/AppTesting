package appiumTestRoot.Task;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration; // Thêm import này

public class LoginTesting {
    private AppiumDriver driver;

    public LoginTesting(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickImageView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            Thread.sleep(3000);
            // Click nút "You"
            By youButtonLocator = By.xpath("//android.widget.Button[@content-desc='You']");
            wait.until(ExpectedConditions.elementToBeClickable(youButtonLocator)).click();
            System.out.println("Clicked 'You' button successfully.");
            Thread.sleep(3000);
            By actionButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.google.android.youtube:id/button']");
            wait.until(ExpectedConditions.elementToBeClickable(actionButtonLocator)).click();
            System.out.println("Clicked action button successfully.");
        } catch (Exception e) {
            System.err.println("Error during button clicks: " + e.getMessage());
            e.printStackTrace();
        }
    }
}