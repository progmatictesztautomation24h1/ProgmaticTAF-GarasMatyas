package cura.tests;

import core.DriverManager;

import cura.pages.AppointmentPage;
import cura.pages.HomePage;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverManager {

    @Test(groups = {"end2end"}, description = "Open the homepage, click on the 'make appointment' button, log in, fill out the appointment form, log out")
    public void doEndToEndTest() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.navigateToAppointmentPage();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageLoaded());
        loginPage.getUsername();
        loginPage.fillUsernameInput();
        loginPage.getPassword();
        loginPage.fillPasswordInput();
        loginPage.clickOnLogin();

        appointmentPage.dropDownMenu("Hongkong CURA Healthcare Center");
        appointmentPage.hospitalReadmissionCheckBox("Y");
        appointmentPage.healthcareProgramRadio("none");
        appointmentPage.fillDateInput("2024/12/4/04");
        appointmentPage.commentInput("no comment");
        appointmentPage.clickOnButton();
        Assert.assertTrue(appointmentPage.isAppointmentSuccessfull());


        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogOutButton();
        homePage.isHomePageLoaded();
    }
}
