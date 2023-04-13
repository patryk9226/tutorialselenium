import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class BasicPageTest {
    @Test
    public void performAction() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        //pobranie i wypisanie tytułu i adresu url
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //podświetlenie tytułu
        Actions actions = new Actions(driver);
        WebElement yellowTitle = driver.findElement(By.tagName("h1"));
        actions.moveToElement(yellowTitle).perform();

        //kliknięcie w przycisk i zaakceptowanie powiadmienia
        driver.findElement(By.id("clickOnMe")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Wpisanie w pole tekstu
        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Pata");

        //Kliknięcie w link i pobranie tytułi i powrót do strony początkowej
        WebElement link1 = driver.findElement(By.cssSelector("[href='https://www.w3schools.com']"));
        link1.click();
        driver.switchTo().activeElement();
        System.out.println(driver.getTitle());
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //Wyciągnięcie z tabeki wartości
        System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getAttribute("textContent"));

        //Sprawdzenie awartości selcta
        WebElement selectCars = driver.findElement(By.cssSelector("select"));
        Select select = new Select(selectCars);
        List<WebElement> options =  select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        //zaznaczenie checkboxa
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        checkbox.click();

        //zaznacznie radio buttona
        WebElement radioButto = driver.findElement(By.cssSelector("[value='female']"));
        radioButto.click();

        //Wpisanie nazwy użykownika i zatwierdzenie Enterem nastepnie zaakceptowanie dwóch okienek
        WebElement inputName = driver.findElement(By.name("username"));
        inputName.sendKeys("Patryk");
        inputName.sendKeys(Keys.ENTER);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.quit();
        }
    }