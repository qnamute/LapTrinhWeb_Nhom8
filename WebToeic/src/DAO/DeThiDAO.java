package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.CauHoi;
import BEAN.DeThi;

public class DeThiDAO {
	public static List<DeThi> displayDSDeThi(Connection conn){
		List<DeThi> list = new ArrayList<DeThi>();
		
		String sql = "select * from dethi";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				DeThi dt = new DeThi();
				
				dt.setMaDeThi(rs.getInt("MaDeThi"));
				dt.setTenDeThi(rs.getString("TenDeThi"));
				dt.setSoLuongCauHoi(rs.getInt("SoLuongCauHoi"));
				dt.setThoiGianThi(rs.getInt("ThoiGianThi"));
				list.add(dt);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int insertDeThi(Connection conn, DeThi dt) {
		String sql = "INSERT INTO `webdatabase`.`dethi` (`MaDeThi`, `TenDeThi`, `SoLuongCauHoi`, `thoigianthi`) VALUES ( ?, ?, ?, ?)";
		
		int id = getMaDeThi(conn);
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, id);
			ptmt.setString(2, dt.getTenDeThi());
			ptmt.setInt(3, dt.getSoLuongCauHoi());
			ptmt.setInt(4, dt.getThoiGianThi());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static void deleteDeThi(Connection conn, int madethi) {
		
		String sql = "DELETE FROM `webdatabase`.`dethi` WHERE (`MaDeThi` = ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, madethi);
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public static int getMaDeThi(Connection conn) {
		String sql = "SELECT MAX(`madethi`) FROM `dethi`";
		
		int id = 0;
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			id = rs.getInt(1) + 1;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static void detThi_cauHoi(Connection conn, List<CauHoi> lst, int id) {
		
		for(int i = 0 ; i < lst.size(); i++) {
			String sql = "INSERT INTO `webdatabase`.`cauhoi_dethi` (`MaCauHoi`, `MaDeThi`) VALUES ( ?, ?)";
			
			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				
				int idcauhoi = lst.get(i).getMaCauHoi();
				
				ptmt.setInt(1, idcauhoi);
				ptmt.setInt(2, id);
				
				ptmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void deleteDeThi_CauHoi(Connection conn, int madethi) {
		
		String sql = "DELETE FROM `webdatabase`.`cauhoi_dethi` WHERE (`MaDeThi` = ?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, madethi);
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int getThoiGianLamBai(Connection conn, int iddethi) {
		int time = 0;
		
		
		String sql = "select thoigianthi from dethi where madethi= "+iddethi+"";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			time = rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return time;
	}
	public static int getSoLuongCauHoi(Connection conn, int iddethi) {
		
		int sl = 0;
		
		String sql = "Select SoLuongCauHoi from DeThi where madethi = "+iddethi+"";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			rs.next();
			
			sl = rs.getInt("soluongcauhoi");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return sl;
	}
}
