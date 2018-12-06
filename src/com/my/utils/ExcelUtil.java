package com.my.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.my.dto.DocFile;
import com.my.dto.Row;

public class ExcelUtil {

	@SuppressWarnings({ "rawtypes", "resource" })
	public DocFile getDataFromXLSXFile(String filename) throws Exception {

		System.out.println("inside getDataFromXLSXFile");

		DocFile file = new DocFile();

		InputStream ExcelFileToRead = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		Map<Integer, String> headerMap = new HashMap<>();
		int counter = 0;
		while (rows.hasNext()) {
			System.out.println("Row count => " + counter);
			counter++;
			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			Row fileRow = new Row();
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				String value = getCellValue(cell);

				if (StringUtils.isEmpty(value)) {
					continue;
				}

				if (counter == 1 && StringUtils.isNotEmpty(value)) {
					headerMap.put(cell.getColumnIndex(), value);
				} else if (StringUtils.isNotEmpty(value) && !value.contains("#")) {
					fileRow.setValue(headerMap.get(cell.getColumnIndex()), value);
				}
			}
			if (counter > 1) {
				file.addRow(fileRow);
			}
		}
		return file;
	}

	@SuppressWarnings({ "rawtypes", "resource" })
	public HashMap<String, String> readKeyValuePairFromXLSFile(String filename) throws Exception {

		System.out.println("inside readKeyValuePairFromXLSFile");

		HashMap<String, String> map = new HashMap<>();

		InputStream ExcelFileToRead = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		int counter = 0;
		while (rows.hasNext()) {
			System.out.println("Row count => " + counter);
			counter++;
			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			int cellCount = 0;
			String key1 = null;
			String value1 = null;
			while (cells.hasNext()) {
				cellCount++;
				cell = (XSSFCell) cells.next();
				String value = getCellValue(cell);

				if (cellCount == 1) {
					key1 = value;
				} else if (cellCount == 2) {
					value1 = value;
				}
			}
			if (StringUtils.isNotEmpty(key1) && StringUtils.isNotEmpty(value1)) {
				if (key1.contains(".")) {
					key1 = key1.replaceAll("\\.", "_");
				}
				map.put(key1, value1);
			}
		}
		return map;
	}

	@SuppressWarnings("deprecation")
	private String getCellValue(XSSFCell cell) throws Exception {
		String value = null;
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			DataFormatter dataFormatter = new DataFormatter();
			value = dataFormatter.formatCellValue(cell);
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			DataFormatter dataFormatter = new DataFormatter();
			value = dataFormatter.formatCellValue(cell);
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			DataFormatter dataFormatter = new DataFormatter();
			value = dataFormatter.formatCellValue(cell);
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
		} else {
			System.out.println("new cell type => " + cell.getCellType());
			throw new Exception("New type of cell format encountered. need to check");
		}
		return value;
	}

}
