package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

import static utilities.WaitUtils.waitFor;

public class BlueRentalStepDefs {
    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
//    @When("user enters the admin email and password")
//    public void user_enters_the_admin_email_and_password(io.cucumber.datatable.DataTable dataTable) {
//        List<String> credentials = dataTable.row(1);//index starts at 0
////        credentials = {jack1@gmail.com,12345 }
//        blueRentalLoginPage.email.sendKeys(credentials.get(0));
//        blueRentalLoginPage.password.sendKeys(credentials.get(1));
//
//    }

    @Then("user click on the login page")
    public void user_click_on_the_login_page() {
       blueRentalHomePage.loginOnHomepage.click();
    }
    @Then("user enter email address {string}")
    public void user_enter_email_address(String email) {
        blueRentalLoginPage.email.sendKeys(email);
    }
    @Then("user enter password {string}")
    public void user_enter_password(String password) {
        blueRentalLoginPage.password.sendKeys(password);
    }
    @Then("click on the login button")
    public void click_on_the_login_button() {
        blueRentalLoginPage.loginOnLoginPage.click();
    }
    @Then("verify the login is successful")
    public void verify_login_is_successful() {
        waitFor(2);
        Assert.assertTrue(blueRentalLoginPage.profileName.isDisplayed());
    }
}