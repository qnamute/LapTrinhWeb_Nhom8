package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.LopHoc;
import BEAN.ThongTinTaiKhoan;

public class StudentDAO {
	public static List<ThongTinTaiKhoan> getThongTinTK(Connection conn, String username) {
		
		List<ThongTinTaiKhoan> list = new ArrayList<ThongTinTaiKhoan>();
		
		String sql = "select `taikhoan`.`tendangnhap`, `hovaten`, `namsinh`, `gioitinh`, `email`  from `taikhoan`, `thongtintaikhoan` where `taikhoan`.`maloaitaikhoan` = 1\r\n" + 
				"				and `taikhoan`.`tendangnhap` = `thongtintaikhoan`.`tendangnhap` and `taikhoan`.`tendangnhap` = '"+ username +"'";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
				
				tttk.setTenDangNhap(rs.getString("TenDangNhap"));
				tttk.setHoVaTen(rs.getString("HoVaTen"));
				tttk.setNamSinh(rs.getString("NamSinh"));
				tttk.setEmail(rs.getString("Email"));
				tttk.setGioiTinh(rs.getString("GioiTinh"));
				
				list.add(tttk);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<LopHoc> displayDSLopHoc_sinhVien(Connection conn){
		
		List<LopHoc> list = new ArrayList<LopHoc>();
		
//		String username = getUsernameStudent(conn);
		
		String username = "student1";
		
		String sql = "select `lophoc`.`malophoc`,`lophoc`.`tenlophoc` \r\n" + 
				"from `LopHoc`,`taikhoan_lophoc` \r\n" + 
				"where `lophoc`.`malophoc` = `taikhoan_lophoc`.`malophoc` and `taikhoan_lophoc`.`tendangnhap` = '"+ username +"'";
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
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getUsernameStudent(Connection conn) {
		
		String username = "";
		
		String sql = "select * from TaiKhoan_Login";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			username = rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return username;
	}
}
