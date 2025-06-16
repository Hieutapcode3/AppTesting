package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class MovieListTesting extends BaseTest {

    public MovieListTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runMovieListTest() {
        try {
            Thread.sleep(5000);
            clickMovieTab();
            clickNowPlayingSoonTab();
            scrollDown();
            clickComingSoonTab();
            scrollDown();
        } catch (Exception e) {
            System.err.println("Error in MovieListTesting: " + e.getMessage());
        }
    }

    private void clickMovieTab() {
        try {
            WebElement movieTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Movies\nTab 3 of 4\"]")));
            movieTab.click();
            System.out.println("Clicked 'Movies' tab.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Movies' tab: " + e.getMessage());
        }
    }

    private void clickComingSoonTab() {
        try {
            Thread.sleep(3000);
            WebElement comingSoonTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Coming Soon\"]")));
            comingSoonTab.click();
            System.out.println("Clicked 'Coming Soon' tab.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Coming Soon' tab: " + e.getMessage());
        }
    }
    private void clickNowPlayingSoonTab() {
        try {
            Thread.sleep(3000);
            WebElement nowPlayingTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Now Playing\"]")));
            nowPlayingTab.click();
            System.out.println("Clicked 'NowPlaying' tab.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Coming Soon' tab: " + e.getMessage());
        }
    }

    private void scrollDown() {
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
}
