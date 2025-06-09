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
            clickYouButton();
            clickSignInButton();
            clickAddAccountButton();
            testLoginWrongFormat("tester", "password123");
            testLoginFailed("testuser@example.com", "password123");
            testLoginSuccess("kimochi9155@gmail.com", "a0982116599");
        } catch (Exception e) {
            System.err.println("Error during login tests: " + e.getMessage());
        }
    }

    private void clickYouButton() {
        try {
            WebElement youButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='You']")));
            youButton.click();
            System.out.println("Clicked 'You' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'You' button: " + e.getMessage());
        }
    }

    private void clickSignInButton() {
        try {
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@resource-id='com.google.android.youtube:id/button']")));
            signInButton.click();
            System.out.println("Clicked 'Sign In' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Sign In' button: " + e.getMessage());
        }
    }

    private void clickAddAccountButton() {
        try {
            WebElement addAccButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ListView[@resource-id='com.google.android.youtube:id/account_list']/android.widget.FrameLayout")));
            addAccButton.click();
            System.out.println("Clicked 'Add Account' button successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click 'Add Account' button: " + e.getMessage());
        }
    }

    private void testLoginWrongFormat(String email, String password) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("email_field_id")));  // TODO: Replace with actual email field ID
            emailField.sendKeys(email);

            WebElement passwordField = driver.findElement(By.id("password_field_id"));  // TODO: Replace with actual password field ID
            passwordField.sendKeys(password);

            WebElement loginButton = driver.findElement(By.id("sign_in_button_id"));  // TODO: Replace with actual sign-in button ID
            loginButton.click();

            System.out.println("Entered login credentials (wrong format) and clicked login.");
        } catch (Exception e) {
            System.err.println("Login with wrong format failed: " + e.getMessage());
        }
    }

    private void testLoginFailed(String email, String password) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("email_field_id")));  // TODO: Replace with actual email field ID
            emailField.sendKeys(email);

            WebElement passwordField = driver.findElement(By.id("password_field_id"));  // TODO: Replace with actual password field ID
            passwordField.sendKeys(password);

            WebElement loginButton = driver.findElement(By.id("sign_in_button_id"));  // TODO: Replace with actual sign-in button ID
            loginButton.click();

            System.out.println("Entered login credentials (failed) and clicked login.");
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        }
    }

    private void testLoginSuccess(String email, String password) {
        int retryCount = 0;
        boolean loginSuccessful = false;

        while (retryCount < 20 && !loginSuccessful) {
            try {
                WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("email_field_id")));  // TODO: Replace with actual email field ID
                emailField.clear();
                emailField.sendKeys(email);

                WebElement passwordField = driver.findElement(By.id("password_field_id"));  // TODO: Replace with actual password field ID
                passwordField.clear();
                passwordField.sendKeys(password);

                WebElement loginButton = driver.findElement(By.id("sign_in_button_id"));  // TODO: Replace with actual sign-in button ID
                loginButton.click();

                System.out.println("Entered login credentials (success) and clicked login. Attempt " + (retryCount + 1));

                Thread.sleep(3000);

                String pageSource = driver.getPageSource();

                if (pageSource.contains("Unable to connect to server")) {
                    System.err.println("Error: Unable to connect to server. Retrying...");
                } else if (!driver.findElements(By.id("success_indicator_id")).isEmpty()) {  // TODO: Replace with success indicator ID
                    System.out.println("Login successful!");
                    loginSuccessful = true;
                } else {
                    System.err.println("Login failed, retrying...");
                }
            } catch (Exception e) {
                System.err.println("Login attempt " + (retryCount + 1) + " failed: " + e.getMessage());
            }

            retryCount++;
            if (!loginSuccessful) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread sleep interrupted.");
                }
            }
        }

        if (!loginSuccessful) {
            System.err.println("Failed to login after " + retryCount + " attempts.");
        }
    }
}
