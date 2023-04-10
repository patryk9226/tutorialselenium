import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findEleements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement clickOnMe = driver.findElement(By.xpath("//button[@id='clickOnMe']"));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='fname']"));

        WebElement paraHiden = driver.findElement(By.xpath("//p[@class='topSecret']"));

        WebElement input = driver.findElement(By.xpath("//input"));
        input.sendKeys("Dzień dobry");

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        System.out.println(inputs.size());

        driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

        driver.findElement(By.xpath("//a[contains(text(),'Link')]"));

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By allXpath = By.xpath("//*"); //wywołuje wszystko elementy
        driver.findElement(allXpath);

        By secoundElement = By.xpath("(//input)[2]"); //wywołuje drugi record lub enty na stronie
        driver.findElement(secoundElement);

        By lastElement = By.xpath("(//input)[last()]"); //wywołuje ostatni record na stronie
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]"); //wywołuje dowoly element z podany atrybutem na stronie
        driver.findElement(elementWithAttribute);

        By attrWq = By.xpath("//button[@id='clickOnMe']"); //wywołuje element o podanym konkretnym atrybucie
        By attrNotEq = By.xpath("//button[@id!='clickOnMe']"); //wywołuje element bez podanego konkretnego atrybutu
        By attrCont = By.xpath("//*[contains(@name,'ame')]"); //wywołuje element z podaną zawartoscią ciągów znaków
        By startsWith = By.xpath("//*[starts-with(@name,'fnam')]"); //wywołuje element z podanym poczatkiem
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']"); //wywołuje element z podanym końcem (kombinowany, w nowszych wersjach działa jak starts-with)

        driver.findElement(attrWq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
        driver.findElement(endsWith);

        By child = By.xpath("//div/child::ul"); //wywołuje dzieci elementu
        By desc = By.xpath("//div/descendant::ul"); //wywołuje zstępnych element (każdy kolejny potomek)
        By parent = By.xpath("//div/../.."); //wywołuje element nad podanym
        By asc = By.xpath("//div/ancestor::*"); //wywołuje wstępnych element (elementy z których się wywodzą)
        By foll = By.xpath("//img/following::*"); //wywołuje element występujące po naszym elemenci
        By follSibl = By.xpath("//img/following-sibling::*"); //wywołuje element występujące po naszym elemenci ale na tym samym poziomie
        By pred = By.xpath("//img/preceding::*"); //wywołuje element przed naszym tagiem
        By precSibl = By.xpath("//img/preceding-sibling::*"); //wywołuje element przed naszym tagiem ale na tym samym poziomie

        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSibl);
        driver.findElement(pred);
        driver.findElement(precSibl);

        By divsAndLinks = By.xpath("//a | //input"); //wywołuje sume podanych dwóch warunków
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");  //wywołuje wsólne dla warunków elementy (i)
        By OrOp= By.xpath("//input[@name='fname' or @id='fname']"); //wywołuje element na postawie pierwszego bądź drugiego atrybutu (lub)


        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(OrOp);

        Thread.sleep(3000);
        driver.quit();
    }
}
