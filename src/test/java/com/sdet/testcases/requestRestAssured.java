package com.sdet.testcases;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class requestRestAssured {

	@Test
	public void getRequest() {
		
		System.out.println("Starting requestRestAssured------------------------");
		RestAssured.baseURI = "https://pokeapi.co/";

		String Response = given().log().all().when().get("api/v2/pokemon?limit=300&name").then().assertThat().log()
				.all().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(Response);
		// String name = js.getString("name");

		int count = js.getInt("results.size()");
		System.out.println("Pokemon Count Size: "+count);

		for (int i = 0; i < count; i++) {
			String s=js.get("results["+i+"].name");
		char r = ' ';
			r = s.charAt(0);

			if (r == 's') {
				System.out.println("Pokemon ID:"+i+1+" Name: "+s);
			}

		}
		System.out.println("Finishing requestRestAssured------------------------");
	}
}
