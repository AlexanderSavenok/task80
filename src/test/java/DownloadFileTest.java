import base.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadFileTest {

    private static String BASE_URL = "https://the-internet.herokuapp.com/download";

    private WebDriver driver;

    @Test
    public void downloadFileTest() {
        driver = Driver.getWebDriver(BASE_URL);

        driver.findElement(By.cssSelector("a[href='download/some-file.txt']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
