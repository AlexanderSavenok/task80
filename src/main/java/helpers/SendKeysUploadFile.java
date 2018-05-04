package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendKeysUploadFile implements IFileUploadStrategy {

    @Override
    public void UploadFile(WebDriver driver, String filePath) {
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
    }
}
