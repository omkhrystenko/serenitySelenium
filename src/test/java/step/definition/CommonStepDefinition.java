package step.definition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import step.steps.UserSteps;

public class CommonStepDefinition {//Class that describes .story files



    @Steps
    private UserSteps userSteps;

    @Given("I open Landing page")
    public void openLandingPage(){
        userSteps.openLandingPage()
                .verifyLandingPageControllElementAppear();

    }

    @When("I click on '$buttonText' button")
    //@Pending //Сделали заготовку но не сделали реализацию степ не запустится
    public void givenIClickOnButton(String bottonText){
        userSteps.clickOnButton(bottonText);

    }

    @Then("I should be on Login page")
    public void verifyLoginPageIsLoaded(){
        userSteps.verifyLoginPageUrlLoaded()
                 .verifyLoginPageControllElementAppear();
    }

    @When("I sign In as '$userEmail' , '$userPassword'")
    public void submitAuthenticationData(String login, String password){
        userSteps.submitAuthenticationData(login, password);
    }

    @Then("Home page is loaded")
    public void verifyHomePageIsLoaded(){

        userSteps.verifyHomePageUrlLoaded()
                .verifyHomePageControlElementAppear();
    }

    @Then("I should receive a password error message '$message'")
    public void verifyPasswordErrorMessage(String errorMessageText){
        userSteps.verifyLoginPasswordErrorMessage(errorMessageText);
    }

    @Then("I should be on Error page")
    public void verifyErrorPageIsLoaded(){
        userSteps.verifyErrorPageUrlLoaded();
    }



}
