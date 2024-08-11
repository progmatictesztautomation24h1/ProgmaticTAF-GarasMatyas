package cura.tests;

import core.DriverManager;
import cura.pages.LoginPage;
import cura.pages.ProfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "Open the login page, fill out the form. Open the profile page")
    public void doProfilePageTest() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogInPage();
        Assert.assertTrue(loginPage.isLoginPageLoaded());
        loginPage.getUsername();
        loginPage.fillUsernameInput();
        loginPage.getPassword();
        loginPage.fillPasswordInput();
        loginPage.clickOnLogin();

        ProfilPage profilPage = new ProfilPage(driver);
        profilPage.navigateToProfile();
        Assert.assertTrue(profilPage.isProfilePageLoaded());
    }
}
