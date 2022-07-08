package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

public class ProductView{
	Scanner sc = new Scanner(System.in);
	public int action; //사용자가 입력할 변수

	//사용자모드 첫 화면
	public void startView() {
		while(true) {
			System.out.println("============ Ramen Machine ============");
			System.out.println("[1] 메뉴선택 [2] 종료 [3] 관리자모드");
			System.out.print("입력 : ");
			try {
				action = sc.nextInt();
				if(1<=action && action <=3) {
					break;
				}
				System.out.println("다시 입력해주세요!");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
			}
		}
	}

	//문자열 입력
	public String inputString() {
		while(true) {
			try {
				System.out.print("입력 : ");
				String str = sc.next();
				return str;
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("다시 입력해주세요");
			}
		}
	}

	//정수형 입력 
	public int inputInt() {
		while(true) {
			System.out.print("입력 : ");
			try {
				int num = sc.nextInt();
				return num;
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("다시 입력해주세요");
			}
		}
	}

	// 사용자모드_라면 메뉴 선택 ----------------------------------------
	public void user_RamenMenu(ArrayList<ProductVO> data) {
		if(data.size() == 0) {
			System.out.println("저장된 메뉴가 없습니다.");
			return;
		}
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getCnt() == 0) {
				System.out.println((i+1)+"번 : "+data.get(i).getRamen() + "X");
				continue;
			}
			System.out.println((i+1)+"번 : "+data.get(i).getRamen());
		}
		while(true) {
			System.out.print("메뉴번호 입력 : ");
			try { 
				action=sc.nextInt();
				if (1<=action &&action<=data.size()) {
					break;
				}
				System.out.println("상품번호 확인후 다시입력해주세요!");
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수만 입력해주세요!");
			}
		}
	}

	// 사용자모드_사이드 메뉴 선택 ---------------------------------
	public void user_SideMenu(ArrayList<ProductVO> data){
		if(data.size() == 0) {
			System.out.println("저장된 메뉴가 없습니다.");
			return;
		}
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getCnt() == 0) {
				System.out.println((i+1)+"번 : "+data.get(i).getSide() + "X");
				continue;
			}
			System.out.println((i+1)+"번 : "+data.get(i).getSide());
		}
		while(true) {
			System.out.print("메뉴번호 입력 : ");
			try { 
				action=sc.nextInt();    // 0번 입력 --> 선택 안함
				if (0<=action &&action<=data.size()) {
					break;
				}
				System.out.println("상품번호 확인후 다시입력해주세요!");
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수만 입력해주세요!");
			}
		}
	}
	// 사용자모드_토핑 메뉴 선택 ---------------------------------
		public void user_TopingMenu(ArrayList<ProductVO> data){
			if(data.size() == 0) {
				System.out.println("저장된 메뉴가 없습니다.");
				return;
			}
			for(int i = 0; i < data.size(); i++) {
				if(data.get(i).getCnt() == 0) {
					System.out.println((i+1)+"번 : "+data.get(i).getToping() + "X");
					continue;
				}
				System.out.println((i+1)+"번 : "+data.get(i).getToping());
			}
			while(true) {
				System.out.print("메뉴번호 입력 : ");
				try { 
					action=sc.nextInt();    // 0번 입력 --> 선택 안함
					if (0<=action &&action<=data.size()) {
						break;
					}
					System.out.println("상품번호 확인후 다시입력해주세요!");
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("정수만 입력해주세요!");
				}
			}
		}

	// 사용자모드_물의 양 메뉴 선택 ---------------------------------
	public void user_WaterMenu(ArrayList<ProductVO> data) {
		for(int i = 0; i < data.size(); i++) {
			System.out.println((i+1)+"번 : "+data.get(i).getWater());
		}
		while(true) {
			System.out.print("메뉴번호 입력 : ");
			try { 
				action=sc.nextInt();
				if (1<=action &&action<=data.size()) {
					break;
				}
				System.out.println("상품번호 확인후 다시입력해주세요!");
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수만 입력해주세요!");
			}
		}
	}
	// 사용자모드_매운 맛 메뉴 선택 ---------------------------------
		public void user_SpicyMenu(ArrayList<ProductVO> data) {
			for(int i = 0; i < data.size(); i++) {
				System.out.println((i+1)+"번 : "+data.get(i).getSpicy());
			}
			while(true) {
				System.out.print("메뉴번호 입력 : ");
				try { 
					action=sc.nextInt();
					if (1<=action &&action<=data.size()) {
						break;
					}
					System.out.println("상품번호 확인후 다시입력해주세요!");
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("정수만 입력해주세요!");
				}
			}
		}

	// 사용자모드_메뉴선택 후 선택 안내 문구 (라면, 토핑, 사이드) 
	public void ramen() { 
		System.out.println("====라면 선택====");
	}

	public void toping() { // 토핑은 선택 안함이 가능함 
		System.out.println("====토핑 선택====");
		System.out.println("[0] 선택 안함");
	}

	public void side()  {  // 토핑은 선택 안함이 가능함 
		System.out.println("====사이드 선택====");
		System.out.println("[0] 선택 안함");
	}

	//종료하기
	public void end() {
		System.out.println("프로그램 종료합니다.");
		for(int i=0;i<5;i++) {
			System.out.print(".");
			try {
				Thread.sleep(1); // 1000==1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	//최종 주문한 항목 출력할 멘트 (일단 보류!) 
	//	public void printDatas(ArrayList<ramenVO> datas) { 
	//		System.out.println();
	//		System.out.println("선택하신 메뉴 입니다 :D");
	//		for(ramenVO vo:datas) {
	//			System.out.println("라면 : "+vo.getramen()+"토핑 :" +vo.gettoping()+"맛" + vo.getspicy()+"물의 양"+vo.getwater()+"사이드"+vo.getside());
	//			System.out.println();
	//			ProductVO data2=model.selectOne(vo); // 총액 출력 작업을 v에서할지 C에서할지 선택필요.
	//			int cnt=vo.getCnt();
	//			int price=data2.getPrice();
	//			int total=cnt*price*-1; // cnt가 -이기때문에 -1 곱해준다
	//			System.out.println("총 결제 금액은"+total+"원 입니다.");
	//		}
	//	}


	//매진된 품목 안내 멘트 
	public void soldOut() {
		System.out.println("매진된 품목입니다ㅠ^ㅠ 다른 메뉴를 선택해주세요.");
	}

	//---------------------------관리자모드---------------------

	public void adminView() {
		while(true) {
			System.out.println("[ 관리자모드 ] 에 입장하셨습니다 :D");
			System.out.println("=====관리자 모드=====");
			System.out.println("[1] 메뉴 추가 [2] 메뉴 삭제 [3] 재고 변경 [4] 관리자모드 종료 ");
			System.out.print("관리자 메뉴 선택 : ");
			try {
				action = sc.nextInt();
				if(1<=action && action <=4) {
					break;
				}
				System.out.println("잘못된 입력입니다. 다시 입력해주세요! (1~4) ");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
			}
		}
	}


	//관리자모드_메뉴 추가
	public void admin_addMenu() {
		while(true) {
			System.out.println("추가하실 항목을 선택하세요.");
			System.out.println("[1] 라면 [2] 토핑 [3] 사이드메뉴 [4] 처음으로 돌아가기");
			try {
				action = sc.nextInt();
				if(1<=action && action <=4) {
					break;
				}
				System.out.print("잘못된 입력입니다. 다시 입력해주세요! (1~4)");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
			}
		}
	}
	//관리자모드 메뉴 추가 확인창
	public void admin_selectcheck(String check) {
		System.out.println(check+"을 추가하시겠습니까?");
	}

	//관리자모드_메뉴 삭제
	public void admin_deleteMenu() {
		while(true) {
			System.out.println("삭제하실 항목을 선택하세요.");
			System.out.println("[1] 라면 [2] 토핑 [3] 사이드메뉴 [4] 처음으로 돌아가기");
			try {
				action = sc.nextInt();
				if(1<=action && action <=4) {
					break;
				}
				System.out.println("다시 입력해주세요!");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
			}
		}
	}
	//관리자모드 메뉴 삭제 확인창
	public void admin_deletecheck(int check) {
		System.out.println(check+"을 삭제하시겠습니까?");
	}

	//관리자모드_재고 변경
	public void admin_updateCnt() {
		while(true) {
			System.out.println("재고 변경하실 항목을 선택하세요.");
			System.out.println("[1] 라면 [2] 토핑 [3] 사이드메뉴 [4] 처음으로 돌아가기");
			try {
				action = sc.nextInt();
				if(1<=action && action <=4) {
					break;
				}
				System.out.println("다시 입력해주세요!");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
			}
		}
	}
	//재고 변경 -> 라면
	public void updateRamen(ArrayList<ProductVO> ramen) {
		for (int i = 0; i < ramen.size(); i++) {
			System.out.println((i+1)+"번메뉴"+ramen.get(i).getRamen()+"재고 ["+ramen.get(i).getCnt()+"]");
		}
	}
	//재고 변경 -> 토핑
	public void updateToping(ArrayList<ProductVO> toping) {
		for (int i = 0; i < toping.size(); i++) {
			System.out.println((i+1)+"번메뉴"+toping.get(i).getToping()+"재고 ["+toping.get(i).getCnt()+"]");
		}
	}
	//재고 변경 -> 사이드
	public void updateSide(ArrayList<ProductVO> side) {
		for (int i = 0; i < side.size(); i++) {
			System.out.println((i+1)+"번메뉴"+side.get(i).getSide()+"재고 ["+side.get(i).getCnt()+"]");
		}
	}
	//재고 변경 -> 추가 항목 확인
	public String admin_check() {
		String ans;
		while(true) {
			System.out.println("더 추가하실 항목이 있으십니까?(Y/N)");
			ans = sc.next();
			ans.toUpperCase(); //대문자로 변경
			if(ans.equals("Y") || ans.equals("N")){
				break;
			}
			System.out.println("Y or N만 입력 가능합니다!");
		}
		return ans;
	}

	//관리자모드_프로그램 종료
	public void admin_end() {
		System.out.println("관리자모드를 종료합니다.");
	}

	//수행완료
	public void success() {
		System.out.println("수행 완료했습니다.");
	}
	//수행실패
	public void fail() {
		System.out.println("수행 실패했습니다.");
	}
}