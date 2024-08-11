package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By menuBy = By.id("menu-toggle");
    private final By logInInMenuBy = By.cssSelector("a[href='profile.php#login']");
    private final By textBy = By.xpath("//h2[contains(text(),'Login')]");
    private final By usernameTextBy = By.cssSelector("input[aria-describedby='demo_username_label']");
    private final By passwordTextBy = By.cssSelector("input[aria-describedby='demo_password_label']");
    private final By usernameInputBy = By.id("txt-username");
    private final By passwordInputBy = By.id("txt-password");
    private String name = "";
    private String password = "";
    private final By loginButtonBy = By.id("btn-login");
    private final By failedTitleBy = By.cssSelector("p[class='lead text-danger']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLogInPage() {
        System.out.println("Opening Login page");
        WebElement menu = driver.findElement(menuBy);
        menu.click();
        WebElement profile = driver.findElement(logInInMenuBy);
        profile.click();
    }

    public boolean isLoginPageLoaded() {
        System.out.println("Checking if Login page is loaded");
        WebElement element = driver.findElement(textBy);
        return element.isDisplayed();
    }

    public void getUsername() {
        System.out.println("Getting the username from the demo username field");
        WebElement getName = driver.findElement(usernameTextBy);
        name = getName.getAttribute("value");
    }

    public void getPassword() {
        System.out.println("Getting the password from the demo password field");
        WebElement getPassword = driver.findElement(passwordTextBy);
        password = getPassword.getAttribute("value");
    }

    public void fillUsernameInput() {
        System.out.println("Filling the username input field with the demo username");
        WebElement input = driver.findElement(usernameInputBy);
        input.sendKeys(name);
    }

    public void fillPasswordInput() {
        System.out.println("Filling the password filed with the demo password");
        WebElement passwordInput = driver.findElement(passwordInputBy);
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        System.out.println("Clicking on the Login button");
        WebElement button = driver.findElement(loginButtonBy);
        button.click();
    }


    public boolean isLogInFailed() {
        System.out.println("Checking if Login is failed");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(failedTitleBy));
        return element.isDisplayed();
    }
}
