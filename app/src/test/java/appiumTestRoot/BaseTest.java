package appiumTestRoot;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


public class BaseTest {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseTest(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void openHomePage() {
        try {
            Thread.sleep(3000);
            WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Home\n" +
                            "Tab 1 of 4\"]")));
            menuButton.click();
            System.out.println("Clicked 'Menu' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Menu' button: " + e.getMessage());
        }
    }
    public void openProfileTab() {
        try {
            Thread.sleep(2000);
            WebElement profileTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc='Profile\nTab 4 of 4']")));
            profileTab.click();
            System.out.println("Clicked 'Profile' tab successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Profile' tab: " + e.getMessage());
        }
    }


}
