package appiumTestRoot;

import io.appium.java_client.android.AndroidDriver;
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
//    private void openMenuPage() {
//        try {
//            Thread.sleep(3000);
//            WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.view.View[@content-desc='Menu']")));
//            menuButton.click();
//            System.out.println("Clicked 'Menu' button successfully.");
//        } catch (Exception e) {
//            System.err.println("Failed to click 'Menu' button: " + e.getMessage());
//        }
//    }


}
