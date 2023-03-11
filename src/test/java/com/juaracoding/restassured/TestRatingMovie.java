package com.juaracoding.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRatingMovie {
    String apiKeyRating = "https://api.themoviedb.org/3/movie/436270/rating?api_key=242f90a5bd996b8212edfe015c299be2";
    String authKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNDJmOTBhNWJkOTk2YjgyMTJlZGZlMDE1YzI5OWJlMiIsInN1YiI6IjY0MDdmYTg3NTNmODMzMDBiODE1MmY2ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IYlJS3Lso4aotifmpqluvbv2CFSCoB0xwxny5oAi61Q";

    @Test
    public void testPost(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("value","9.5");
        System.out.println(requestBody.toJSONString());

        //verify
        given().header("Content-Type","aplication/json")

                .header("Authorization", authKey)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toJSONString())
                .when()
                .post(apiKeyRating)
                .then()
                .statusCode(201)
                .log().all();
        System.out.println("Data berhasil ditambahkan");
    }

}
