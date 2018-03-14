package com.jieun.db3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*	 new DeptController().start();*/
	 EmpDAO dao = new EmpDAO();
	 View v = new View();
	 ArrayList<EmpDTO> ar = dao.selectAll(); 
	 v.view_emp(ar);
	}

}
