package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchingTesting extends BaseTest {

    public SearchingTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runSearchTest() {
        try {
            openHomePage();
            scrollUp(0.2f,0.8f);
            Thread.sleep(5000);
            clickSearchField();
            enterSearchKeyword("mission");
            selectMovieFromResults();
            scrollDown();
            scrollUp();
            clickBackBtn();
        } catch (Exception e) {
            System.err.println("Search test failed: " + e.getMessage());
        }
    }

    private void clickSearchField() {
        try {
            Thread.sleep(2000);
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.EditText")));
            searchField.click();
            System.out.println("Clicked search field.");
        } catch (Exception e) {
            System.err.println("Failed to click search field: " + e.getMessage());
        }
    }

    private void enterSearchKeyword(String keyword) {
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText")));
            searchField.clear();
            searchField.sendKeys(keyword);
            System.out.println("Entered search keyword: " + keyword);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("Failed to enter search keyword: " + e.getMessage());
        }
    }

    private void selectMovieFromResults() {
        try {
            WebElement movieResult = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Mission: Impossible - The Final Reckoning\nAction, Adventure, Thriller\"]")));
            movieResult.click();
            System.out.println("Clicked on movie result.");
        } catch (Exception e) {
            System.err.println("Failed to click movie result: " + e.getMessage());
        }
    }
    private void clickBackBtn() {
        try {
            Thread.sleep(2000);
            WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")));
            backBtn.click();
            System.out.println("Clicked back Btn field.");
        } catch (Exception e) {
            System.err.println("Failed to click back Btn field: " + e.getMessage());
        }
    }

}
