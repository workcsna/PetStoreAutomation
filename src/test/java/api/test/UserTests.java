package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;

import io.restassured.response.Response;
public class UserTests {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("****************** Creating User *******************");
		Response response = UserEndPoints.CreateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************** User is created *******************");
	}
	
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("****************** Reading User Info *******************");
		Response response = UserEndPoints.GetUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************** User info is displayed *******************");
	}
	
	
	@Test (priority=3)
	public void testLoginUser()
	{
		Response response = UserEndPoints.LoginUser(this.userPayload.getUsername(), this.userPayload.getPassword());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=4)
	public void testUpdateUserByName()
	{
		logger.info("****************** Updating User *******************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.UpdateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****************** User updated *******************");
		//Checking data after update
		Response responseAfterUpdate = UserEndPoints.GetUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=5)
	public void testDeleteUserByName()
	{
		logger.info("****************** Deleting User *******************");
		
		Response response = UserEndPoints.DeleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****************** User Deleted *******************");
	}
	
	
	@Test (priority=6)
	public void testLogoutUser()
	{
		Response response = UserEndPoints.LogoutUser(this.userPayload.getUsername(), this.userPayload.getPassword());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
