package com.jieun.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 도시명 입력");
		String city = sc.next();
		String user = "scott";
		String password = "tiger";
		
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "update dept set loc="+"'"+city+"'"+" where deptno=30";
		
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
