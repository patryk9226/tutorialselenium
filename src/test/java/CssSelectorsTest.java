import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
    public void findElements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement cssId = driver.findElement(By.cssSelector("#clickOnMe")); //szukaj w Id

        WebElement cssClass = driver.findElement(By.cssSelector(".topSecret")); //szukaj w class

        WebElement cssTag = driver.findElement(By.cssSelector("input")); //szukaj w Tagach
        cssTag.sendKeys("Dzień dobry");

        WebElement cssName = driver.findElement(By.cssSelector("[name='fname']")); //szukaj w innych np w name

        WebElement cssClass2 = driver.findElement(By.cssSelector("[class='topSecret']")); //szukaj w innych np w class

        By all = By.cssSelector("*");
        driver.findElement(all);

        By ulInDiv = By.cssSelector("div ul"); //wszystkie ul w div
        By trInDiv = By.cssSelector("table tr"); //wszystkie tr w table
        By trInBody = By.cssSelector("tbody tr"); //wszystkie tr w tbody
        driver.findElement(ulInDiv);
        driver.findElement(trInDiv);
        driver.findElement(trInBody);

        By firsChildUlInDiv = By.cssSelector("div > ul"); //Pierwsze dziecko
        By firsChildTrInDiv = By.cssSelector("tbody > tr"); //Pierwsze dziecko
        driver.findElement(firsChildUlInDiv);
        driver.findElement(firsChildTrInDiv);

        By firsFormAfterLabel = By.cssSelector("label + form"); //Pierwszy pod listą
        By allFormAfterLabel = By.cssSelector("label ~ form"); //Wszystkie pod lsitą
        driver.findElement(firsFormAfterLabel);
        driver.findElement(allFormAfterLabel);

        By attrTab = By.cssSelector("input[name='fname']"); //selector zawęża do konkretneg tagu
        By attrContains = By.cssSelector("[name*='name']"); //selector zawęża do zawierajacego podane znaki
        By attrStarts = By.cssSelector("[name^='f']"); //zaczyna się od
        By attrEnds = By.cssSelector("[name$='name']"); //kończy się na
        driver.findElement(attrTab);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        By firstChildLi = By.cssSelector("li:first-child"); //pierwsze dziecko li
        By lasttChildLi = By.cssSelector("li:last-child"); //ostatnie dziecko li
        By secoundChildLi = By.cssSelector("li:nth-child(2)"); //zdrugie/ente/konkretne dziecko Li
        driver.findElement(firstChildLi);
        driver.findElement(lasttChildLi);
        driver.findElement(secoundChildLi);

        Thread.sleep(3000);
        driver.quit();
    }
}
