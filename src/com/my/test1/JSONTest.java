package com.my.test1;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

public class JSONTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String dataString = Data.getDataString();
		
		System.out.println(dataString);
		ObjectMapper mapper = new ObjectMapper();
		
		List<Object> list = mapper.readValue(dataString, List.class);
		
		System.out.println(list);
		
		for(Object object : list) {
			System.out.println(object.getClass());
			
			LinkedHashMap map = (LinkedHashMap) object;
			
			Object data = map.get("data");
			
			System.out.println(data.getClass());
			
			List<HashMap<String, String>> al =  (List<HashMap<String, String>>) data;
			
			for(HashMap<String, String> obj : al) {
				System.out.println(obj);
				
			}
		}

	}
	
	
	public static String convertToJSON(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Converting to JSON String");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
	
	public static JSONArray convertTOJSONObject(String string) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(string, JSONArray.class);
	}

}
