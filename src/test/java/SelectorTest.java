import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findEleements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement clickOnMe = driver.findElement(By.id("clickOnMe"));

        WebElement firstName = driver.findElement(By.id("fname"));

        WebElement paraHiden = driver.findElement(By.className("topSecret"));

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Dzień dobry");

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());

        WebElement linkText = driver.findElement(By.linkText("Visit W3Schools.com!"));

        WebElement linkText2 = driver.findElement(By.partialLinkText("Weird"));
    }
}
