package appiumTestRoot;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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
            WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Home\n" +
                            "Tab 1 of 4\"]")));
            homeButton.click();
            System.out.println("Clicked 'Home' button successfully.");
            scrollUp();
        } catch (Exception e) {
            System.err.println("Failed to click 'Home' button: " + e.getMessage());
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
    public void scrollDown() {
        try {
            Thread.sleep(5000);
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            int startX = width / 2;
            int startY = (int) (height * 0.9);
            int endY = (int) (height * 0.1);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(List.of(swipe));
            System.out.println("Scrolled down.");
        } catch (Exception e) {
            System.err.println("Scroll failed: " + e.getMessage());
        }
    }
    public void scrollUp() {
        scrollUp(0.1f, 0.9f);
    }

    public void scrollUp(float startRatio, float endRatio) {
        try {
            Thread.sleep(5000);
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            int startX = width / 2;
            int startY = (int) (height * startRatio);
            int endY = (int) (height * endRatio);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(List.of(swipe));
            System.out.println("Scrolled up.");
        } catch (Exception e) {
            System.err.println("Scroll failed: " + e.getMessage());
        }
    }



}
