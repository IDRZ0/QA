package runner;

import configuration.Config;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import factoryRequest.RequestInformationNoAuth;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import jsonCompare.JsonCompare;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyStepdefsParcial1 {
    Response response;
    RequestInformation request = new RequestInformation();
    RequestInformationNoAuth request1 = new RequestInformationNoAuth();
    Map<String, String> data = new HashMap<>();

    @Given("i got access to Todo.ly")
    public void iGotAccessToTodoLy() {
    }

    @When("i POST request to url {} with json")
    public void iPOSTRequestToUrlHttpTodoLyApiUserJsonWithJson(String url, String body) {
        request1.setUrl(replaceAllData(url));
        request1.setBody(replaceAllData(body));
        response = FactoryRequest.make("POST").send1(request1);
    }

    @When("i send then GET request to url {} with user {} and pass {}")
    public void iSendTheGETRequestToUrlHttpTodoLyApiAuthenticationTokenJson(String url, String user, String pass) {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue("Basic " + this.encode(user + ":" + pass));
        request.setUrl(replaceAllData(url));
        response = FactoryRequest.make("GET").send(request);
    }

    @Then("i expect in the status code {}")
    public void iExpectInTheStatusCode(int code) {
        response.then().statusCode(code);
    }

    @And("i expect in the response body")
    public void iExpectInTheResponseBody(String responseBody) {
        Assert.assertTrue("Mal", JsonCompare.areEqualJson(replaceAllData(responseBody), response.getBody().asString()));
    }

    @And("i get an property {} and save it in {}")
    public void iGetAPropertyTokenStringAndSaveItInTokenValue(String property, String varName) {
        data.put(varName, response.then().extract().path(property) + "");
    }

    @When("i POST a request to url {} with json")
    public void iPOSTARequestToUrlHttpTodoLyApiUserJsonWithJson(String url, String body) {
        request.setAuthType(Config.TOKEN);
        request.setAuthValue(replaceAllData("TokenValue"));
        request.setUrl(replaceAllData(url));
        request.setBody(replaceAllData(body));
        response = FactoryRequest.make("POST").send(request);
    }

    private String replaceAllData(String value) {
        for (String key : data.keySet()) {
            value = value.replace(key, data.get(key));
        }
        return value;
    }

    private String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
