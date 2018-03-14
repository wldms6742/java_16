package com.jieun.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
	//부서번호를 입력 받아서 해당 부서 정보를 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력 :");
		int deptno = sc.nextInt();
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from dept where deptno=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, deptno);
			ResultSet rs = st.executeQuery();
			/*if(rs.next()) {
				System.out.println("DEPTNO : "+rs.getInt("deptno"));
				System.out.println("DNAME  : "+rs.getString("dname"));
				System.out.println("LOC    : "+rs.getString("loc"));
				
			}*/
			View view = new View();
			SelectDTO dto = new SelectDTO();
			if(rs.next()) {
				//view에서 출력
				//매개변수로 rs사용 X
				dto.setDeptno(rs.getInt(1));
				dto.setDname(rs.getString(2));
				dto.setLoc(rs.getString(3));
				
				view.view(dto);
			
				
			}else {
				System.out.println("해당번호의 부서가 없습니다");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
