package DAO;

import javax.servlet.ServletException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import BEAN.CauHoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
public class ImportQuestionFromFileDAO {

		public static int ImportExcel(Connection conn, String ex)
				throws ServletException, IOException {
				int kt = 0;

				FileInputStream inp;

				try {
					inp = new FileInputStream(ex.toString());
//					System.out.println(ex.toString());
					HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));

					// Lay so dong
					Sheet sheet = wb.getSheetAt(0);

					for (int i = 1; i <= sheet.getLastRowNum(); i++) {

						Row row = sheet.getRow(i);

						CauHoi ch = new CauHoi();
						try {							
							ch.setMaCauHoi((int) row.getCell(0).getNumericCellValue());
							ch.setMaLoaiCauHoi((int) row.getCell(1).getNumericCellValue());
							ch.setNoiDung(row.getCell(2).getStringCellValue());
							ch.setOption1(row.getCell(3).getStringCellValue());
							ch.setOption2(row.getCell(4).getStringCellValue());
							ch.setOption3(row.getCell(5).getStringCellValue());
							ch.setOption4(row.getCell(6).getStringCellValue());
							ch.setDapAnDung(row.getCell(7).getStringCellValue());	
							wb.close();
						}
						catch(Exception e) {
							e.printStackTrace();

						}						
						CauHoiDAO.insertCauHoi(conn, ch);
					}
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
		catch (IOException e) {
			e.printStackTrace();
		}
				return kt;
	}
}


