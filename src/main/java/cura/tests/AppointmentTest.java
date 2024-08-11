package cura.tests;

import core.DriverManager;
import cura.pages.AppointmentPage;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTest extends DriverManager {

    @Test(groups = {"regression"}, description = "Open the appointment page, fill out the form. Check if it execute without error")
    public void doAppointmentPageTest() {
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

        Assert.assertTrue(appointmentPage.isAppointmentPageLoaded());
        appointmentPage.dropDownMenu("Hongkong CURA Healthcare Center");
        appointmentPage.hospitalReadmissionCheckBox("Y");
        appointmentPage.healthcareProgramRadio("none");
        appointmentPage.fillDateInput("2024/02/03");
        appointmentPage.commentInput("no comment");
        appointmentPage.clickOnButton();
        Assert.assertTrue(appointmentPage.isAppointmentSuccessfull());
    }
}
