package com.howtodoinjava.demo.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFullJson {

	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("Bp_Menu.json")) {
			Object obj = jsonParser.parse(reader);

			JSONArray array = (JSONArray) (((JSONObject) (((JSONObject) obj).get("body"))).get("items"));

			for (Object o : array) {
				String item = (String) ((JSONObject) o).get("id");
				JSONArray value = (JSONArray) ((JSONObject) ((JSONObject) ((JSONObject) o).get("taxLabelInfo"))
						.get("defaultValue")).get("labels");

				if (value.contains("TEMP_HEATED")) {
					System.out.println(item + "======>" + "TEMP_HEATED");
				} else if (value.contains("TEMP_UNHEATED")) {
					System.out.println(item + "======>" + "TEMP_UNHEATED");
				} else if (value.contains("TEMP_COLD")) {
					System.out.println(item + "======>" + "TEMP_COLD");
				} else {
					System.out.println(item + "======>" + "Nothing is found about TEMP");
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
