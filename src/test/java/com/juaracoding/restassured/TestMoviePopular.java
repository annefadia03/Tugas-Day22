package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestMoviePopular {
    String endpoint = "https://api.themoviedb.org/3/movie/popular?api_key=242f90a5bd996b8212edfe015c299be2&language=en-US&page=1";

    @Test
    public void testListRespon(){
        Response response = RestAssured.get(endpoint);

        //cek list respon
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));

        //valdiasi
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Status code : Sukses ");
    }

    @Test
    public void testPopularityMovie(){
        given().get(endpoint)
                .then()
                .statusCode(200)
                .body("results.popularity[0]",equalTo(2550.267F));
    }
    @Test
    public void testIdMovieOne() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[1]", equalTo(631842));
    }

    @Test
    public void testIdMovieTwo() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[2]", equalTo(505642));
    }
}
