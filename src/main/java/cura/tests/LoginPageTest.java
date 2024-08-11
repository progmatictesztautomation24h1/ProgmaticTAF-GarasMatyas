package cura.tests;

import core.DriverManager;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends DriverManager {


    @Test(groups = {"regression"}, description = "Open the login page and check if the login is not succesfull with invalid data.")
    public void doLoginPageTest() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogInPage();
        Assert.assertTrue(loginPage.isLoginPageLoaded());
        loginPage.clickOnLogin();
        Assert.assertTrue(loginPage.isLogInFailed());

    }
}
