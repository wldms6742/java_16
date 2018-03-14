package com.jieun.db3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class View {
	public void view(ArrayList<DeptDTO> ar) {
		for(DeptDTO selectDTO: ar) {
			this.view(selectDTO);
		}
	}
/*	public void view(ArrayList<Object> ar) {
		for(Object obj : ar) {
			if(obj instanceof DeptDTO) { //객체타입입니까:instanceof
				DeptDTO deptDTO = (DeptDTO)obj;
				this.view(deptDTO);
				
			}else {
				EmpDTO empDTO = (EmpDTO)obj;
				this.view
			}
			
		}
	}
*/	public void view_emp(ArrayList<EmpDTO> ar) {
	for(EmpDTO empDTO : ar) {
		this.view_emp(empDTO);
	}
}
	public void view_emp(EmpDTO empDTO) {
		System.out.println("EMPNO : "+empDTO.getEmpno());
		System.out.println("ENAME : "+empDTO.getEname());
		System.out.println("JOB   : "+empDTO.getJob());
		System.out.println("MGR   : "+empDTO.getMgr());
		System.out.println("HIREDATE : "+empDTO.getHiredate());
		System.out.println("SAL :"+empDTO.getSal());
		System.out.println("COMM : "+empDTO.getComm());
		System.out.println("DEPTNO : "+empDTO.getDeptno());
	}
	public void view(String str) {
		System.out.println(str);
	}
	
	public void view(DeptDTO deptDTO) {
		System.out.println("DEPTNO : "+deptDTO.getDeptno());
		System.out.println("DNAME  : "+deptDTO.getDname());
		System.out.println("LOC    : "+deptDTO.getLoc());
	}

	}



