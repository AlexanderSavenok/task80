package helpers;

import org.openqa.selenium.WebDriver;

public class UploadFile {

    public void processUpload(IFileUploadStrategy strategy, WebDriver driver, String filePath) {
        strategy.UploadFile(driver, filePath);
    }

}
