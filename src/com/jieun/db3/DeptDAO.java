package com.jieun.db3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
	//추가하는 메서드 - insert
	public int insert(DeptDTO deptDTO) throws Exception{
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into dept values(?,?,?)";
		PreparedStatement st  = con.prepareStatement(sql);
		st.setInt(1, deptDTO.getDeptno());
		st.setString(2, deptDTO.getDname());
		st.setString(3, deptDTO.getLoc());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;


	}
	//전체조회 -select
	public ArrayList<DeptDTO> selectAll() throws Exception{
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from dept";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<DeptDTO> ar  = new ArrayList<>();
		
		while(rs.next()) {
			DeptDTO deptDTO = new DeptDTO();
			deptDTO.setDeptno(rs.getInt("deptno"));
			deptDTO.setDname(rs.getString("dname"));
			deptDTO.setLoc(rs.getString("loc"));
			ar.add(deptDTO);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
