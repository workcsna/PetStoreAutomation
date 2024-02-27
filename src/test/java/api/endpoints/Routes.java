package api.endpoints;

/* base URL:https://petstore.swagger.io
 * Create User (Post) : https://petstore.swagger.io/v2/user
 * Get User (Get) :  https://petstore.swagger.io/v2/user/{username} 
 * Update User (Put): https://petstore.swagger.io/v2/user/{username} 
 * Delete User (Delete) : https://petstore.swagger.io/v2/user/{username} 
 * https://petstore.swagger.io/v2/user/login?username=johntxcy2n1r6fp&password=johntxcy2n1r6fp
 */


public class Routes {
	
	public static String base_URL = "https://petstore.swagger.io/v2";
	
	// FOR USER Module 
	
	public static String createrUser_URL = base_URL+"/user";
	public static String getUser_URL = base_URL+"/user/{username}";
	public static String UpdateUser_URL = base_URL+"/user/{username}";
	public static String DeleteUser_URL = base_URL+"/user/{username}";
	public static String LoginUser_URL = base_URL+"/user/login/";
	public static String LogoutUser_URL = base_URL+"/user/logout/";
	// FOR STORE MODULE
	
	
	
	
	
	
	
	
	// FOR PET MODULE
	
	
	
	
	
	
	
	
	
	
}
