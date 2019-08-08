package step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.HomePage;
import page.LandingPage;
import page.LoginPage;

import static org.junit.Assert.assertTrue;

public class UserSteps extends ScenarioSteps {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;



    @Step
    public UserSteps openLandingPage() {
        landingPage.open();
        logger.info("Landing page is opened");
        return this;
    }

    @Step
    public UserSteps verifyLandingPageControllElementAppear(){
        assertTrue(landingPage.waitControllElementsAppear());
        logger.info("Landing page control element is loaded");
        return this;
    }

    @Step
    public UserSteps goToLoginPage(){
        landingPage.clickEnterToLoginPage();
        logger.info("Click on Enter button on Landing page was successful");
        return this;
    }

    @Step
    public UserSteps verifyLoginPageUrlLoaded(){
        assertTrue(loginPage.getCurrentPage());
        logger.info("Login page URL is right");
        return this;
    }

    @Step
    public UserSteps verifyLoginPageControllElementAppear(){
        assertTrue(loginPage.waitControllElementsAppear());
        logger.info("Login page control element is loaded");
        return this;
    }

    @Step
    public UserSteps submitAuthenticationData(String login, String password){
        loginPage.submitAuthentificationData(login, password);
        logger.info("Login page authentication fields successfully submited");
        return this;
    }

    @Step
    public UserSteps verifyHomePageUrlLoaded(){
        assertTrue(homePage.getCurrentPage());
        logger.info("Home page URL is right");
        return this;
    }

    @Step
    public UserSteps verifyHomePageControlElementAppear(){
        assertTrue(homePage.waitControlElementsAppear());
        logger.info("Home page control element is loaded");
        return this;
    }
}
