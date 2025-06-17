package appiumTestRoot;

import appiumTestRoot.Task.ChangePassTesting;
import appiumTestRoot.Task.CheckTicketTesting;
import appiumTestRoot.Task.EditUserNameTesting;
import appiumTestRoot.Task.LoginTesting;
import appiumTestRoot.Task.LogoutTesting;
import appiumTestRoot.Task.MovieListTesting;
import appiumTestRoot.Task.OrderTicketTesting;
import appiumTestRoot.Task.RegisterTesting;
import appiumTestRoot.Task.SearchingTesting;
import appiumTestRoot.Task.WatchTrailerTesting;
import io.appium.java_client.android.AndroidDriver;



public class TestTask {
    private final AndroidDriver driver;

    public TestTask(AndroidDriver driver) {
        this.driver = driver;
    }

    public void runTestTask() {
        try {
//            RegisterTesting registerTesting = new RegisterTesting(driver);
//            registerTesting.runRegisterTests();
//            System.out.println("Register Test Successful");

//            LoginTesting loginTesting = new LoginTesting(driver);
//            loginTesting.runLoginTests();
//            System.out.println("Login Test Successful");

//            MovieListTesting showMovieListTesting = new MovieListTesting((driver));
//            showMovieListTesting.runMovieListTest();
//            System.out.println("Show Movie Test Successful");
//
//            SearchingTesting searchTesting = new SearchingTesting(driver);
//            searchTesting.runSearchTest();
//            System.out.println("Search Movie Test Successful");
//
//            WatchTrailerTesting watchTrailerTesting = new WatchTrailerTesting(driver);
//            watchTrailerTesting.runWatchTrailerTest();
//            System.out.println("Watch Trailer Test Successful");

//            OrderTicketTesting orderTicketTesting = new OrderTicketTesting(driver);
//            orderTicketTesting.runOrderTicketTest();
//            System.out.println("Order Ticket Test Successful");

            CheckTicketTesting checkTicket = new CheckTicketTesting(driver);
            checkTicket.runCheckTicketTest();
            System.out.println("Check Ticket Test Successful");


//            EditUserNameTesting editNameTesting = new EditUserNameTesting(driver);
//            editNameTesting.runEditUserNameTest();
//            System.out.println("Edit Name Test Successful");

//            ChangePassTesting changePassTest = new ChangePassTesting(driver);
//            changePassTest.runChangePassWordTest();
//            System.out.println("ChangePass Test Successful");
//
//            LogoutTesting logoutTesting = new LogoutTesting(driver);
//            logoutTesting.runLogOutTest();
//            System.out.println("LogOut Test Successful");


        } catch (Exception e) {
            System.err.println("Error during LoginTesting: " + e.getMessage());
        }
    }
}
