package steps;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosDelTesting;
import pages.PaginaPrincipal;

/**
 * Steps
 */
public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosDelTesting fundamentosPage = new PaginaFundamentosDelTesting();

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

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {

    }
}
