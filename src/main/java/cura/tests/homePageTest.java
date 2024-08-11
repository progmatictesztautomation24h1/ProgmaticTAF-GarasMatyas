package cura.tests;

import core.DriverManager;
import cura.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homePageTest extends DriverManager {

    @Test(groups = {"regression"}, description = "Open the home page and checking if the 'make appointment' button is clickable.")
    public void doHomePageTest() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        Assert.assertTrue(homePage.isButtonClickable());
    }
}