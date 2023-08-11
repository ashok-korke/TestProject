package api.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayload;
import api.utilities.UserDataProvider;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(dataProvider = "Data",dataProviderClass=UserDataProvider.class)
	public void testCreateUser(Object id, String name, String job) {
		UserPayload userPayload= new UserPayload();
		userPayload.setId(id);
		userPayload.setName(name);
		userPayload.setJob(job);
		
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
							
		
	}

}
