package com.howtodoinjava.demo.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {
	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("employees.json")) {
			Object obj = jsonParser.parse(reader);

			JSONObject person = (JSONObject) obj;

			JSONObject taxLabelInfo = (JSONObject) person.get("taxLabelInfo");

			JSONObject defaultValue = (JSONObject) taxLabelInfo.get("defaultValue");

			JSONArray labels = (JSONArray) defaultValue.get("labels");

			System.out.println(labels.get(2));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
