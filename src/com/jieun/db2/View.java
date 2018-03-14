package com.jieun.db2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class View {
	public void view(SelectDTO dto) {
		
			System.out.println("=====================");
			System.out.println("DEPTNO :"+dto.getDeptno());
			System.out.println("DNAME  :"+dto.getDname());
			System.out.println("LOC    :"+dto.getLoc());
	
	}
	public void view(ArrayList<SelectDTO> ar) {
		for(SelectDTO dto : ar) {
			this.view(ar);
		}
	}



}