package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.CauHoi;
import BEAN.Exam;

public class ExamDAO {
	public static List<Exam> displayListExam(Connection conn){
		
		List<Exam> list = new ArrayList<Exam>();
		
		
		String sql = "select `baithi`.`malophoc`, `lophoc`.`tenlophoc`, `baithi`.`madethi`, `dethi`.`tendethi`, `baithi`.`thoigianbatdau`, `baithi`.`thoigianketthuc`, `dethi`.`soluongcauhoi`,`dethi`.`thoigianthi`\r\n" + 
				"from `lophoc`, `dethi`, `baithi`\r\n" + 
				"where `lophoc`.`malophoc` = `baithi`.`malophoc`\r\n" + 
				"and `dethi`.`madethi` = `baithi`.`madethi`";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Exam ex = new Exam();
				
				ex.setMaLopHoc(rs.getInt("malophoc"));
				ex.setTenLopHoc(rs.getString("tenlophoc"));
				ex.setMaDeThi(rs.getInt("madethi"));
				ex.setTenDeThi(rs.getString("tendethi"));
				ex.setThoiGianBatDau(rs.getString("thoigianbatdau"));
				ex.setThoiGianKetThuc(rs.getString("thoigianketthuc"));
				ex.setSoLuongCauHoi(rs.getInt("soluongcauhoi"));
				ex.setThoiGianThi(rs.getInt("thoigianthi"));
				
				list.add(ex);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<CauHoi> displayDSCauHoi_byMaDe(Connection conn, int md){
		
		List<CauHoi> list = new ArrayList<CauHoi>();
		
		String sql = " select `CauHoi_DeThi`.`macauhoi`,`cauhoi`.`noidung`, `cauhoi`.`option1`, `cauhoi`.`option2`, `cauhoi`.`option3`, `cauhoi`.`option4`,`cauhoi`.`dapandung` \r\n" + 
				"from `CauHoi_DeThi`,`cauhoi`\r\n" + 
				"where `CauHoi_DeThi`.`MaCauHoi` = `CauHoi`.`MaCauHoi`\r\n" + 
				"and`MaDeThi` = " + md +"";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			int i = 0;
			
			while(rs.next()) {
				i++;
				CauHoi ch = new CauHoi();
				ch.setSoThuTu(i);
				ch.setMaCauHoi(rs.getInt("MaCauHoi"));
				ch.setNoiDung(rs.getString("NoiDung"));
				ch.setOption1(rs.getString("option1"));
				ch.setOption2(rs.getString("option2"));
				ch.setOption3(rs.getString("option3"));
				ch.setOption4(rs.getString("option4"));
				ch.setDapAnDung(rs.getString("DapAnDung"));

				list.add(ch);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
