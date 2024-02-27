package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class UserEndPoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response CreateUser(User payload)
	{
		String post_url = getURL().getString("post_url");	
		
		Response response = given()
				
			
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response; 
	}
	
	
	
	public static Response GetUser(String userName)
	{
		
		String get_url = getURL().getString("get_url");
		Response response = given()
			
			.pathParam("username", userName)
		.when()
			.get(get_url);
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
		String update_url = getURL().getString("update_url");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(update_url);
		return response; 
	}
		
	public static Response DeleteUser(String userName)
		{
		String delete_url = getURL().getString("delete_url");
			Response response = given()
				.pathParam("username", userName)
			.when()
				.delete(delete_url);
			return response; 
		}
	
		
	
	
}
