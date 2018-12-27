package com.my.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		ArrayList<AppAPIDetail> inputData = new ArrayList<AppAPIDetail>();
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
			
			HashMap<String, Integer> map = new HashMap<>();

			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] input = line.split(",");
				if(input.length < 3) {
					continue;
				}
				String appName = input[0].trim();
				String apiName = input[1].trim();
				int version = Integer.valueOf(input[2].trim().substring(1));
				
				AppAPIDetail app = new AppAPIDetail(appName, apiName, version);
				inputData.add(app);
				int value = version;
				if(map.containsKey(apiName)) {
					value = Math.max(value, map.get(apiName));
				}
				map.put(apiName, value);
			}
			
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			
			Set<String> result = new HashSet<>();
			
			for(AppAPIDetail app : inputData) {
				if(map.get(app.apiName) > app.version && !result.contains(app.appName)) {
					output.println(app.appName);
					result.add(app.appName);
				}
			}
			
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
			e.printStackTrace();

		}
	}
	
	static class AppAPIDetail{
		String appName;
		String apiName;
		int version;
		public AppAPIDetail(String app, String api, int v) {
			appName = app;
			apiName = api;
			version = v;
		}
	}
}