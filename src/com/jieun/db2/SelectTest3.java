package com.jieun.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest3 {
	public static void main(String[] args) {
		//사원의 이름과, 1년연봉을 조회
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select ename,(12*sal)+nvl(comm,0) from emp";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println("=============================");
				System.out.println("ename :"+rs.getString("ename"));
				System.out.println("sal : "+rs.getInt("(12*sal)+nvl(comm,0)"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally// 예외가 발생하던지 안하던지간에 무조건 하세요
*/		
	}
}
