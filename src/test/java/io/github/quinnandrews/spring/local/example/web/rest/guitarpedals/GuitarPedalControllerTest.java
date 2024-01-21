package io.github.quinnandrews.spring.local.example.web.rest.guitarpedals;

import io.github.quinnandrews.spring.local.postgresql.config.EnableLocalPostgreSQL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@EnableLocalPostgreSQL
@DirtiesContext
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GuitarPedalControllerTest {

    @LocalServerPort
    private Integer port;

    @BeforeAll
    static void beforeClass() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void   getAllGuitarPedals()  {
       given().port(port)
               .when().get("/guitar-pedals").prettyPeek()
               .then().statusCode(HttpStatus.OK.value())
               .and().contentType(ContentType.JSON)
               .and().body("size()", equalTo(4))
               .and().body("guitarPedalName", hasItems(
                       "Big Muff Fuzz",
                       "Deco: Tape Saturation and Double Tracker",
                       "Soft Focus Reverb",
                       "Sneak Attack: Attack/Decay and Tremolo"))
               .and().body("dateSold", hasItems(null, null, null, "2023-03-21"));
    }
}
