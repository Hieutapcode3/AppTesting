package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditUserNameTesting extends BaseTest {

    public EditUserNameTesting(AndroidDriver driver) {
        super(driver);
    }
    public void runEditUserNameTest() {
        try {
            Thread.sleep(5000);
            openProfileTab();
            goToEditUserNamePage();
            enterNewUserName("Hieuthu3");
            clickSaveButton();
            System.out.println("Username update test completed.");
        } catch (Exception e) {
            System.err.println("Failed to update username: " + e.getMessage());
        }
    }
    private void goToEditUserNamePage() {
        try {
            Thread.sleep(1000);
            WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Hieuthu3\nkimochi9155@gmail.com\"]/android.widget.ImageView[2]")));
            editBtn.click();
            System.out.println("Navigated to Edit Username page.");
        } catch (Exception e) {
            System.err.println("Failed to go to Edit Username page: " + e.getMessage());
        }
    }

    private void enterNewUserName(String newName) {
        try {
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText")));
            nameField.click();
            nameField.clear();
            nameField.sendKeys(newName);
            System.out.println("Entered new username: " + newName);
        } catch (Exception e) {
            System.err.println("Failed to enter new username: " + e.getMessage());
        }
    }

    private void clickSaveButton() {
        try {
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Save']")));
            saveBtn.click();
            System.out.println("Clicked 'Save' button.");
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View")));
            Thread.sleep(1000);
            openHomePage();
        } catch (Exception e) {
            System.err.println("Failed to click 'Save' button: " + e.getMessage());
        }
    }


}
