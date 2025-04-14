package orangehrm_automation.orangehrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddEmployeePage {
    WebDriver driver;

    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By saveButton = By.cssSelector("button[type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String fName, String lName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}