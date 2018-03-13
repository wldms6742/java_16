package com.jieun.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "delete dept where deptno=50";
			
			Statement st = conn.createStatement();
			
			int result = st.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("성공");
				}else {
					System.out.println("실패");
						}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
