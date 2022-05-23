import core.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
