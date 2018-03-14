package com.jieun.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTest {

	public static void main(String[] args) {
	//1.정보저장
		View v = new View();
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		SelectDTO dto = new SelectDTO();
		ArrayList<SelectDTO> ar = new ArrayList<>();
	//2.로딩
		try {
			Class.forName(driver);
	//3.connection
			 con = DriverManager.getConnection(url, user, password);
	//4.SQL문 생성
			String sql = "select * from dept";
	//5.미리전송
			st = con.prepareStatement(sql);
	//6.?
	//7.최종전송 후 처리
			rs = st.executeQuery();//DML
		
			//한줄씩 읽는 것을 반복
			/*while(rs.next()) //한줄읽었을때 데이터가 있으면 true 없으면 false
			{
				System.out.println("======================");
				System.out.println("DEPTNO   : "+rs.getInt("deptno"));//컬럼명(데이터베이스의 컬럼명과 같아야한다)
				System.out.println("DNAME    : "+rs.getString("dname"));//순서 바껴도 상관x
				System.out.println("LOC      : "+rs.getString("loc"));
				
			}*/
		/*	while(rs.next()) //한줄읽었을때 데이터가 있으면 true 없으면 false
			{
				System.out.println("======================");
				System.out.println("DEPTNO   : "+rs.getInt(1));//인덱스번호
				System.out.println("DNAME    : "+rs.getString(2));//순서 바껴도 상관x
				System.out.println("LOC      : "+rs.getString(3));
				
			}*/
			while(rs.next()) {
			dto.setDeptno(rs.getInt("deptno"));
			dto.setDname(rs.getString("dname"));
			dto.setLoc(rs.getString("loc"));
			ar.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			v.view(ar);
			
		}

	}



