package api.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayload;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	UserPayload userPayload;
	Logger logger;
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload = new UserPayload();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setName(faker.name().name());
		userPayload.setJob(faker.job().position());
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		
		logger.debug("********* creating user ***********");
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.statusCode(), 201);
		
		logger.debug("********* user is being created ***********");
		
	}
	
	@Test(priority=2)
	public void testGetSingleUser() {
		
		logger.info("********* getting single user ***********");
		
		Response response = UserEndPoints.getSingleUser(1);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********* user is being displayed ***********");
		
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		logger.info("********* updating user ***********");
		
		userPayload.setName(faker.name().name());
		userPayload.setJob(faker.job().position());
		
		Response response = UserEndPoints.updateUser(userPayload.getId(), userPayload);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.statusCode(), 201);
		
		logger.info("********* user is being updated ***********");
	}
		
	@Test(priority=4)
	public void testDeleteUser() {
		
		logger.info("********* deleting user ***********");
		
		Response response = UserEndPoints.deleteUser(userPayload.getId());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 204);
		
		logger.info("********* user is being deleted ***********");
	}
	
	@Test(priority=5)
	public void testGetListOfUser() {
		
		logger.info("********* getting list of users ***********");
		
		Response response = UserEndPoints.getListOfUser(2);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********* list of users being displayed ***********");
		
	}

}
