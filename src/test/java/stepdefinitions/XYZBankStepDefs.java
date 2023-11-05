package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.XYZBankCustomerPage;
import pages.XYZBankHomePage;
import pages.XYZBankManagerPage;
import utilities.Driver;

import java.util.List;

public class XYZBankStepDefs {
    XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
    XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
    XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();

    @Given("Go to url {string}")
    public void goToUrl(String url) {
        Driver.getDriver().get(url);
    }

    @When("Click on Bank Manager Login button")
    public void click_on_bank_manager_login_button() throws InterruptedException {
        Thread.sleep(3000);
        xyzBankHomePage.bankManagerLoginButton.click();
    }

    @When("Click on Add Customer button")
    public void click_on_add_customer_button() {
        xyzBankManagerPage.addCustomerButton.click();
    }

    @When("Fill inputs and click on Add Customer form Accept alert")
    public void fill_inputs_and_click_on_add_customer_form_accept_alert(io.cucumber.datatable.DataTable dataTable) {
        List<String> firstnames = dataTable.column(0);
        List<String> lastnames = dataTable.column(1);
        List<String> postcodes = dataTable.column(2);
        for (int i = 0; i < firstnames.size(); i++) {
            xyzBankManagerPage.firstNameInput.sendKeys(firstnames.get(i));
            xyzBankManagerPage.lastNameInput.sendKeys(lastnames.get(i));
            xyzBankManagerPage.postCodeInput.sendKeys(postcodes.get(i));
            xyzBankManagerPage.addCustomerSubmitButton.click();
            Driver.getDriver().switchTo().alert().accept();
        }
    }

    @When("Click on Open Account  button")
    public void click_on_open_account_button() throws InterruptedException {
        Thread.sleep(2000);
        xyzBankManagerPage.openAccountButton.click();
    }

    @When("Click on Customer dropdown")
    public void click_on_customer_dropdown() {
        xyzBankManagerPage.customerDropDown.click();
    }

    @When("Select customer name")
    public void select_customer_name() {
            Select customer = new Select(xyzBankManagerPage.customerDropDown);
            customer.selectByIndex(6);
    }

    @When("Click on Currency dropdown")
    public void click_on_currency_dropdown() {
        xyzBankManagerPage.currencyDropDown.click();
    }

    @When("Select Dollar")
    public void select_dollar() {
        Select currency = new Select(xyzBankManagerPage.currencyDropDown);
        currency.selectByValue("Dollar");
    }

    @When("Click on Process button")
    public void click_on_process_button() {
        xyzBankManagerPage.processButton.click();
    }

    @When("Accept alert")
    public void accept_alert() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @When("Open four more accounts")
    public void open_four_more_accounts() {
        for (int i = 5; i < 10; i++) {
            xyzBankManagerPage.openAccountButton.click();
            Select customerName = new Select(xyzBankManagerPage.customerDropDown);
            customerName.selectByIndex(i);
            Select currency = new Select(xyzBankManagerPage.currencyDropDown);
            currency.selectByValue("Dollar");
            xyzBankManagerPage.processButton.click();
            Driver.getDriver().switchTo().alert().accept();
        }

    }

    @When("Click on Customers button")
    public void click_on_customers_button() {
        xyzBankManagerPage.customersButton.click();
    }

    @When("Get last five customers' account numbers")
    public void get_last_five_customers_account_numbers() {

    }

    @Then("Assert that you created five accounts")
    public void assert_that_you_created_five_accounts() {

    }

    @When("Click on Home button")
    public void click_on_home_button() {
        xyzBankHomePage.homeButton.click();
    }

    @When("Click on Customer Login button")
    public void click_on_customer_login_button() {
        xyzBankHomePage.customerLoginButton.click();
    }

    @When("Click on Your Name dropdown")
    public void click_on_your_name_dropdown() {
        xyzBankCustomerPage.yourNameDropDown.click();
    }

    @When("Select the any name you created")
    public void select_the_any_name_you_created() {
        Select name = new Select(xyzBankCustomerPage.yourNameDropDown);
        name.selectByIndex(5);
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        xyzBankCustomerPage.loginButton.click();
    }

    @When("Click on Deposit button")
    public void click_on_deposit_button() {
        xyzBankCustomerPage.depositButton.click();
    }

    @When("Type hundred into Amount to be Deposited input")
    public void type_into_amount_to_be_deposited_input() {
        xyzBankCustomerPage.depositAmountInput.sendKeys("100");
    }

    @When("Click on Deposit\\(Submit) button")
    public void click_on_deposit_submit_button() {
        xyzBankCustomerPage.depositSubmitButton.click();
    }

    @Then("Assert that Deposit Successful is displayed")
    public void assert_that_deposit_successful_is_displayed() {
        Assert.assertTrue(xyzBankCustomerPage.depositSuccessMessage.isDisplayed());
    }

    @Then("Click on Withdrawal button")
    public void click_on_withdrawal_button() {
        xyzBankCustomerPage.withdrawlButton.click();
    }

    @Then("Type hundred into Amount to be Withdrawn input")
    public void type_into_amount_to_be_withdrawn_input() throws InterruptedException {
        Thread.sleep(3000);
        xyzBankCustomerPage.withdrawlAmountInput.sendKeys("100");
    }

    @Then("Click on Withdraw\\(Submit) button")
    public void click_on_withdraw_submit_button() {
        xyzBankCustomerPage.withdrawSubmitButton.click();
    }

    @Then("Assert that Transaction  Successful is displayed")
    public void assert_that_transaction_successful_is_displayed() {
        Assert.assertTrue(xyzBankCustomerPage.withdrawlSuccessMessage.isDisplayed());
    }

    @When("Click on Logout button")
    public void click_on_logout_button() {
        xyzBankCustomerPage.logoutButton.click();
    }

    @When("Click on each Delete button")
    public void click_on_each_delete_button() {
        xyzBankManagerPage.customersButton.click();
        for (int i = 9; i >= 0; i--) {
            xyzBankManagerPage.deleteButtonList.click();
        }
    }
    @When("Count table row numbers")
    public void count_table_row_numbers() {
        List<WebElement> countRowNumber = xyzBankManagerPage.accountNumberList;
        countRowNumber.forEach(t->System.out.println(t.getSize()));
    }

//    @Then("Assert that number of customers is zero")
//    public void assert_that_number_of_customers_is_zero() {
//
//    }


}
