package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppointmentPage {
    private final WebDriver driver;
    private final By appTextBy = By.xpath("//h2[contains(text(),'Make Appointment')]");
    private final By makeApButton = By.id("btn-make-appointment");
    private final By dateBy = By.id("txt_visit_date");
    private final By buttonBy = By.id("btn-book-appointment");
    private final By textBy = By.xpath("//h2[contains(text(),'Appointment Confirmation')]");
    private final By dropDownBy = By.id("combo_facility");
    private final By checkBoxBy = By.id("chk_hospotal_readmission");
    private final By medicareBy = By.id("radio_program_medicare");
    private final By medicaidBy = By.id("radio_program_medicaid");
    private final By noneBy = By.id("radio_program_none");
    private final By commentFieldBy = By.id("txt_comment");
    private final By menuBy = By.id("menu-toggle");
    private final By historyInMenuBy = By.cssSelector("a[href='history.php#history']");

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAppointmentPage() {
        System.out.println("Opening 'make appointment' page, if not loged in then navigate to the Login page");
        WebElement element = driver.findElement(makeApButton);
        element.click();
    }

    public boolean isAppointmentPageLoaded() {
        System.out.println("Checking if 'make appointment' page is loaded");
        WebElement element = driver.findElement(appTextBy);
        return element.isDisplayed();
    }

    public void dropDownMenu(String value) {
        System.out.println("Select from the dropdown menu (optional)");
        WebElement dropDown = driver.findElement(dropDownBy);
        dropDown.click();
        By valueBy = By.xpath("(//option[contains(text(), '" + value + "')])");
        WebElement valueOption = driver.findElement(valueBy);
        valueOption.click();
    }

    public void hospitalReadmissionCheckBox(String check) {
        System.out.println("Select the checkbox (optional)");
        WebElement checkbox = driver.findElement(checkBoxBy);
        if (check.equalsIgnoreCase("Y")) {
            checkbox.click();
        }
    }

    public void healthcareProgramRadio(String radio) {
        System.out.println("Select the radio button (optional)");
        if (radio.equalsIgnoreCase("Medicare")) {
            driver.findElement(medicareBy).click();
        } else if (radio.equalsIgnoreCase("Medicaid")) {
            driver.findElement(medicaidBy).click();
        } else if (radio.equalsIgnoreCase("None")) {
            driver.findElement(noneBy).click();
        }
    }

    public void commentInput(String comment) {
        System.out.println("Fill the commentfield (optional)");
        WebElement commentField = driver.findElement(commentFieldBy);
        commentField.sendKeys(comment);
    }

    public void fillDateInput(String date) {
        System.out.println("Filling date input field (required)");
        WebElement dateObject = driver.findElement(dateBy);
        dateObject.sendKeys(date);

    }

    public void clickOnButton() {
        System.out.println("click on booking button");
        WebElement apButton = driver.findElement(buttonBy);
        apButton.click();
    }

    public boolean isAppointmentSuccessfull() {
        System.out.println("Checking if the booking was successfull");
        WebElement element = driver.findElement(textBy);
        return element.isDisplayed();
    }

    public void openHistory() {
        System.out.println("Open history");
        WebElement menu = driver.findElement(menuBy);
        menu.click();
        WebElement history = driver.findElement(historyInMenuBy);
        history.click();
    }
}
