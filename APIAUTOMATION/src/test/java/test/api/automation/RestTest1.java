package test.api.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;

import static com.jayway.restassured.RestAssured.*; //static import. 

public class RestTest1 {
	
	@Test
	public void TC001() {
		// TODO Auto-generated method stub

	//This test case will contain most of API testing commands
//	given().queryParam("CUSTOMER_ID","68195")
//    .queryParam("PASSWORD","1234!")
//    .queryParam("Account_No","1")
//    .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
//    .body();
	
	System.out.println("<-----------Initially----------->");
	given()
    .when().get("http://jsonplaceholder.typicode.com/todos/1").then().log()
    .body();
	
	
	System.out.println("<-----------After patching (update with only updated value) Title----------->");
	CreatePost cpost = new CreatePost();
	cpost.setTitle("new title");
	
	given()
	.contentType(ContentType.JSON)
	.body(cpost)  //<-----------passing updated json object
	.when()
	.patch("http://jsonplaceholder.typicode.com/todos/1") //<-------patch method. 
	.then()
	.statusCode(200)
	.log().body();
	
	System.out.println("<-----------After posting new entry with json object----------->");
	cpost.setUserId(600);
	cpost.setId(600);
	cpost.setTitle("Doctor Pranav");
	cpost.setCompleted("True");
	
	given()
	.contentType(ContentType.JSON)
	.body(cpost)  //<-----------passing new json object
	.when()
	.post("http://jsonplaceholder.typicode.com/todos/") //<-------post method for new entry
	.then()
	.statusCode(201)
	.log().body();
	
	System.out.println("<-----------After posting new entry with full json value----------->");
		
	given()
	.contentType(ContentType.JSON)
	.body("{\"userId\": 201,\"id\": 201,\"title\": \"Engineer Pranav\", \"completed\": true}")  //<-----------passing full json value
	.when()
	.post("http://jsonplaceholder.typicode.com/todos/") //<-------post method for new entry
	.then()
	.statusCode(201)
	.log().body();
	
	
	System.out.println("<-----------After putting (update with all input values) entry----------->");
	cpost.setUserId(1);
	cpost.setId(1);
	cpost.setTitle("Doctor Pranav");
	cpost.setCompleted("true");
	
	given()
	.contentType(ContentType.JSON)
	.body(cpost)  //<-----------passing new json object
	.when()
	.put("http://jsonplaceholder.typicode.com/todos/1") //<-------put method for update
	.then()
	.statusCode(200)
	.log().body();


	System.out.println("<-----------After deleting entry----------->");
		
	given()
	.contentType(ContentType.JSON)
	.when()
	.delete("http://jsonplaceholder.typicode.com/todos/1") //<-------delete method
	.then()
	.statusCode(200)
	.log().body();
	
	
	System.out.println("<-----------To extract particular json path----------->");
	
	String title = 
	when()
	.get("http://jsonplaceholder.typicode.com/todos/1") 
	.then()
	.extract().path("title");  //<-------------To extract title key from json
	
	System.out.println(title);
	
	
	System.out.println("<-----------To extract all json path----------->");
	
	ValidatableResponse response = 
	when()
	.get("http://jsonplaceholder.typicode.com/todos/1") 
	.then().contentType(ContentType.JSON);
	
	System.out.println("userID:  " + response.extract().path("userId"));
	System.out.println("title:  " + response.extract().path("title"));
	System.out.println("id:  " + response.extract().path("id"));
	System.out.println("completed:  " + response.extract().path("completed"));
	
	
	
	}
}


