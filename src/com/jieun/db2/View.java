package com.jieun.db2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class View {
	public void view(ArrayList<SelectDTO> ar) {
		for(SelectDTO selectDTO: ar) {
			this.view(selectDTO);
		}
	}
	
	public void view(SelectDTO deptDTO) {
		System.out.println("DEPTNO : "+deptDTO.getDeptno());
		System.out.println("DNAME  : "+deptDTO.getDname());
		System.out.println("LOC    : "+deptDTO.getLoc());
	}

	}



