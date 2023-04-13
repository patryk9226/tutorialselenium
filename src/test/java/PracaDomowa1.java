import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PracaDomowa1 {

    public static void main(String[] args) throws InterruptedException {
        selectorTest("Audi");
        selectorTest("VolvoP");
    }

    public static void selectorTest(String typ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html?username=Mickey&password=Mouse");

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        //cars.selectByVisibleText("Saab");
        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            //String typeScan = option.getText();
            boolean test = typ.equals(option.getText());
            if (test == true) {
                System.out.println("Podana Marka: " + typ + " znajduje się w selecie ");
                break;
            } //else {
                //System.out.println("Podana Marka: " + typ + " NIE znajduje się w selecie ");
            //}

        }
        Thread.sleep(2000);
        driver.quit();
    }
}
