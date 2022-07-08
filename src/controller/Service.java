package controller;

import java.util.ArrayList;

import model.ProductVO;

public class Service {
	// [C] : 유효성 검사 1, 2
	public static boolean menuCheck(ArrayList<ProductVO> allMenu) {
		int total = 0; // 전체 재고의 합
		for(int i = 0; i < allMenu.size(); i++) {
			total += allMenu.get(i).getCnt();
		}
		boolean flag1 = allMenu.size() == 0; // 라면 메뉴 목록 비어있을 때
		boolean flag2 = total < 1; // 메뉴가 존재하더라도 모든 메뉴의 재고가 없을 경우
		
		return flag1 || flag2;
	}
}
