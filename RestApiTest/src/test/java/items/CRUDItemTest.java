package items;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CRUDItemTest {
    private Response response;

    @Test
    public void verify_crud_item() {
        JSONObject body = new JSONObject();
        body.put("Content", "IgnacioItem");

        // POST item
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                post("http://todo.ly/api/items.json");

        response.then().
                statusCode(200).
                body("Content", equalTo("IgnacioItem")).
                body("Deleted", equalTo(false)).
                log().
                all();

        // extraer el valor de una propiedad : Id
        int idItem = response.then().extract().path("Id");

        // UPDATE item
        body.put("Content", "IgnacioItem UPDATE");
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                put("http://todo.ly/api/items/" + idItem + ".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("IgnacioItem UPDATE")).
                body("Deleted", equalTo(false)).
                log().
                all();

        // GET item by id
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                get("http://todo.ly/api/items/" + idItem + ".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("IgnacioItem UPDATE")).
                body("Deleted", equalTo(false)).
                log().
                all();

        // DELETE item
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                delete("http://todo.ly/api/items/" + idItem + ".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("IgnacioItem UPDATE")).
                body("Deleted", equalTo(true)).
                log().
                all();
    }
}
