package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BEAN.ThongTinTaiKhoan;

public class thongTinTaiKhoanDAO {
	public static boolean insertThongTinTaiKhoan(Connection conn, ThongTinTaiKhoan tttk) {
		
		boolean kt = false;
		
		String sql = "INSERT INTO `webdatabase`.`thongtintaikhoan` (`TenDangNhap`, `HoVaTen`, `NamSinh`, `GioiTinh`, `Email`) "
				+ "VALUES ( ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, tttk.getTenDangNhap());
			ptmt.setString(2, tttk.getHoVaTen());
			ptmt.setString(3, tttk.getNamSinh());
			ptmt.setString(4, tttk.getGioiTinh());
			ptmt.setString(5, tttk.getEmail());
			
			int t = ptmt.executeUpdate();
			
			if(t!=0) {
				kt = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return kt;
	}
	
	public static void updateThongTinTaiKhoan(Connection conn, ThongTinTaiKhoan tttk) {
		String sql = "UPDATE `webdatabase`.`thongtintaikhoan` SET `HoVaTen` = ?, `NamSinh` = ?, `GioiTinh` = ?, `Email` = ? "
				+ "WHERE (`TenDangNhap` = ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, tttk.getHoVaTen());
			ptmt.setString(2, tttk.getNamSinh());
			ptmt.setString(3, tttk.getGioiTinh());
			ptmt.setString(4, tttk.getEmail());		
			ptmt.setString(5, tttk.getTenDangNhap());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void deleteThongTinTaiKhoan(Connection conn, String username) {
		
		String sql = "DELETE FROM `webdatabase`.`thongtintaikhoan` WHERE (`TenDangNhap` = ?)";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, username);
			
			ptmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
