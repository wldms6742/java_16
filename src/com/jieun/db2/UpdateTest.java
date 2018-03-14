package com.jieun.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		//부서번호와 지역명을 입력 받아 수정
		System.out.println("부서번호를 입력:");
		Scanner sc = new Scanner(System.in);
		int deptno = sc.nextInt();
		System.out.println("수정할 지역명 입력:");
		String loc = sc.next();
		
		String user = "scott";
		String password="tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			String sql = "update dept set loc=? where deptno=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, loc);
			st.setInt(2, deptno);
			
			int result = st.executeUpdate();
			
			if(result>0) {
				System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
