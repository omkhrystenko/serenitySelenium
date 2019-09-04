package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;


@At("https://www.linkedin.com/login")
public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id = 'username']")
    public WebElementFacade fieldLogin;

    @FindBy(xpath="//*[@id = 'password']")
    public WebElementFacade fieldPassword;

    @FindBy(xpath="//*[@id='app__container']/main/div/form/div[3]/button")
    public WebElementFacade buttonEnterForAuthentification;

    @FindBy(xpath = "//*[@id = 'error-for-password']")
    public WebElementFacade passwordErrorMessage;

    @WhenPageOpens
    public boolean getCurrentPage() {
        return getPages().isCurrentPageAt(LoginPage.class);

    }


    @WhenPageOpens
    public boolean waitControllElementsAppear() {
        try {
            element(fieldLogin).waitUntilVisible();
            element(fieldPassword).waitUntilVisible();
            element(buttonEnterForAuthentification).waitUntilVisible();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void submitAuthentificationData(String login, String password){
        typeInto(fieldLogin, login);
        typeInto(fieldPassword, password);
        buttonEnterForAuthentification.click();
    }

    public boolean isPasswordErrorMessageContains(String messagePattern) {
        boolean res = false;

        if (messagePattern.contains("password") || messagePattern.contains("пароль")) {
            if (passwordErrorMessage.getText().contains("password") || passwordErrorMessage.getText().contains("пароль")) {
                res = true;
            }
        }
        return res;
    }


}
