package appiumTestRoot.Task;

import appiumTestRoot.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderTicketTesting extends BaseTest {

    public OrderTicketTesting(AndroidDriver driver) {
        super(driver);
    }

    public void runOrderTicketTest() {
        try{
            clickSearchField();
            enterSearchKeyword("mission");
            selectMovieFromResults();
            scrollDown();
            continueFailed();
            continueSuccess();
            scrollDown();
            buyTicketFailed();
            buyTicketSuccess();
            discountFailed("testCode");
            discountSuccess("moviego");
            scrollDown();
            paymentFailed();
            paymentSuccess();
        } catch (Exception e) {
            System.err.println("Error during order Ticket tests: " + e.getMessage());

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

    private void continueFailed() {
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Continue']")));
            continueBtn.click();
            Thread.sleep(2000);
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Đóng\"]")));
            closeBtn.click();
            System.out.println("Continue failed due to missing cinema selection.");
        } catch (Exception e) {
            System.err.println("Continue failed step error: " + e.getMessage());
        }
    }

    private void continueSuccess() {
        try {
            Thread.sleep(2000);
            WebElement cinema = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc='Vincom Ocean Park CGV\nDa Ton, Gia Lam, Ha Noi']")));
            cinema.click();
            Thread.sleep(2000);
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Continue']")));
            continueBtn.click();
            System.out.println("Continued to seat selection.");
        } catch (Exception e) {
            System.err.println("Continue success step error: " + e.getMessage());
        }
    }

    private void buyTicketFailed() {
        try {
            Thread.sleep(2000);
            WebElement buyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Buy Ticket']")));
            buyBtn.click();
            Thread.sleep(1000);
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Đóng\"]")));
            closeBtn.click();
            System.out.println("Buy ticket failed due to no seat selected.");
        } catch (Exception e) {
            System.err.println("Buy ticket failed step error: " + e.getMessage());
        }
    }

    private void buyTicketSuccess() {
        try {
            Thread.sleep(2000);
            WebElement seat1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc='I5']")));
            seat1.click();
            WebElement seat2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc='F8']")));
            seat2.click();
            WebElement timeSlot = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc='13:00']")));
            timeSlot.click();
            scrollDown();
            Thread.sleep(2000);
            WebElement buyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc='Buy Ticket']")));
            buyBtn.click();
            System.out.println("Buy ticket success.");
        } catch (Exception e) {
            System.err.println("Buy ticket success step error: " + e.getMessage());
        }
    }
    private void fillDiscountCode(String discountCode){
        try{
            WebElement discountCodeInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.EditText")));
            discountCodeInput.clear();
            discountCodeInput.click();
            discountCodeInput.sendKeys(discountCode);
            System.out.println("Fill discount Code success.");
            Thread.sleep(1000);
            clickApplyDiscount();
        } catch (Exception e) {
            System.err.println("Fill discount step error " + e.getMessage());
        }
    }
    private void discountFailed(String code){
        try{
            fillDiscountCode(code);
        } catch (Exception e) {
            System.err.println("Apply discount step error " + e.getMessage());
        }
    }
    private void discountSuccess(String code){
        try{
            fillDiscountCode(code);
        } catch (Exception e) {
            System.err.println("Apply discount step error " + e.getMessage());
        }
    }
    private void clickApplyDiscount(){
        try{
            WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Apply\"]")));
            applyBtn.click();
            Thread.sleep(1000);
            clickCloseBtn();
        } catch (Exception e) {
            System.err.println("Can't click to Apply" + e.getMessage());
        }
    }
    private void clickCloseBtn(){
        try{
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Đóng\"]")));
            closeBtn.click();
        } catch (Exception e) {
            System.err.println("Can't click to Apply" + e.getMessage());
        }
    }
    private void paymentFailed(){
        try{
            Thread.sleep(1000);
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")));
            continueBtn.click();
            Thread.sleep(2000);
            clickCloseBtn();
        } catch (Exception e) {
            System.err.println("Can't click to Apply" + e.getMessage());
        }
    }
    private void paymentSuccess(){
        try{
            Thread.sleep(1000);
            WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@content-desc=\"Zalo Pay\"]")));
            paymentMethod.click();
            Thread.sleep(1000);
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")));
            continueBtn.click();
        } catch (Exception e) {
            System.err.println("Can't click to Apply" + e.getMessage());
        }
    }


}
