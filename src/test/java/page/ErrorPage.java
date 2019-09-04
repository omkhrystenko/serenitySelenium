package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@At("https://www.linkedin.com/checkpoint/lg/login-submit")
public class ErrorPage extends PageObject {
    public ErrorPage(WebDriver driver) {
        super(driver);
    }


    @WhenPageOpens
    public boolean getCurrentPage() {
        return getPages().isCurrentPageAt(ErrorPage.class);
    }


}
