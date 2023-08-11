package api.endpoints;

public class Routes {
	
	public static String base_url="https://reqres.in/";
	
	public static String getSingleUser_url=base_url+"api/users/{id}";
	public static String getListOfUser_url=base_url+"api/users?{page}";
	public static String createUser_url=base_url+"api/users";
	public static String updateUser_url=base_url+"api/users/{id}";
	public static String deleteUser_url=base_url+"api/users/{id}";

}
