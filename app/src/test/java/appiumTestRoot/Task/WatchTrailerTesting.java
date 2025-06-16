package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WatchTrailerTesting extends BaseTest {

    public WatchTrailerTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runWatchTrailerTest() {
        try {
            Thread.sleep(5000);
            clickMoviesTab();
            clickNowPlayingSoonTab();
            clickMovieItem();
            clickTrailerButton();
            waitForWebViewAndPlay();
            Thread.sleep(10000);
            closeTrailer();
        } catch (Exception e) {
            System.err.println("Watch trailer test failed: " + e.getMessage());
        }
    }

    private void clickMoviesTab() {
        try {
            WebElement moviesTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Movies\nTab 3 of 4\"]")
            ));
            moviesTab.click();
            System.out.println("Clicked 'Movies' tab.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Movies' tab: " + e.getMessage());
        }
    }

    private void clickMovieItem() {
        try {
            Thread.sleep(3000);
            WebElement movie = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Predator: Killer of Killers\n8.0\n(491)\n1 hour 25 minutes\nAnimation, Action, Science Fiction\"]")
            ));
            movie.click();
            System.out.println("Clicked movie item.");
        } catch (Exception e) {
            System.err.println("Failed to click movie item: " + e.getMessage());
        }
    }

    private void clickTrailerButton() {
        try {
            Thread.sleep(3000);
            WebElement trailerButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Trailer\"]")
            ));
            trailerButton.click();
            System.out.println("Clicked 'Trailer' button.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Trailer' button: " + e.getMessage());
        }
    }

    private void waitForWebViewAndPlay() {
        try {
            WebElement webView = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("android.webkit.WebView")
            ));
            Thread.sleep(15000);
            webView.click();
            System.out.println("Clicked WebView to play trailer.");
        } catch (Exception e) {
            System.err.println("Failed to load and play trailer: " + e.getMessage());
        }
    }

    private void closeTrailer() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.className("android.widget.Button")
            ));
            closeButton.click();
            System.out.println("Closed trailer.");
        } catch (Exception e) {
            System.err.println("Failed to close trailer: " + e.getMessage());
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
