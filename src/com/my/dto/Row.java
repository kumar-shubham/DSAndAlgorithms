package com.my.dto;

import java.util.HashMap;

public class Row {
	
	private HashMap<String, String> rowData = new HashMap<>(); 
	
	/**
	 * @return the rowData
	 */
	public HashMap<String, String> getRowData() {
		return rowData;
	}

	/**
	 * @param rowData the rowData to set
	 */
	public void setRowData(HashMap<String, String> rowData) {
		if(rowData != null) {
			this.rowData = rowData;
		}
	}
	
	public String getValue(String header) {
		return rowData.get(header);
	}
	
	public void setValue(String header, String value) throws Exception {
			this.rowData.put(header, value);
	}
	
	public int size() {
		return rowData.size();
	}

}
