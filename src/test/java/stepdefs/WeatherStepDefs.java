package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherStepDefs {
    private String text;
    private String text2;



    @Given("city name is {string}")
    public void city_Name(String text) { this.text = text; }

    @And("country name is {string}")
    public void country_Name(String text2) { this.text2 = text2; }

    @When("we are requesting weather data")
    public void weather_Data() {
        System.out.println("Weather data in " + text + " " + text2 + " are:");
    }


    @Then("coordinates are:")
    public void coordinatesAre() {
    }

    @And("weather is edited with following fields:")
    public void weatherIsEditedWithFollowingFields() {
    }

    @And("main info is:")
    public void main_Info(float temp) {
        System.out.println("Temp is " + temp + "F");
    }

    @And("base is {string}")
    public void baseIs(String arg0) {
    }

    @And("visibility is {int}")
    public void visibilityIs(int arg0) {
    }


    @And("wind conditions is:")
    public void windConditionsIs() {
    }

    @And("clouds condition is {int}")
    public void cloudsConditionIs(int arg0) {

    }

    @And("dt is {int}")
    public void dtIs(int arg0) {

    }

    @And("sys data are:")
    public void sysDataAre() {

    }

    @And("id is {int}")
    public void idIs(int arg0) {

    }

    @And("cod is {int}")
    public void codIs(int arg0) {
    }
}
