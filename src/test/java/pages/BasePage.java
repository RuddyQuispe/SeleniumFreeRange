package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaracin de una variable estatica 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaracin de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estatico
     * WebDriverWait se usa para poner esperas explcitas en los elementos web
     */
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();
        // Inicializa la variable esttica 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /**
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     *
     * @param driver driver para el manejo de la web
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    /**
     * Metodo estatico para navegar a una URL.
     *
     * @param url ruta de la pagina
     */
    protected static void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Devolveme esperando hasta que la condicion el elemento esta presente el locator
     *
     * @param locator identificador XPath del componente[LOCATOR]
     * @return elemento web para poder accionar
     */
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * hacer click al elemento[LOCATOR]
     *
     * @param locator identificador XPath del componente[LOCATOR]
     */
    protected void clickElement(String locator) {
        this.find(locator).click();
    }

    /**
     * Cierra el navegador y cierra el driver en uso
     */
    public static void closeBrowser() {
        driver.quit();
    }

    protected void writeInputElementByValue(String locator, String keysToSend) {
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    protected void selectFromDropDownByInde(String locator, Integer value) {
        Select dropDown = new Select(find(locator));
        dropDown.selectByIndex(value);
    }

    protected Integer dropDownSize(String locator) {
        Select dropDown = new Select(find(locator));
        List<WebElement> dropDownOptions = dropDown.getOptions();
        return dropDownOptions.size();
    }

    protected List<String> getDropDownValues(String locator) {
        Select dropDown = new Select(this.find(locator));
        return dropDown.getOptions().stream().map(WebElement::getText).toList();
    }
}
