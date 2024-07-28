package pages;


public class PaginaFundamentosDelTesting extends BasePage {

    // TODO: corregir identificador del link introduccion al testing para no ir depender de divs con indice div[X]
    private String introduccionTestingLink = "//*[@id=\"page_section_61972395\"]/div/section/div/div/div/div/div[3]/section/div[2]/div/header/a";


    public PaginaFundamentosDelTesting() {
        super(driver);
    }

    public void introduccionTestingLink() {
        clickElement(introduccionTestingLink);
    }
}
