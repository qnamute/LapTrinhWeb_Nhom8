package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.LoaiCauHoi;

public class LoaiCauHoiDAO {
	public static List<LoaiCauHoi> displayLoaiCauHoi(Connection conn){
		
		List<LoaiCauHoi> list = new ArrayList<LoaiCauHoi>();
		
		String sql ="select `maloaicauhoi`, `tenloaicauhoi` from `loaicauhoi`";
		
		try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				LoaiCauHoi lch = new LoaiCauHoi();
				
				lch.setMaLoaiCauHoi(rs.getInt("MaLoaiCauHoi"));
				lch.setTenLoaiCauHoi(rs.getString("TenLoaiCauHoi"));
				
				list.add(lch);
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
