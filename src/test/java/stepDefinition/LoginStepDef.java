package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class LoginStepDef {
    LoginPage lop = new LoginPage();
    @Given("you access the webapp login page")
    public void youAccessTheWebappLoginPage() {
        lop.navigateToLoginPage();
    }

    @When("you enter the username")
    public void youEnterTheUsername() {
        lop.setUsername();
    }

    @And("you enter the password")
    public void youEnterThePassword() {
        lop.setPassword();
    }

    @And("you click on login button")
    public void youClickOnLoginButton() {
        lop.clickOnLoginButton();
    }

    @Then("you see home page for successful login with logout option displayed")
    public void youSeeHomePageForSuccessfulLoginWithLogoutOptionDisplayed() {
        lop.validateHomePage();
    }

    @And("you enter the invalid password")
    public void youEnterTheInvalidPassword() {
        lop.setInvalidPassword();
    }
}
