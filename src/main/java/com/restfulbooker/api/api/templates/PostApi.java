package com.restfulbooker.api.api.templates;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public final class PostApi {

    public PostApi(Object payload, String endpoint, int statusCode) {
    }

    public static Response sendPost(Object payload, String endpoint, int statusCode) {
        return given().
                   contentType(ContentType.JSON).
                   body(payload).
                when().
                   post(endpoint).
                then().
                   statusCode(statusCode).
                   extract().
                   response();
    }


}