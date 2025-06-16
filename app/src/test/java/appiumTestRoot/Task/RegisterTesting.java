package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class RegisterTesting extends BaseTest {

    public RegisterTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runRegisterTests() {
        try {
            gotoRegisterPage();
            testRegisterWrongFormat("tester", "testuser", "password123");
            testRegisterFailed("existinguser@example.com", "existinguser", "11111");
            testRegisterSuccess("hieupham9155@gmail.com", "hieuthu3", "123456");
        } catch (Exception e) {
            System.err.println("Error during register tests: " + e.getMessage());
        }
    }

    private void gotoRegisterPage() {
        try {
            Thread.sleep(3000);
            WebElement registerLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.view.View[@content-desc=\"Don't have an account? \nRegister\"]")));
            int x = registerLink.getLocation().getX() + 600;
            int y = registerLink.getLocation().getY() + 40;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap));
            System.out.println("Clicked 'Register' link successfully at coordinates (" + x + ", " + y + ").");
        } catch (Exception e) {
            System.err.println("Failed to go to RegisterPage: " + e.getMessage());
        }
    }

    private void enterEmail(String email) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[1]")));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(email);
            System.out.println("Entered email: " + email);
        } catch (Exception e) {
            System.err.println("Failed to enter email: " + e.getMessage());
        }
    }

    private void enterUsername(String username) {
        try {
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[2]")));
            usernameField.click();
            usernameField.clear();
            usernameField.sendKeys(username);
            System.out.println("Entered username: " + username);
        } catch (Exception e) {
            System.err.println("Failed to enter username: " + e.getMessage());
        }
    }

    private void enterPassword(String password) {
        try {
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[3]")));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(password);
            System.out.println("Entered password: " + password);
        } catch (Exception e) {
            System.err.println("Failed to enter password: " + e.getMessage());
        }
    }

    private void clickSignUpButton() {
        try {
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Continue\"]")));
            signUpButton.click();
            System.out.println("Clicked 'Sign up' button.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Sign up' button: " + e.getMessage());
        }
    }

    private void testRegisterWrongFormat(String email, String username, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterUsername(username);
            enterPassword(password);
            clickSignUpButton();
            System.out.println("Entered register credentials (wrong format) and clicked sign up.");
        } catch (Exception e) {
            System.err.println("Register with wrong format failed: " + e.getMessage());
        }
    }

    private void testRegisterFailed(String email, String username, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterUsername(username);
            enterPassword(password);
            clickSignUpButton();
            System.out.println("Entered register credentials (failed) and clicked sign up.");
        } catch (Exception e) {
            System.err.println("Register failed: " + e.getMessage());
        }
    }

    private void testRegisterSuccess(String email, String username, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterUsername(username);
            enterPassword(password);
            clickSignUpButton();
            System.out.println("Entered register credentials (success) and clicked sign up.");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));
            System.out.println("Register successful!");
        } catch (Exception e) {
            System.err.println("Register attempt failed: " + e.getMessage());
        }
    }
}
