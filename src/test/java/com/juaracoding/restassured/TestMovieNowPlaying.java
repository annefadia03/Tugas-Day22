package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestMovieNowPlaying {
    String endpoint = "https://api.themoviedb.org/3/movie/now_playing?api_key=242f90a5bd996b8212edfe015c299be2&language=en-US&page=2";
    @Test
    public void testGetListRespon() {
        Response response = RestAssured.get(endpoint);

        //cek respon
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));

        //validasi
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Status code : Sukses ");
    }

    @Test
    public void testApiKey() {
        given()
                .queryParam("api_key", "242f90a5bd996b8212edfe015c299be2")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void testMovieName(){
        given().get(endpoint)
                .then()
                .statusCode(200)
                .body("results.title[0]",equalTo("Devotion"));

    }
    @Test
    public void testPopularityMovie(){
        given().get(endpoint)
                .then()
                .statusCode(200)
                .body("results.popularity[0]",equalTo(404.353F));
    }

    @Test
    public void testIdOne() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[0]", equalTo(653851));
    }

    @Test
    public void testIdTwo() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[1]", equalTo(599019));
    }

}
