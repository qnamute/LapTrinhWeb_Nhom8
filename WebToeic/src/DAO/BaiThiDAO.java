package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.BaiThi;

public class BaiThiDAO {
	public static List<BaiThi> displayDSBaiThi(Connection conn){
		
		List<BaiThi> list = new ArrayList<BaiThi>();
		
		String sql = "select `baithi`.`malophoc`, `lophoc`.`tenlophoc`, `baithi`.`madethi`, `dethi`.`tendethi`, `baithi`.`thoigianbatdau`, `baithi`.`thoigianketthuc`, `dethi`.`soluongcauhoi`,`dethi`.`thoigianthi`\r\n" + 
				"from `lophoc`, `dethi`, `baithi`\r\n" + 
				"where `lophoc`.`malophoc` = `baithi`.`malophoc`\r\n" + 
				"and `dethi`.`madethi` = `baithi`.`madethi`";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				BaiThi bt = new BaiThi();
				
				bt.setMaLopHoc(rs.getInt("MaLopHoc"));
				bt.setTenLopHoc(rs.getString("TenLopHoc"));
				bt.setMaDeThi(rs.getInt("MaDeThi"));
				bt.setTenDeThi(rs.getString("TenDeThi"));
				bt.setThoiGianBatDau(rs.getString("ThoiGianBatDau"));
				bt.setThoiGianKetThuc(rs.getString("ThoiGianKetThuc"));
				bt.setThoiGianThi(rs.getInt("ThoiGianThi"));
				bt.setSoLuongCauHoi(rs.getInt("SoLuongCauHoi"));
				
				list.add(bt);
			}		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertBaiThi (Connection conn, BaiThi bt) {
		
		String sql = "INSERT INTO `webdatabase`.`baithi` (`MaLopHoc`, `MaDeThi`, `ThoiGianBatDau`, `ThoiGianKetThuc`) VALUES (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, bt.getMaLopHoc());
			ptmt.setInt(2, bt.getMaDeThi());
			ptmt.setString(3, bt.getThoiGianBatDau());
			ptmt.setString(4, bt.getThoiGianKetThuc());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
