package com.jieun.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {

	public static void main(String[] args) {
		//1.정보를 저장, id ,password, url
		int deptno = 60;
		String dname = "HR";
		String loc = "HAWAII";
		String user="scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		//@localhost : 본인컴퓨터의 ip주소 
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2.드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
		//3.커넥션
			Connection con = DriverManager.getConnection(url, user, password);
		//4.sql문 생성
			String sql = "insert into dept values(?,?,?)";
		//5.PreparedStatement
			PreparedStatement st = con.prepareStatement(sql);
		//6.?에 대한 값을 전송 준비
			st.setInt(1, deptno);//oracle에서 인덱스번호는 1부터시작
			st.setString(2, dname);
			st.setString(3, loc);
			//앞뒤로 ''넣는것은 알아서 처리됨
		//7.전송 후 처리
			int result = st.executeUpdate();//위에만 보내면 되기때문에 매개변수 안줌,dml
			if(result>0) {
				System.out.println("입력 성공");
				
			}else {
				System.out.println("입력 실패");
			}
		} catch (Exception e) { //class와 con에서 exception발생 하므로 상위 계층인 expception e
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
