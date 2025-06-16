package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTesting extends BaseTest {

    public LoginTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runLoginTests() {
        try {
            Thread.sleep(5000);
            clickLoginButton();
            testLoginWrongFormat("tester", "password123");
            testLoginFailed("testuser@example.com", "password123");
            testLoginSuccess("kimochi9155@gmail.com", "111111");
        } catch (Exception e) {
            System.err.println("Error during login tests: " + e.getMessage());
        }
    }

    private void clickLoginButton() {
        try {
            Thread.sleep(3000);
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc='Log in with password']")));
            loginButton.click();
            System.out.println("Clicked 'Login' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Login' button: " + e.getMessage());
        }
    }

    private void enterEmail(String email) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
            emailField.click();
            System.out.println("Clicked email field.");
            emailField.clear();
            emailField.sendKeys(email);
            System.out.println("Entered email: " + email);
        } catch (Exception e) {
            System.err.println("Failed to enter email: " + e.getMessage());
        }
    }

    private void enterPassword(String password) {
        try {
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")));
            passwordField.click();
            System.out.println("Clicked password field.");
            passwordField.clear();
            passwordField.sendKeys(password);
            System.out.println("Entered password: " + password);
        } catch (Exception e) {
            System.err.println("Failed to enter password: " + e.getMessage());
        }
    }

    private void clickSignInButton() {
        try {
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc='Sign in']")));
            loginButton.click();
            System.out.println("Clicked 'Sign in' button.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Sign in' button: " + e.getMessage());
        }
    }

    private void testLoginWrongFormat(String email, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterPassword(password);
            clickSignInButton();
            System.out.println("Entered login credentials (wrong format) and clicked login.");
        } catch (Exception e) {
            System.err.println("Login with wrong format failed: " + e.getMessage());
        }
    }

    private void testLoginFailed(String email, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterPassword(password);
            clickSignInButton();
            System.out.println("Entered login credentials (failed) and clicked login.");
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        }
    }

    private void testLoginSuccess(String email, String password) {
        try {
            Thread.sleep(3000);
            enterEmail(email);
            enterPassword(password);
            clickSignInButton();
            System.out.println("Entered login credentials (success) and clicked login.");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));
            System.out.println("Login successful!");
        } catch (Exception e) {
            System.err.println("Login attempt failed: " + e.getMessage());
        }
    }
}
