import base.Driver;
import helpers.RobotUploadFile;
import helpers.SendKeysUploadFile;
import helpers.UploadFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFileTest {

    private File fileToUpload = new File( String.format("src/main/resources/%s", fileName));
    private WebDriver driver;
    private static UploadFile uploadFile = new UploadFile();

    private static String BASE_URL = "https://the-internet.herokuapp.com/upload";
    private static String fileName = "api-vk.png";

    @Test
    public void uploadFileTest() {
        driver = Driver.getWebDriver(BASE_URL);

        uploadFile.processUpload(new SendKeysUploadFile(), driver, fileToUpload.getAbsolutePath());
        WebElement fileUploadedLabel = getFileUploadedLabel();

        assertEquals(fileName, fileUploadedLabel.getText(), String.format("Expected uploaded file: %s\nActual uploaded file: %s", fileName, fileUploadedLabel.getText()));
    }

    @Test
    public void uploadFileUsingRobotTest() {
        driver = Driver.getWebDriver(BASE_URL);

        driver.findElement(By.id("file-upload")).click();
        uploadFile.processUpload(new RobotUploadFile(), driver, fileToUpload.getAbsolutePath());
        WebElement fileUploadedLabel = getFileUploadedLabel();

        assertEquals(fileName, fileUploadedLabel.getText(), String.format("Expected uploaded file: %s\nActual uploaded file: %s", fileName, fileUploadedLabel.getText()));
    }

    private WebElement getFileUploadedLabel() {
        return driver.findElement(By.id("uploaded-files"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
