import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class HarryTest  {

    private static final String URL_BY_SEARCH  = "http://www.omdbapi.com/?s=harry+potter&apikey=6ebcef17";
    private static final String URL_BY_TITLE  = "http://www.omdbapi.com/?i=tt0295297&apikey=6ebcef17";


    @Test
    public void getMovieBySearch(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL_BY_SEARCH)
                .then()
                .statusCode(200)
                .assertThat().body("Search[1].Title", equalTo("Harry Potter and the Sorcerer's Stone"));
    }

    @Test
    public void getMovieByTitle(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL_BY_TITLE)
                .then()
                .statusCode(200)
                .assertThat().body("Response", equalTo("True"));
    }

}