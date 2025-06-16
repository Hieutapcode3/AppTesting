package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutTesting extends BaseTest {

    public LogoutTesting(AndroidDriver driver) {
        super(driver);
    }
    public  void runLogOutTest(){
        try{
            Thread.sleep(5000);
            openProfileTab();
            clickLogoutButton();
            logoutCancel();
            clickLogoutButton();
            logoutConfirm();
        } catch (Exception e) {
            System.err.println("Error during logout tests: " + e.getMessage());
        }
    }
    public void clickLogoutButton() {
        try {
            Thread.sleep(2000);
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc='Log out']")));
            logoutButton.click();
            System.out.println("Clicked 'Log out' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Log out' button: " + e.getMessage());
        }
    }

    public void logoutCancel() {
        try {
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Cancel']")));
            cancelButton.click();
            System.out.println("Clicked 'Cancel' on logout confirmation.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Cancel' on logout confirmation: " + e.getMessage());
        }
    }

    public void logoutConfirm() {
        try {
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Confirm']")));
            confirmButton.click();
            System.out.println("Clicked 'Confirm' on logout confirmation.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Confirm' on logout confirmation: " + e.getMessage());
        }
    }
}
