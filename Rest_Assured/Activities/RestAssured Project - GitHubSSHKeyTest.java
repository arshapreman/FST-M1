package project;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubSSHKeyTest {

    RequestSpecification requestSpec;

    String sshKey;
    int keyId;
    String token = "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";
    
    String baseURI = "https://api.github.com";

    @BeforeClass
    public void setup() {
    	
    	requestSpec = new RequestSpecBuilder()
                    .setBaseUri("https://api.github.com")       
                    .setContentType(ContentType.JSON)           
                    .addHeader("Authorization", "token " + token) 
                    .build();
	RestAssured
    .given()
    .spec(requestSpec)
    .when()
    .get("/user")
    .then()
    .statusCode(200);
	
        }

    @Test
    public void PostRequest()
   
    {
    	String reqBody = "{\n" +
                  "  \"title\": \"TestKey\",\n" +
                  "  \"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJQKfyZe/bXq7Kb1vRh0E2p06AvWkpseDFtqGnakcPxr\"\n" +
                  "}";
    	
          Response postResponse =
                  given()
                          .baseUri(baseURI)
                          .header("Authorization", "token " + token)
                          .contentType(ContentType.JSON)
                          .body(reqBody)
                  .when()
                          .post("/user/keys");
    
          Assert.assertEquals(postResponse.getStatusCode(), 201, "POST failed");
          keyId = postResponse.jsonPath().getInt("id");
          Reporter.log("Captured keyId: " + keyId, true);

          postResponse.then().log().all();

          int keyId = postResponse.jsonPath().getInt("id");

          System.out.println("Created Key ID: " + keyId);

    }
 
    @Test( priority =2, dependsOnMethods = "PostRequest")
    public void GetRequest()
    {
    	Response getResponse =
                given()
                        .baseUri(baseURI)
                        .header("Authorization", "token " + token)
                .when()
                        .get("/user/keys/" + keyId);

        getResponse.then().log().all();
    }
    
    @Test(priority =3, dependsOnMethods = "PostRequest")
    public void deleteRequest()
    {
    	
        Response deleteResponse = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("keyId", keyId) 
                .when()
                .delete("/user/keys/{keyId}");

    
        Reporter.log("DELETE status: " + deleteResponse.getStatusCode(), true);
        Reporter.log(deleteResponse.asPrettyString(), true);
  
        Assert.assertEquals(deleteResponse.getStatusCode(), 204, "DELETE SSH Key failed");
    }
}
