package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.PaginaCursos;
import pages.PaginaFundamentosDelTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

import java.util.Arrays;
import java.util.List;

/**
 * Steps
 */
public class FreeRangeSteps {

    /**
     * Soft Assertions: No detienen la ejecucin al fallar. Ideal para verificar muchas cosas pequeas a la vez.
     */
    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosDelTesting fundamentosPage = new PaginaFundamentosDelTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void INavigateToFeature() {
        landingPage.navigateToFreeRangeTesters();
    }

    @Then("I Go to a {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("select Introduction al testing")
    public void selectTestingToIntroduction() {
        cursosPage.clickFundamentosAlTestingLink();
        fundamentosPage.introduccionTestingLink();
    }

    @When("I select elegir un plan")
    public void clickElegirPlan() {
        landingPage.clickOnElegirPlan();
    }

    /**
     * TestNG proporciona una serie de mtodos de asercin a travs de la clase Assert para verificar que las condiciones de las pruebas sean cumplidas. Estas aserciones son esenciales para validar el comportamiento esperado de la aplicacin bajo prueba. A continuacin, te detallo algunas de las aserciones ms comunes y te proporciono ejemplos utilizando Selenium y Java:
     * 1. assertEquals [Verifica que dos valores sean iguales.]
     * Assert.assertEquals(actualTitle, expectedTitle, "El ttulo de la pgina no es el esperado.");
     * <p>
     * 2. assertNotEquals [Verifica que dos valores no sean iguales.]
     * Assert.assertNotEquals(actualTitle, incorrectTitle, "El ttulo de la pgina no debera ser este.");
     * <p>
     * 3. assertTrue [Verifica que una condicin sea verdadera.]
     * Assert.assertTrue(isElementPresent, "El elemento debera estar presente.");
     * <p>
     * 4. assertFalse [Verifica que una condicin sea falsa.]
     * Assert.assertFalse(isElementPresent, "El elemento no debera estar presente.");
     */
    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropDownValues();
        // evitar usar chars especiales como • ñ
        List<String> listaEsperada = Arrays.asList(new String("Academia: $16.99 / mes • 13 productos"), new String("Academia: $176 / año • 13 productos"), new String("Free: Gratis • 3 productos"));
        Assert.assertEquals(lista, listaEsperada);

        soft.assertEquals(lista, listaEsperada);
        soft.assertTrue(listaEsperada.get(0).equals(lista.get(0)));
        soft.assertFalse(!listaEsperada.get(0).equals(lista.get(0)));
        // Y as se ven (exactamente como las assertions comunes, pero con el potente assertAll(); al final!
        soft.assertAll();
    }
}
