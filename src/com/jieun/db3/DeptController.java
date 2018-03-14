package com.jieun.db3;

import java.util.ArrayList;
import java.util.Scanner;

public class DeptController {
	private Scanner sc;
	private DeptDAO dao;
	private Input input;
	private View view;
	public DeptController() {
		sc = new Scanner(System.in);
		dao = new DeptDAO();
		input = new Input();
		view = new View();
	}
	public void start() throws Exception {
		while(true) {
			System.out.println("1.부서추가");
			System.out.println("2.부서조회");
			System.out.println("3.종    료");
			int select = sc.nextInt();
			
			if(select==1) {
				DeptDTO dto = new DeptDTO();
				input.input(dto);
				select = dao.insert(dto);
				if(select>0) {
					view.view("성공");
				}else {
					view.view("실패");
				}
			}else if(select==2) {
				ArrayList<DeptDTO> ar = dao.selectAll();
				view.view(ar);
			}else {
				break;
			}
		}
	}
}
