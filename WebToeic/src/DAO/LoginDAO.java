package DAO;

import java.sql.*;


public class LoginDAO {

	public static boolean Validate(String name, String pass, Connection conn) {
		
		String username = null;
		String password = null;

		boolean t = false;

		String sql = "Select TenDangNhap, MatKhau, MaLoaiTaiKhoan from TaiKhoan";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				username = rs.getString("TenDangNhap");
				password = rs.getString("MatKhau");			
				if ((username.equals(name)) && (password.equals(pass))) {
					t = true;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static int CheckRole(String name, Connection conn) {

		int t = 0;

		java.sql.PreparedStatement ptmt = null;

		String sql = "select MaLoaiTaiKhoan from TaiKhoan where TenDangNhap = '"+ name +"'";

		try {
			ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();

			rs.next();
			
			t = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
		
	}
	
	public static String userLogin(Connection conn) {
		String username = "";
		
		String sql = "select `tendangnhap` from `TaiKhoan_Login`";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			username = rs.getString("tendangnhap");
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return username;
	}
	
	public static boolean setLogin(Connection conn, String username) {
		
		boolean kt = false;
		
		String sql = "UPDATE `webdatabase`.`TaiKhoan_Login` SET `TenDangNhap` = ? WHERE (`MaTaiKhoan` = '1')";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, username);
			
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
	public static boolean setLogout(Connection conn) {
		
		boolean kt = false;
		
		String sql = "UPDATE `webdatabase`.`TaiKhoan_Login` SET `TenDangNhap` = '0' WHERE (`MaTaiKhoan` = '1')";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
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
}
