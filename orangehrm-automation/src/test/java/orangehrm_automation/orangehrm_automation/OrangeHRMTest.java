package orangehrm_automation.orangehrm_automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

public class OrangeHRMTest {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PIMPage pimPage;
    AddEmployeePage addEmployeePage;
    EmployeeListPage employeeListPage;

    String[][] employees = {
        {"John", "Doe"},
        {"Alice", "Smith"},
        {"Robert", "Brown"},
        {"Emily", "Clark"}
    };

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        addEmployeePage = new AddEmployeePage(driver);
        employeeListPage = new EmployeeListPage(driver);
    }

    @Test
    public void testEmployeeFlow() {
        loginPage.login("Admin", "admin123");
        dashboardPage.waitForDashboard();
        dashboardPage.navigateToPIM();

        for (String[] emp : employees) {
            pimPage.clickAddEmployee();
            addEmployeePage.addEmployee(emp[0], emp[1]);
            dashboardPage.navigateToPIM(); // Re-navigate to PIM after saving
        }

        pimPage.goToEmployeeList();

        for (String[] emp : employees) {
            employeeListPage.verifyEmployee(emp[0]);
        }

        dashboardPage.logout();
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
    }
}