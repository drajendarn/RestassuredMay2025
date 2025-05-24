package week3.day2.restassuredTestNGDataProvider;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class GetIncidentJsonExtractor {

	public static void main(String[] args) {
		
	List<Map<String,Object>> list=	RestAssured
		.given()
		.baseUri("https://dev340392.service-now.com")
		.basePath("api/now/table")
		.auth()
		.basic("admin", "n=oyj4W4IJD/")
		.pathParam("table-name", "incident")
		.pathParam("sys_id", "ff4c21c4735123002728660c4cf6a758")//to search for specific sysid
		.queryParam("sysparm_display_value", "true")
		.when()
		.get("/{table-name}/{sys_id}") //here incident value is sent
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.jsonPath()
		.getList("result");
	
	for (Map<String, Object> map : list) {
	System.out.println(map.get("sys_id"));	
	}

	}

}
