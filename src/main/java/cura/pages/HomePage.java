package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By textBy = By.xpath("//h1[contains(text(),'CURA Healthcare Service')]");
    private final By appointmentButtonBy = By.id("btn-make-appointment");
    private final WebDriverWait wait;
    private final By menuBy = By.id("menu-toggle");
    private final By logOutInMenuBy = By.cssSelector("a[href='authenticate.php?logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isHomePageLoaded() {
        System.out.println("Check if home page is loaded");
        WebElement element = driver.findElement(textBy);
        return element.isDisplayed();
    }

    public boolean isButtonClickable() {
        System.out.println("Check if the 'Make Appointment' button is clickable");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(appointmentButtonBy));
        return element.isDisplayed();
    }

    public void clickOnLogOutButton() {
        System.out.println("Clicking on Logout button");
        WebElement menuButton = driver.findElement(menuBy);
        menuButton.click();
        WebElement logOutButton = driver.findElement(logOutInMenuBy);
        logOutButton.click();
    }
}
