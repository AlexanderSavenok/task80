package helpers;

import org.openqa.selenium.WebDriver;

public interface IFileUploadStrategy {

    void UploadFile(WebDriver driver, String filePath);

}
