package test.api.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*; //static import. 
import com.jayway.restassured.response.Response;

public class TC_001_GetMethod {
	
	@Test
	public void tc_001_getMethod_validation()
	{
		//Response response = RestAssured.get("http://thomas-bayer.com/sqlrest/CUSTOMER/3/"); //Before static import. we can call get method by referring to class name.
		Response response = get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1"); //After static import. we can call get method directly.
		System.out.println(response.asString());	//<--------- Response String	
		System.out.println(response.getStatusCode());	//<--------- Get Status code
		Assert.assertEquals(200, response.getStatusCode()); //<---------Asserting the response status code
		
		//Response response1 = RestAssured.get("http://services.groupkt.com/country/get/all");
		System.out.println(response.getContentType());
		//Assert.assertEquals(response.getContentType(),"application/json;charset-UTF-8");
		
		
		//http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json

		
	}

}
