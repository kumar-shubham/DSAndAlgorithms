package com.my.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.my.dto.DocFile;
import com.my.dto.Row;
import com.my.utils.ExcelUtil;

public class ClassGenerator {
	
	private static HashMap<String, String> typeMap = new HashMap<>();
	
	static {
		typeMap.put("Price", "Double");
		typeMap.put("SeqNum", "Integer");
		typeMap.put("Length", "Integer");
		typeMap.put("Amt", "Double");
		typeMap.put("Qty", "Double");
		typeMap.put("Currency", "String");
		typeMap.put("MultipleCharValue", "String");
		typeMap.put("Exchange", "String");
		typeMap.put("NumInGroup", "Integer");
		typeMap.put("NumInGrp", "Integer");
		typeMap.put("UTCTimestamp", "String");
		typeMap.put("LocalMktDate", "String");
		typeMap.put("data", "String");
		typeMap.put("Percentage", "Double");
		typeMap.put("PriceOffset", "Double");
		typeMap.put("day-of-month", "Integer");
		typeMap.put("MonthYear", "String");
		typeMap.put("UTCDateOnly", "String");
		typeMap.put("UTCTimeOnly", "String");
		typeMap.put("MultipleStringValue", "String");
		typeMap.put("Country", "String");
		typeMap.put("TZTimeOnly", "String");
		typeMap.put("TZTimestamp", "String");
		typeMap.put("XMLData", "String");
		typeMap.put("Language", "String");
	}
	
	public static void main(String args[]) throws Exception {
		
		String xlsxPath = "/home/kumar/Documents/FIX_5_SP2.xlsx";
		
		ExcelUtil excel = new ExcelUtil();
		DocFile file = excel.getDataFromXLSXFile(xlsxPath);
		createFile(file);
	}
	
	private static void createFile(DocFile docFile) throws FileNotFoundException {
		
		String filename = "/home/kumar/Documents/FIX_5_SP2.java";
		File file = new File(filename);
		
		FileWriter fr = null;
        BufferedWriter br = null;
        
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            Iterator<Row> rows = docFile.getRowIterator();
            while(rows.hasNext()) {
    			Row row = rows.next();
    			HashMap<String, String> fields = row.getRowData();
    			Set<String> keySet = fields.keySet();
    			
    			String type = "";
    			String name = "";
    			for(String key : keySet) {
    				if("Type".equals(key)) {
    					type = fields.get(key);
    				}else if("Name".equals(key)) {
    					name = fields.get(key);
    				}
    			}
    			if(StringUtils.isNotEmpty(type) && typeMap.containsKey(type)) {
    				type = typeMap.get(type);
    			}
    			if(StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(name)) {
    				String str = "private " + type + " " + name + ";" + System.getProperty("line.separator")
    				+ System.getProperty("line.separator");
    				int whiteSpaceCount = 0;
    				for(int i = 0; i<str.length();i++) {
    					if(str.charAt(i) == ' ') {
    						whiteSpaceCount++;
    					}
    				}
    				if(whiteSpaceCount > 2) {
    					str = "*****" + str;
    				}
    				br.write(str);
    				
    			}
    		}
            System.out.println("writing done");
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}

}
