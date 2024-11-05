package com.yanyan.helloworldapp.myhelloworldapp.integrationTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BasicRestAssuredIT {

    private static OpenAPI openAPI;
    private static final String expectedBody = "Hello World! checkout my wagger-ui at <a href=\"http://localhost:8080/swagger-ui.html\">http://localhost:8080/swagger-ui.html</a>";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Adjust to your running app
        SwaggerParseResult result = new OpenAPIV3Parser().readLocation("/Users/yanalbright/Downloads/EmptyProject/target/generated/openapi.yaml", null, null);
        openAPI = result.getOpenAPI();
    }

    @Test
    public void testHelloWorldEndpoint() {
        Response response = given()
                .when().get("/hello")  // Example endpoint
                .then().statusCode(200).extract().response();

        assertNotNull(response);
        assertEquals(expectedBody, response.getBody().asString());  // Validate response content
    }
//
//    @Test
//    public void testSimpleGet() {
//        RestAssured.baseURI = "http://localhost:8080";  // Adjust as necessary
//        String responseBody = given()
//                .when().get("/hello")
//                .then().log().all()  // Log the response
//                .extract().asString();  // Extract the response body as a String
//
//        System.out.println("Response Body: " + responseBody);  // Print the response body
//        int statusCode = given()
//                .when().get("/hello")
//                .then().extract().statusCode();
//
//        assertEquals(200, statusCode);
//    }
}