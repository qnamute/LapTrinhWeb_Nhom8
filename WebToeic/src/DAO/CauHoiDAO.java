package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import BEAN.CauHoi;

public class CauHoiDAO {
	public static List<CauHoi> displayCauHoi(Connection conn){
		
		List<CauHoi> list = new ArrayList<CauHoi>();
		
		String sql = "select `cauhoi`.`macauhoi`, `cauhoi`.`maloaicauhoi`, `loaicauhoi`.`tenloaicauhoi`, `noidung`, `option1`, `option2`, `option3`, `option4`,\r\n" + 
				"`dapandung`\r\n" + 
				" from `cauhoi`, `loaicauhoi` where `cauhoi`.`maloaicauhoi` = `loaicauhoi`.`maloaicauhoi` ORDER BY `cauhoi`.`macauhoi` ASC";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				CauHoi ch = new CauHoi();
				
				ch.setMaCauHoi(rs.getInt("MaCauHoi"));
				ch.setMaLoaiCauHoi(rs.getInt("MaLoaiCauHoi"));
				ch.setTenLoaiCauHoi(rs.getString("TenLoaiCauHoi"));
				ch.setNoiDung(rs.getString("NoiDung"));
				ch.setOption1(rs.getString("Option1"));
				ch.setOption2(rs.getString("Option2"));
				ch.setOption3(rs.getString("Option3"));
				ch.setOption4(rs.getString("Option4"));
				ch.setDapAnDung(rs.getString("DapAnDung"));
		
				list.add(ch);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertCauHoi(Connection conn, CauHoi ch) {
		String sql = "INSERT INTO `webdatabase`.`cauhoi` (`MaCauHoi`, `MaLoaiCauHoi`, `NoiDung`, `Option1`, `Option2`, `Option3`, `Option4`, `DapAnDung`)"
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			int mach = getMaCauHoi(conn);
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, mach);
			ptmt.setInt(2, ch.getMaLoaiCauHoi());
			ptmt.setString(3, ch.getNoiDung());
			ptmt.setString(4, ch.getOption1());
			ptmt.setString(5, ch.getOption2());
			ptmt.setString(6, ch.getOption3());
			ptmt.setString(7, ch.getOption4());
			ptmt.setString(8, ch.getDapAnDung());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editCauHoi(Connection conn, CauHoi ch) {
		String sql = "UPDATE `webdatabase`.`cauhoi` "
				+ "SET `MaLoaiCauHoi` = ?, `NoiDung` = ?, `Option1` = ?, `Option2` = ?, `Option3` = ?, `Option4` = ?, `DapAnDung` = ?"
				+ " WHERE (`MaCauHoi` = ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, ch.getMaLoaiCauHoi());
			ptmt.setString(2, ch.getNoiDung());
			ptmt.setString(3, ch.getOption1());
			ptmt.setString(4, ch.getOption2());
			ptmt.setString(5, ch.getOption3());
			ptmt.setString(6, ch.getOption4());
			ptmt.setString(7, ch.getDapAnDung());
			ptmt.setInt(8, ch.getMaCauHoi());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteCauHoi(Connection conn, int macauhoi) {
		String sql = "DELETE FROM `webdatabase`.`cauhoi` WHERE (`MaCauHoi` = ?)";
		
		try {
			PreparedStatement ptmt  = conn.prepareStatement(sql);
			
			ptmt.setInt(1, macauhoi);
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int getMaCauHoi(Connection conn) {
		int id = 0;
		
		String sql = "Select MAX(MaCauHoi) from cauhoi";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			if(rs.getString(1)==null) {
				
				id = 1;
			}
			else {
				id = rs.getInt(1) + 1; 
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static List<CauHoi> displayDsCauhoi_bymaDeThi(Connection conn, int maDeThi){
		 
		 String sql = "select `cauhoi`.`macauhoi`, `cauhoi`.`maloaicauhoi`, `loaicauhoi`.`tenloaicauhoi`, `cauhoi`.`noidung`, `cauhoi`.`option1`, `cauhoi`.`option2`, `cauhoi`.`option3`, `cauhoi`.`dapandung`,`cauhoi_dethi`.`madethi`\r\n" + 
				"from `cauhoi`,`cauhoi_dethi`, `loaicauhoi` \r\n" + 
				"where `cauhoi`.`macauhoi` = `cauhoi_dethi`.`macauhoi`\r\n" + 
				"and `cauhoi`.`maloaicauhoi` = `loaicauhoi`.`maloaicauhoi`\r\n" + 
				"and `madethi` = "+ maDeThi +"";
		
		List<CauHoi> list = new ArrayList<CauHoi>();
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
						
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				CauHoi ch = new CauHoi();
				
				ch.setMaCauHoi(rs.getInt("MaCauHoi"));
				ch.setMaLoaiCauHoi(rs.getInt("maloaicauhoi"));
				ch.setTenLoaiCauHoi(rs.getString("tenloaicauhoi"));
				ch.setNoiDung(rs.getString("noidung"));
				ch.setOption1(rs.getString("option1"));
				ch.setOption2(rs.getString("option2"));
				ch.setOption3(rs.getString("option3"));
				ch.setOption4(rs.getString("option4"));
				ch.setDapAnDung(rs.getString("dapandung"));
				
				list.add(ch);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static List<CauHoi> selectListRandomQuestion(Connection conn, int sl, int type) {
		
		List<CauHoi> list = new ArrayList<CauHoi>();
		
		String sql = "select `macauhoi` from `cauhoi` where `maloaicauhoi` = " + type + " order by rand() limit " + sl + "";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				CauHoi ch = new CauHoi();
				
				ch.setMaCauHoi(rs.getInt("macauhoi"));
				
				list.add(ch);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getCorrectAnswer(Connection conn, int maCauHoi) {
		
		String sql = "select dapandung from cauhoi where macauhoi= "+maCauHoi+"";
		
		String correctAnswer = "";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			correctAnswer = rs.getString("dapandung");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return correctAnswer;
	}
}
