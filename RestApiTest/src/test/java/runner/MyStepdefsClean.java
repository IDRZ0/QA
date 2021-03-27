package runner;

import configuration.Config;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import jsonCompare.JsonCompare;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefsClean {
    Response response;
    RequestInformation request = new RequestInformation();
    Map<String, String> data = new HashMap<>();

    @Given("i have access to Todo.ly")
    public void iHaveAccessToTodoLy() {
    }

    @When("i send {} request to url {} with json")
    public void iSendPOSTRequestToUrlHttpTodoLyApiProjectsJsonWithJson(String requestMethod, String url, String body) {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue(Config.AUTH_BASIC_VALUE);
        request.setUrl(replaceAllData(url));
        request.setBody(replaceAllData(body));
        response = FactoryRequest.make(requestMethod).send(request);
    }

    @Then("i expect status code {int}")
    public void iExpectStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    @And("i expect response body")
    public void iExpectResponseBody(String expectedBody) {
        Assert.assertTrue("Mal", JsonCompare.areEqualJson(replaceAllData(expectedBody), response.getBody().asString()));
    }

    @And("i get property {} and save it in {}")
    public void iGetPropertyIdAndSaveItInID_PROJECT(String property, String varName) {
        data.put(varName, response.then().extract().path(property) + "");
    }

    private String replaceAllData(String value) {
        for (String key : data.keySet()) {
            value = value.replace(key, data.get(key));
        }
        return value;
    }
}
