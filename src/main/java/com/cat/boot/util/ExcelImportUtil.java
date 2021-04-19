package com.cat.boot.util;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelImportUtil {

	public static List<Map<String, Object>> readXls3(MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
		// 循环工作表Sheet
		List<Map<String, Object>> list = new ArrayList<>();
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			Map<Object, String> key = new HashMap<>();
			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				hssfRow.getLastCellNum();
				Map<String, Object> values = new HashMap<>();
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					XSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}
					Object value = "";
					switch (hssfCell.getCellType()) {
						case XSSFCell.CELL_TYPE_STRING:
							value = hssfCell.getStringCellValue();
							break;
						case XSSFCell.CELL_TYPE_FORMULA:
							value = hssfCell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
							value = dataFormatter.formatCellValue(hssfCell);
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							break;
					}
//					value = getValue(hssfCell, key.get("TYPE" + cellNum));
					// 取第一行的值作为key
					if (rowNum == 0) {
						String tmp = (String) value;
						if (!StringUtil.isEmpty(tmp) && !"null".equals(tmp)) {
							key.put(cellNum, (String) value);
						}
					}else if (rowNum ==1) {
						continue;
					} else {
						if (key.containsKey(cellNum)) {
							values.put(key.get(cellNum), value);
						}
					}
				}
				if (!StringUtil.isMapEmpty(values)) {
					list.add(values);
				}
			}
		}
		return list;
	}

		public static List<Map<String, Object>> readXls(MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// 循环工作表Sheet
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			Map<Object, String> key = new HashMap<Object, String>();
			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				hssfRow.getLastCellNum();
				// 循环列Cell
				// ExcelBean eb = new ExcelBean();
				Map<String, Object> values = new HashMap<String, Object>();
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}
					Object value;
					value = getValue(hssfCell, key.get("TYPE" + String.valueOf(cellNum)));
					// 取第一行的值作为key
					if (rowNum == 0) {
						String tmp = (String) value;
						if (!StringUtil.isEmpty(tmp) && !"null".equals(tmp)) {
							key.put(cellNum, (String) value);
						}
					} else if (rowNum == 2) {
						key.put("TYPE" + String.valueOf(cellNum), (String) value);
					} else {
						if (key.containsKey(cellNum)) {
							values.put(key.get(cellNum), value);
						}
					}
				}
				if (!StringUtil.isMapEmpty(values)) {
					list.add(values);
				}
			}
		}
		return list;
	}
	
	public static List<Map<String, Object>> readXls2(MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// 循环工作表Sheet
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			Map<Object, String> key = new HashMap<Object, String>();
			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				System.out.println("rowNum"+rowNum);
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				hssfRow.getLastCellNum();
				// 循环列Cell
				// ExcelBean eb = new ExcelBean();
				Map<String, Object> values = new HashMap<String, Object>();
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					System.out.println("cellNum"+cellNum);
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}
					Object value;
					value = getValue(hssfCell, key.get("TYPE" + String.valueOf(cellNum)));
					System.out.println(value);
					// 取第一行的值作为key
					if (rowNum == 2) {
						String tmp = (String) value;
						if (!StringUtil.isEmpty(tmp) && !"null".equals(tmp)) {
							key.put(cellNum, (String) value);
						}
					} else if (rowNum == 3) {
						key.put("TYPE" + String.valueOf(cellNum), (String) value);
					} else {
						if (key.containsKey(cellNum)) {
							values.put(key.get(cellNum), value);
						}
					}
				}
				if (!StringUtil.isMapEmpty(values)) {
					list.add(values);
				}
			}
		}
		return list;
	}

	private static Object getValue(HSSFCell hssfCell, String type) {
		if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue()).trim();
		} else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(hssfCell)) {
				Date theDate = hssfCell.getDateCellValue();
				SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
				return dff.format(theDate);
			} else {
				if ("String".equals(type) || "int".equals(type)) {
					DecimalFormat df = new DecimalFormat("0");
					String tmp = df.format(hssfCell.getNumericCellValue());
					if ("String".equals(type)) {
						return tmp;
					} else {
						return Integer.valueOf(tmp);
					}
				} else {
					return hssfCell.getNumericCellValue();
				}
			}
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue()).trim();
		}
	}

	public static Object getValue(XSSFCell xssfCell, String type) {
		if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue()).trim();
		} else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(xssfCell)) {
				Date theDate = xssfCell.getDateCellValue();
				SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
				return dff.format(theDate);
			} else {
				if ("String".equals(type) || "int".equals(type)) {
					DecimalFormat df = new DecimalFormat("0");
					String tmp = df.format(xssfCell.getNumericCellValue());
					if ("String".equals(type)) {
						return tmp;
					} else {
						return Integer.valueOf(tmp);
					}
				} else {
					return xssfCell.getNumericCellValue();
				}
			}
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue()).trim();
		}
	}
}
