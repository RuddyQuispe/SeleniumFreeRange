package pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeRangeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initiacializa el webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navegamosAFreeRangeTesters() {
        driver.get("https://www.freerangetesters.com/");
        // encontrando un elemento en base a su ID
        WebElement elementId = driver.findElement(By.id("idDelElemento"));
        elementId.click();
    }

    @AfterMethod
    public void tearDown() {
        // cerrar el navegador despues de la prueba
        if (driver != null)
            driver.quit();
    }

    // public static void main(String[] args) {
    // WebDriver driver = new ChromeDriver();
    //
    // driver.get("https://selenium.dev");
    //
    // driver.quit();
    // }
}
