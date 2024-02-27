package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class UserEndPoints {
	
	public static Response CreateUser(User payload)
	{
		Response response = given()
				
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.createrUser_URL);
		return response; 
	}
	
	
	
	public static Response GetUser(String userName)
	{
		Response response = given()
			
			.pathParam("username", userName)
		.when()
			.get(Routes.getUser_URL);
		return response; 
	}
	
	public static Response LoginUser(String userName, String Password)
	{
		Response response = given()
				.queryParam("username", userName)
				.queryParam("password", Password)
		.when()
			.get(Routes.LoginUser_URL);
		return response; 
	}
	
	public static Response LogoutUser(String userName, String Password)
	{
		Response response = given()
				.queryParam("username", userName)
				.queryParam("password", Password)
		.when()
			.get(Routes.LogoutUser_URL);
		return response; 
	}
	
	public static Response UpdateUser(String userName,User payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.UpdateUser_URL);
		return response; 
	}
		
	public static Response DeleteUser(String userName)
		{
			Response response = given()
				.pathParam("username", userName)
			.when()
				.delete(Routes.DeleteUser_URL );
			return response; 
		}
	
		
	
	
}
