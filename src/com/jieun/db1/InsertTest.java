package com.jieun.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		//1. 접속정보
		int deptno = 70;
		String dname = "sales";
		String dloc = "la";
		String user="scott";
		String password="tiger";
		//SID
		//Express Edition : xe
		//orcl
		String url="jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		/*System.out.println("입력하세요");
		Scanner sc  = new Scanner(System.in);
		String text = sc.nextLine();
		*/
		try {
		//2. 드라이버를 메모리에 로딩	
			Class.forName(driver);
			//클래스를 driver이름으로 생성하겠다
		//3. Connection 연결
			Connection con = DriverManager.getConnection(url, user, password);
		// url, user, password로 con의 ip로가서 연결한다
		//4. Sql문 생성
			String sql = "insert into dept values("+deptno+","+"'"+dname+"'"+","+"'"+dloc+"')"; // cmd창을 이용해 쓰는 것을 그대로 써줘야한다
			System.out.println(sql); 
			//sql문을 쿼리로 바꿔줌
		//5. Statement 생성 및 준비
			Statement st = con.createStatement();
		
		//6. 전송
			int result=st.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

