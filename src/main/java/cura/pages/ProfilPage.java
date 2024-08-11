package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilPage {
    private final WebDriver driver;
    private final By menuBy = By.id("menu-toggle");
    private final By profileInMenuBy = By.cssSelector("a[href='profile.php#profile']");
    private final By textBy = By.xpath("//h2[contains(text(),'Profile')]");

    public ProfilPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToProfile() {
        System.out.println("Opening the Profile page");
        WebElement menu = driver.findElement(menuBy);
        menu.click();
        WebElement profile = driver.findElement(profileInMenuBy);
        profile.click();
    }

    public boolean isProfilePageLoaded() {
        System.out.println("Checking if the Profile page is loaded");
        WebElement element = driver.findElement(textBy);
        return element.isDisplayed();
    }
}
