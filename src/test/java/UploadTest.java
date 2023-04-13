import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UploadTest {
    @Test
    public void uploadFile() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        int randomNumber = (int) (Math.random()*1000); //Wywołanie randomowej liczby

        //driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\patry\\Desktop\\RepoToShow\\RepoToShow\\TestowyDoku.txt"); // pierwsza opcja wrzucenia dokumentu

        //można skorzystać z sikuliXa jesli nie da się powyższa opcją. SikuliX działa na zasadze roibi to co widzi.

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFileBefore = screenshot.getScreenshotAs(OutputType.FILE);
        String fileNameB = "beforeUploud" + randomNumber + ".png";
        FileUtils.copyFile(srcFileBefore, new File("C:\\Users\\patry\\IdeaProjects\\tutorialselenium\\src\\test\\resources\\" + fileNameB));

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\patry\\Desktop\\RepoToShow\\RepoToShow\\TestowyDoku.txt"); // pierwsza opcja wrzucenia dokumentu

        File srcFileAfter = screenshot.getScreenshotAs(OutputType.FILE);
        String fileNameA = "afterUploud" + randomNumber + ".png";
        FileUtils.copyFile(srcFileAfter, new File("C:\\Users\\patry\\IdeaProjects\\tutorialselenium\\src\\test\\resources\\" + fileNameA));

        Thread.sleep(3000);
        driver.quit();
    }
}
