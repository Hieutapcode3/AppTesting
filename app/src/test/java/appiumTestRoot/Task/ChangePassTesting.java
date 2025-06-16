package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePassTesting extends BaseTest {

    public ChangePassTesting(AndroidDriver driver) {
        super(driver);
    }
    public  void runChangePassWordTest(){
        try{
            Thread.sleep(5000);
            openProfileTab();
            openChangePasswordPage();
            changePasswordWrongOldPass("testpassword","wrongpass","wrongpass");
            changePasswordWrongConfirm("000000","wrongpass","notsamepass");
            changePasswordSuccess("000000","111111","111111");
        } catch (Exception e) {
            System.err.println("Error during change pass tests: " + e.getMessage());
        }
    }
    private void openChangePasswordPage() {
        try {
            Thread.sleep(2000);
            WebElement changePassBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc='Change password']")));
            changePassBtn.click();
            System.out.println("Opened Change Password page.");
        } catch (Exception e) {
            System.err.println("Failed to open Change Password page: " + e.getMessage());
        }
    }

    private void fillChangePasswordFields(String oldPass, String newPass, String confirmPass) {
        try {
            Thread.sleep(3000);
            WebElement oldPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
            oldPassField.click();
            oldPassField.clear();
            oldPassField.sendKeys(oldPass);

            WebElement newPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")));
            newPassField.click();
            newPassField.clear();
            newPassField.sendKeys(newPass);

            WebElement confirmPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")));
            confirmPassField.click();
            confirmPassField.clear();
            confirmPassField.sendKeys(confirmPass);

            System.out.println("Filled in password fields.");
        } catch (Exception e) {
            System.err.println("Failed to fill in password fields: " + e.getMessage());
        }
    }

    private void submitChangePassword() {
        try {
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Save\"]")));
            submitBtn.click();
            System.out.println("Clicked 'Submit' to change password.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Submit': " + e.getMessage());
        }
    }

    public void changePasswordWrongOldPass(String oldPass, String newPass, String confirmPass) {
        try {
            fillChangePasswordFields(oldPass, newPass, confirmPass);
            submitChangePassword();
            System.out.println("Tried changing password with wrong old password.");
        } catch (Exception e) {
            System.err.println("Change password (wrong old pass) failed: " + e.getMessage());
        }
    }

    public void changePasswordWrongConfirm(String oldPass, String newPass, String confirmPass) {
        try {
            fillChangePasswordFields(oldPass, newPass, confirmPass);
            submitChangePassword();
            System.out.println("Tried changing password with mismatched confirm password.");
        } catch (Exception e) {
            System.err.println("Change password (wrong confirm) failed: " + e.getMessage());
        }
    }

    public void changePasswordSuccess(String oldPass, String newPass, String confirmPass) {
        try {
            fillChangePasswordFields(oldPass, newPass, confirmPass);
            submitChangePassword();
            System.out.println("Changed password successfully.");
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View")));
            Thread.sleep(1000);
            openHomePage();
        } catch (Exception e) {
            System.err.println("Change password (success) failed: " + e.getMessage());
        }
    }
}
