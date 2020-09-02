package test.api.automation;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

public class BDDwithRest {
	
	@Test
	public void Test1()
	{
	given()		//.param("t", "Spiderman")     //<-----------Given keyword of BDD
		   //.param("y","")               //<-----------param method to pass parameters of URL
		   //.param("plot","short")
		   //.param("r","json")
	//.param(("page", 2)
	.when().get("https://reqres.in/api/users/")  //<----------When keyword of BDD. To pass URL
	.then().statusCode(200);  //<------------then keyword of BDD to validate response with 200 status code
	
	}
	

}
