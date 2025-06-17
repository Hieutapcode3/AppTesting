package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Sequence;


import java.time.Duration;
import java.util.List;

public class CheckTicketTesting extends BaseTest {

    public CheckTicketTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runCheckTicketTest() {
        try {
            Thread.sleep(3000);
            openHomePage();
            clickTicketTab();
            clickBookedTicket();
        } catch (Exception e) {
            System.err.println("Check ticket test failed: " + e.getMessage());
        }
    }
    private void clickTicketTab() {
        try {
            WebElement ticketTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Ticket\nTab 2 of 4\"]")));
            ticketTab.click();
            System.out.println("Clicked Ticket tab.");
        } catch (Exception e) {
            System.err.println("Failed to click Ticket tab: " + e.getMessage());
        }
    }

    private void clickBookedTicket() {
        try {
            Thread.sleep(2000);
            WebElement ticket = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]")));

            int centerX = ticket.getLocation().getX() + ticket.getSize().getWidth() / 2;
            int centerY = ticket.getLocation().getY() + ticket.getSize().getHeight() / 2;
            int offsetX = (int) (ticket.getSize().getWidth() * 0.25);
            int finalX = centerX - offsetX;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), finalX, centerY));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(List.of(tap));

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]")));
            Thread.sleep(4000);
            System.out.println("Clicked booked ticket with offset.");
            clickBackBtn();
        } catch (Exception e) {
            System.err.println("Failed to click booked ticket with offset: " + e.getMessage());
        }
    }

    private void clickBackBtn() {
        try {
            WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")));
            backBtn.click();
            System.out.println("Clicked back Btn field.");
        } catch (Exception e) {
            System.err.println("Failed to click back Btn field: " + e.getMessage());
        }
    }
}
