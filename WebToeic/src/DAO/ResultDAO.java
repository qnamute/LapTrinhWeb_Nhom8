package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Result;

public class ResultDAO {
	
	public static List<Result> disPlayResult_byStudent(Connection conn, String username){
		
		List<Result> list = new ArrayList<Result>();
		String sql = "select * from result where `tendangnhap` = '"+username+"'";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				Result r = new Result();
				
				r.setTenDangNhap(rs.getString("tendangnhap"));
				r.setMaDe(rs.getInt("madethi"));
				r.setCorrect(rs.getInt("correct"));
				r.setIncorrect(rs.getInt("incorrect"));
				r.setAnswernull(rs.getInt("answernull"));
				
				list.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertResult(Connection conn, Result rs) {
		String sql = "INSERT INTO `webdatabase`.`result` (`tendangnhap`, `MaDeThi`,`correct`,`incorrect`,`answernull`) VALUES (? ,? ,? ,? ,?)";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, rs.getTenDangNhap());
			ptmt.setInt(2, rs.getMaDe());
			ptmt.setInt(3, rs.getCorrect());
			ptmt.setInt(4, rs.getIncorrect());
			ptmt.setInt(5, rs.getAnswernull());
			
			ptmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
