package orangehrm_automation.orangehrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PIMPage {
    WebDriver driver;

    private By addEmployee = By.xpath("//a[text()='Add Employee']");
    private By employeeList = By.xpath("//a[text()='Employee List']");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddEmployee() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(addEmployee)).click();
    }

    public void goToEmployeeList() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(employeeList)).click();
    }
}