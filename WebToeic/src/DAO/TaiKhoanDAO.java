package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.LopHoc;
import BEAN.TaiKhoan;
import BEAN.ThongTinTaiKhoan;

public class TaiKhoanDAO {
	public static List<ThongTinTaiKhoan> DisplayTaiKhoan(Connection conn){
		
		
		List<ThongTinTaiKhoan> list = new ArrayList<ThongTinTaiKhoan>();
		
		String sql = "select `taikhoan`.`tendangnhap`, `hovaten`, `namsinh`, `gioitinh`, `email`  from `taikhoan`, `thongtintaikhoan` where `taikhoan`.`maloaitaikhoan` = 1\r\n" + 
				"and `taikhoan`.`tendangnhap` = `thongtintaikhoan`.`tendangnhap`";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
				
				tttk.setTenDangNhap(rs.getString("tendangnhap"));
				tttk.setHoVaTen(rs.getString("hovaten"));
				tttk.setNamSinh(rs.getString("namsinh"));
				tttk.setGioiTinh(rs.getString("gioitinh"));
				tttk.setEmail(rs.getString("email"));
				
				list.add(tttk);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static boolean insertTaiKhoan(Connection conn, TaiKhoan tk) {
		boolean kt = false;
		
		String sql = "INSERT INTO `webdatabase`.`TaiKhoan` (`TenDangNhap`, `MatKhau`, `MaLoaiTaiKhoan`) VALUES (?, ?, ?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, tk.getTenDangNhap());
			ptmt.setString(2, tk.getMatKhau());
			ptmt.setInt(3, tk.getMaLoaiTaiKhoan());
			System.out.println("abcdefgh");
			int t = ptmt.executeUpdate();
			if(t!=0) {
				kt = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return kt;
	}
	
	public static void updateTaiKhoan(Connection conn, TaiKhoan tk) {
		
		String sql = "UPDATE `webdatabase`.`TaiKhoan` SET  `MaLoaiTaiKhoan` = ? "
				+ "WHERE (`TenDangNhap` = '?')";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, tk.getMaLoaiTaiKhoan());
			ptmt.setString(2, tk.getTenDangNhap());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTaiKhoan(Connection conn, String username) {
		
		String sql = "DELETE FROM `webdatabase`.`TaiKhoan` WHERE (`TenDangNhap` = ?";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, username);
			
			ptmt.executeUpdate();
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	
	public static List<LopHoc> displayLopHocby_tenDangNhap(Connection conn, String username){
		List<LopHoc> list = new ArrayList<LopHoc>();
		
		String sql = "select * from taikhoan_lophoc where tendangnhap = ?";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, username);
			
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
	public static List<ThongTinTaiKhoan> SelectTaiKhoan(Connection conn, String tendangnhap){
		
		List<ThongTinTaiKhoan> list = new ArrayList<ThongTinTaiKhoan>();
		
		String sql = "select `taikhoan`.`tendangnhap`, `hovaten`, `namsinh`, `gioitinh`, `email`  from `taikhoan`, `thongtintaikhoan` "
				+ "where `taikhoan`.`maloaitaikhoan` = 1\r\n" + 
				"and `taikhoan`.`tendangnhap` = `thongtintaikhoan`.`tendangnhap` and `taikhoan`.`tendangnhap` = " + tendangnhap + "";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
				
				tttk.setTenDangNhap(rs.getString("tendangnhap"));
				tttk.setHoVaTen(rs.getString("hovaten"));
				tttk.setNamSinh(rs.getString("namsinh"));
				tttk.setGioiTinh(rs.getString("gioitinh"));
				tttk.setEmail(rs.getString("email"));
				
				list.add(tttk);
			}			
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
		return list;
	}
}
