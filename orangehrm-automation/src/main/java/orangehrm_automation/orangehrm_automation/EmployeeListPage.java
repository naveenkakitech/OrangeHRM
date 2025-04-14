package orangehrm_automation.orangehrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;

public class EmployeeListPage {
    WebDriver driver;

    private By tableRows = By.cssSelector(".oxd-table-body .oxd-table-row");

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyEmployee(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));

        List<WebElement> employeeRows = driver.findElements(tableRows);
        boolean found = false;

        for (WebElement row : employeeRows) {
            if (row.getText().contains(name)) {
                System.out.println("Name Verified: " + name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Name Not Found: " + name);
        }
    }
}
