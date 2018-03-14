package com.jieun.db3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDAO {
	/*public void insert(EmpDTO empDTO) throws Exception{
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, empDTO.getEmpno());
		st.setString(2, empDTO.getEname());
		st.setString(3,empDTO.getJob());
		st.setInt(4,empDTO.getMgr());
		st.setDate(5, empDTO.getHiredate());
		st.setInt(6, empDTO.getSal());
		st.setInt(7, empDTO.getComm());
		st.setInt(8, empDTO.getDeptno());
				
		
	}*/
	public ArrayList<EmpDTO> selectAll() throws Exception{
		EmpDTO empDTO = new EmpDTO();
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from emp";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<EmpDTO> ar = new ArrayList<>();
		while(rs.next()) {
			empDTO.setEmpno(rs.getInt("empno"));
			empDTO.setEname(rs.getString("ename"));
			empDTO.setJob(rs.getString("job"));
			empDTO.setHiredate(rs.getDate("hiredate"));
			empDTO.setMgr(rs.getInt("mgr"));
			empDTO.setSal(rs.getInt("sal"));
			empDTO.setComm(rs.getInt("comm"));
			empDTO.setDeptno(rs.getInt("deptno"));
			ar.add(empDTO);
		}
		return ar;
		
		
	}
}
