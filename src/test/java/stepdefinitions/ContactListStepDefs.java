package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactListAddContactPage;
import pages.ContactListAddUserPage;
import pages.ContactListHomePage;
import pages.ContactListPage;

import java.util.List;

public class ContactListStepDefs {
    ContactListHomePage contactListHomePage = new ContactListHomePage();
    ContactListAddUserPage contactListAddUserPage = new ContactListAddUserPage();
    ContactListPage contactListPage = new ContactListPage();
    ContactListAddContactPage contactListAddContactPage = new ContactListAddContactPage();


    @When("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        contactListHomePage.signUpButton.click();
    }

    @When("user enters firstname {string}")
    public void user_enters_firstname(String firstName) {
        contactListAddUserPage.firstName.sendKeys(firstName);
    }

    @When("user enters lastname {string}")
    public void user_enters_lastname(String lastname) {
        contactListAddUserPage.lastName.sendKeys(lastname);
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        contactListAddUserPage.email.sendKeys(Faker.instance().number().numberBetween(1000, 9999) + email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        contactListAddUserPage.password.sendKeys(password);
    }

    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        contactListAddUserPage.submit.click();
    }

    @Given("click on add a new contact button")
    public void click_on_add_a_new_contact_button() throws InterruptedException {
        Thread.sleep(2000);
        contactListPage.addANewContactButton.click();
    }

    @When("user enters firstName {string}")
    public void user_enters_first_name(String firstName){

        contactListAddContactPage.firstName.sendKeys(firstName);
    }

    @When("user enters lastName {string}")
    public void user_enters_last_name(String lastName) {
        contactListAddContactPage.lastName.sendKeys(lastName);
    }

    @When("user enters birthdate {string}")
    public void user_enters_birthdate(String birthdate) {
        contactListAddContactPage.birthdate.sendKeys(birthdate);
    }

    @When("user enters email input {string}")
    public void user_enters_email_input(String email) {
        contactListAddContactPage.email.sendKeys(email);
    }

    @When("user enters phone {string}")
    public void user_enters_phone(String phone) {
        contactListAddContactPage.phone.sendKeys(phone);
    }

    @When("user enters street1 {string}")
    public void user_enters_street1(String street1) {
        contactListAddContactPage.street1.sendKeys(street1);
    }

    @When("user enters street2 {string}")
    public void user_enters_street2(String street2) {
        contactListAddContactPage.street2.sendKeys(street2);
    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
        contactListAddContactPage.city.sendKeys(city);
    }

    @When("user enters stateProvince {string}")
    public void user_enters_state_province(String stateProvince) {
        contactListAddContactPage.stateProvince.sendKeys(stateProvince);
    }

    @When("user enters postalCode {string}")
    public void user_enters_postal_code(String postalCode) {
        contactListAddContactPage.postalCode.sendKeys(postalCode);
    }

    @When("user enters country {string}")
    public void user_enters_country(String country) {
        contactListAddContactPage.country.sendKeys(country);
    }

    @Then("user clicks submit button")
    public void user_clicks_submit_button() {
        contactListAddContactPage.submit.click();
    }

    @Given("click on add a new contact button and fill form and click submit")
    public void click_on_add_a_new_contact_button_and_fill_form_and_click_submit(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> firstnames = dataTable.column(0);
        List<String> lastnames = dataTable.column(1);
        List<String> birthdates = dataTable.column(2);
        List<String> emails = dataTable.column(3);
        List<String> phones = dataTable.column(4);
        List<String> street1s = dataTable.column(5);
        List<String> street2s = dataTable.column(6);
        List<String> cities = dataTable.column(7);
        List<String> stateProvinces = dataTable.column(8);
        List<String> postcodes = dataTable.column(9);
        List<String> countries = dataTable.column(10);

        for (int i= 0; i<firstnames.size(); i++) {
            contactListPage = new ContactListPage();
            contactListAddContactPage= new ContactListAddContactPage();
            Thread.sleep(3000);
            contactListPage.addANewContactButton.click();
            contactListAddContactPage.firstName.sendKeys(firstnames.get(i));
            contactListAddContactPage.lastName.sendKeys(lastnames.get(i));
            contactListAddContactPage.birthdate.sendKeys(birthdates.get(i));
            contactListAddContactPage.email.sendKeys(emails.get(i));
            contactListAddContactPage.phone.sendKeys(phones.get(i));
            contactListAddContactPage.street1.sendKeys(street1s.get(i));
            contactListAddContactPage.street2.sendKeys(street2s.get(i));
            contactListAddContactPage.city.sendKeys(cities.get(i));
            contactListAddContactPage.stateProvince.sendKeys(stateProvinces.get(i));
            contactListAddContactPage.postalCode.sendKeys(postcodes.get(i));
            contactListAddContactPage.country.sendKeys(countries.get(i));
            contactListAddContactPage.submit.click();
        }

    }
}