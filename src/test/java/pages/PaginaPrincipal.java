package pages;

/**
 * Page Object Class
 */
public class PaginaPrincipal extends BasePage {

    private String elegirPlanButton = "//a[normalize-space()='Elegir Plan']";

    public PaginaPrincipal() {
        super(driver);
    }

    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickOnSectionNavigationBar(String sectionLink) {
        String xPathSection = String.format("//a[normalize-space()='%s' and @href]", sectionLink);
        clickElement(xPathSection);
    }

    public void clickOnElegirPlan() {
        clickElement(elegirPlanButton);
    }
}
