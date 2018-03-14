package com.jieun.db3;

import java.util.Scanner;

public class Input {
	private Scanner sc;
	public Input() {
		sc= new Scanner(System.in);
	}

	public void input(DeptDTO deptDTO) {
		System.out.println("부서번호를 입력:");
		deptDTO.setDeptno(sc.nextInt());
		System.out.println("부서명을 입력");
		deptDTO.setDname(sc.next());
		System.out.println("지역명을 입력");
		deptDTO.setLoc(sc.next());
		
		
	}
}
