package com.sdet.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class restAssuredE1 {
		
	@Test
	public void newRequest() {
		
		//JsonPath js=new JsonPath(payload.info());
		
		Response r = given().when().get("{\r\n"
				+ "   \"person\": {\r\n"
				+ "    \"list\": [\r\n"
				+ "        {\r\n"
				+ "          \"id\":A135443\r\n"
				+ "          \"name\":\"Jeff\"\r\n"
				+ "          \"start\":5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"id\":A135410\r\n"
				+ "          \"name\":\"JohnDoe\"\r\n"
				+ "          \"start\":5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"id\":A135418\r\n"
				+ "          \"name\":\"Adam\"\r\n"
				+ "          \"start\":4\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"id\":A135431\r\n"
				+ "          \"name\":\"Harry\"\r\n"
				+ "          \"start\":3\r\n"
				+ "        },\r\n"
				+ "         ....\r\n"
				+ "   ]}}\r\n"
				+ "");
		JsonPath js= r.jsonPath();
		List<Object> values = js.getList("person.list.findAll { it.start < 5 }.name");
		
		
	}
}
