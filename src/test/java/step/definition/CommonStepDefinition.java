package step.definition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;
import step.UserSteps;

public class CommonStepDefinition {

    @Steps
    private UserSteps userSteps;

    @Given("I open Landing page")
    public void openLandingPage(){
        userSteps.openLandingPage();
    }


}
