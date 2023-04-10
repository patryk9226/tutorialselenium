import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest {
    @Test
    public void openGooglePage() throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        //kliknięcie przyciku (akceptacja cookies)
        agreeButton.click();
        //powrót do pierwotnego okna
        //driver.switchTo().defaultContent();
        //znajdz pole wyszukiwanie
        WebElement searchField = driver.findElement(By.name("q"));
        //wprowadz wartośc Selenium do pola
        searchField.sendKeys("Selenium");
        Thread.sleep(5);
        //zasymuluj naciśnięcie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        //znaleźć rezutat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
        //sprawdzenie/warunrek
        Assert.assertTrue(result.isDisplayed());
    }
    public WebDriver getDriver (String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw  new InvalidArgumentException("Invalid browser name");
        }
    }
}
