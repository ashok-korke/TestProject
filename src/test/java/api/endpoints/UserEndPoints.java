package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payloads.UserPayload;
import io.restassured.http.ContentType;

public class UserEndPoints {

	public static Response getSingleUser(Object object) {

		Response response = given().pathParam("id", object).when().get(Routes.getSingleUser_url);

		return response;

	}

	public static Response getListOfUser(int page) {

		Response response = given().pathParam("page", page).when().get(Routes.getListOfUser_url);
		return response;

	}

	public static Response createUser(UserPayload userPayload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayload).when()
				.post(Routes.createUser_url);

		return response;

	}

	public static Response updateUser(Object id, UserPayload updateUserPayload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id", id)
				.body(updateUserPayload).when().post(Routes.updateUser_url);
		return response;

	}

	public static Response deleteUser(Object id) {
		Response response = given().pathParam("id", id).when().delete(Routes.deleteUser_url);
		return response;
	}

}
