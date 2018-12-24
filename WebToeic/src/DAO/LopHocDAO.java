package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import BEAN.LopHoc;

public class LopHocDAO {
	public static List<LopHoc> DisplayDanhSachLopHoc(Connection conn){
		
		List<LopHoc> list = new ArrayList<LopHoc>();
		
		String sql = "SELECT `lophoc`.MaLopHoc, TenLopHoc, Count(tendangnhap) as SoLuongSinhVien\r\n" + 
				"FROM lophoc\r\n" + 
				"LEFT JOIN taikhoan_lophoc ON lophoc.malophoc = taikhoan_lophoc.malophoc\r\n" + 
				"    GROUP BY malophoc;\r\n" + 
				"";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				LopHoc lh = new LopHoc();
				
				lh.setMaLopHoc(rs.getString("MaLopHoc"));
				lh.setTenLopHoc(rs.getString("TenLopHoc"));
				lh.setSoLuongSinhVien(rs.getInt("SoLuongSinhVien"));
				
				list.add(lh);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<LopHoc> DisplayLopHoc(Connection conn){
		List<LopHoc> list = new ArrayList<LopHoc>();
		
		String sql = "select * from lophoc";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				LopHoc lh = new LopHoc();
				
				lh.setMaLopHoc(rs.getString("MaLopHoc"));
				lh.setTenLopHoc(rs.getString("TenLopHoc"));
				
				list.add(lh);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertLopHoc(Connection conn, LopHoc lh) {
		
		String sql = "INSERT INTO `webdatabase`.`LopHoc` (`MaLopHoc`, `TenLopHoc`) VALUES ( ?, ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			int malh = getMaLopHoc(conn);
			
			ptmt.setInt(1, malh);
			ptmt.setString(2, lh.getTenLopHoc());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteLopHoc(Connection conn, LopHoc lh) {
		
		int malh = Integer.parseInt(lh.getMaLopHoc());
		
		String sql = "DELETE FROM `webdatabase`.`lophoc` WHERE (`MaLopHoc` = ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, malh);
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void editClass(Connection conn, LopHoc lh) {
		
		String sql = "UPDATE `webdatabase`.`lophoc` SET `TenLopHoc` = ? WHERE (`MaLopHoc` = ?)";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, lh.getTenLopHoc());
			
			ptmt.setString(2, lh.getMaLopHoc());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int getMaLopHoc(Connection conn) {
		String sql = "select max(malophoc) from lophoc";
		
		int malh = 0;
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			malh = rs.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		malh = malh + 1;
		
		return malh;
	}
	
	public static void addClassforStudent(Connection conn, int classid, String tenDangNhap) {
		
		String sql = "INSERT INTO `webdatabase`.`taikhoan_lophoc` (`MaLopHoc`, `TenDangNhap`) VALUES ( ?, ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, classid);
			ptmt.setString(2, tenDangNhap);
			
			ptmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
