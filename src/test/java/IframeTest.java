import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class IframeTest {

    @Test
    public void testNewWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        String currentWindow = driver.getWindowHandle();
        //driver.switchTo().frame(0); // indeks kolejnego okna iframe, małoprecyzyjne rozwiązanie moze być więcej i moga się mieszać

        WebElement iframe  = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe); // przłełączneie po wysukanym webElemencie

        //driver.switchTo().frame(""); // można użyć tylko gdzy iframe posiada id lub name

        driver.findElement(By.id("fname")).sendKeys("Patryk");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        Thread.sleep(3000);
        driver.quit();
    }
}
