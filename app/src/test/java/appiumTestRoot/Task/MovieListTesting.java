package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


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


}
