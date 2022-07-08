package controller;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;
import view.ProductView;

public class ProductController {
	private ProductDAO model;
	private ProductView view;

	public ProductController() {
		model = new ProductDAO();
		view = new ProductView();
	}

	// 1. 처음으로 돌아가기 기능 누락
	// 2. 메뉴 선택시 재확인 기능 누락
	// 3. 가격 책정 기능 진행 예정



	public void startApp() {
		while(true) {
			view.startView();  // 1) 메뉴 선택		2) 프로그램 종료	3) 관리자모드
			if(view.action == 1) {	// 1) 메뉴 선택

				// 라면선택(필수) --> 물의 양 선택(필수) --> 매운 맛 정도 선택(필수) --> 토핑 선택(미선택 가능) --> 사이드메뉴 선택(미선택 가능) --> 주문완료
				ArrayList<ProductVO> allMenu = null;

				ProductVO vo = new ProductVO();		
				allMenu = model.ramenselectAll(vo); // 전체 라면 메뉴

				// [C] : 유효성 검사 1, 2 -- 메뉴 목록 비어있거나, 모든 메뉴 재고X
				if(Service.menuCheck(allMenu)) { 
					view.soldOut(); // 재고부족 메시지
					continue;
				} // 라면 선택은 필수 --> 선택할 수 없다면 더 이상 진행 불가


				// [C] : 유효성 검사3
				while(!Service.menuCheck(allMenu)) { // 재고 있는 메뉴 선택할 때까지 반복
					view.user_RamenMenu(allMenu); // 라면 메뉴 목록 출력
					// 라면 고르고
					// 사용자 입력 --> PK로 전환 후 저장
					vo.setNum(allMenu.get(view.action - 1).getNum());
					vo.setCnt(-1); // 재고 -1 감소 
					if(model.ramenselectOne(vo).getCnt() != 0) {  // 선택한 메뉴 PK 검색
						break;					  				  // 재고 있으면 다음으로
					}	
					view.soldOut();		// 선택한 메뉴가 재고 없을 때
				} 


				// 장바구니 추가 기능????★★★★★★★★★★★★★★★★★★★★★★★★
				if(!model.ramenUpdate(vo)) { // 라면 선택 실패 (라면, 물의 양, 매운맛은 반드시 한 가지를 선택해야)
					view.fail();			 // 굉장히 큰 영향 --> 사용자 결제 금액에 영향을 줄 수 있기 때문에
					continue;				// 처음으로 돌아가기
				}
				// 라면 선택 성공 --> 매운맛 선택
				view.success();

				// 매운맛, 물의양 장바구니에 담는가?????????????????

				do { // [C] 유효성검사 : 선택한 매운 맛 정도가 실제 메뉴에 존재하는지 
					vo = new ProductVO();	allMenu = model.spicyselectAll(vo);
					view.user_SpicyMenu(allMenu); // 매운맛 목록
					vo.setNum(allMenu.get(view.action - 1).getNum());
				} while(model.spicyselectOne(vo) == null);


				do { // [C] 유효성검사 : 선택한 물의 양 정도가 실제 메뉴에 존재하는지 
					vo = new ProductVO();	allMenu = model.waterselectAll(vo);
					view.user_WaterMenu(allMenu); // 매운맛 목록
					vo.setNum(allMenu.get(view.action - 1).getNum());
				} while(model.waterselectOne(vo) == null);


				// 라면 선택 성공 --> 토핑 선택 -------------------------------------------------------------------
				vo = new ProductVO();	vo.setNum(0); // PK변화가 없다면(num(PK) == 0) 미선택
				allMenu = model.topingselectAll(vo);

				// [C] : 유효성 검사1, 2 -- 메뉴 목록 비어있거나, 모든 메뉴 재고X
				if(Service.menuCheck(allMenu)) { 
					view.soldOut(); // 재고부족 메시지
				}		// 토핑 선택은 필수XXX, num(PK) == 0 --> 미선택으로 간주 --> 다음으로 진행


				// 토핑, 사이드메뉴는 사용자의 기호에 따라 미선택 가능(미선택 : 0번 입력)
				while(!Service.menuCheck(allMenu)) {// 재고 있는 메뉴 선택할 때까지 반복 
					view.user_TopingMenu(allMenu); // 토핑 목록 출력

					// 토핑 고르고
					// 사용자 입력 --> PK로 전환 후 저장
					if(view.action == 0) { // 토핑 선택안했을 때 --> num(PK) == 0
						break;
					}

					vo.setNum(allMenu.get(view.action - 1).getNum());
					vo.setCnt(-1); // 재고 -1 감소 
					if(model.topingselectOne(vo).getCnt() != 0) { // 선택한 메뉴 재고 있으면 다음으로
						break;	  	
					}	
					view.soldOut();						
				} 


				if(!model.topingUpdate(vo)) {	// 토핑 선택을 실패했는데
					if(!(vo.getNum() == 0)) {	// 토핑 미선택도 아닌 경우
						view.fail();			// 무엇인가 큰 오류 발생
						continue;				// --> 다시 처음으로	
					}
				}	

				// 토핑 선택 성공 --> 사이드 메뉴 선택--------------------------------------------------------------------
				view.success();
				// 장바구니???????????????????
				vo = new ProductVO();	vo.setNum(0); // PK변화가 없다면(num(PK) == 0) 미선택
				allMenu = model.sideselectAll(vo);

				// [C] : 유효성 검사1, 2 -- 메뉴 목록 비어있거나, 모든 메뉴 재고X
				if(Service.menuCheck(allMenu)) { 
					view.soldOut(); // 재고부족 메시지
				}		// 사이드 메뉴 선택은 필수XXX, num(PK) == 0 --> 미선택으로 간주 --> 다음으로 진행


				// 토핑, 사이드메뉴는 사용자의 기호에 따라 미선택 가능(미선택 : 0번 입력)
				while(!Service.menuCheck(allMenu)) { // 재고 있는 메뉴 선택할 때까지 반복 
					view.user_SideMenu(allMenu); // 사이드메뉴 목록 출력

					if(view.action == 0) { // 사이드메뉴 선택안했을 때 --> num(PK) == 0
						break;
					}
					// 사이드 메뉴 고르고
					// 사용자 입력 --> PK로 전환 후 저장
					vo.setNum(allMenu.get(view.action - 1).getNum());
					vo.setCnt(-1); // 재고 -1 감소 
					if(model.sideselectOne(vo).getCnt() != 0) { // 선택한 메뉴 재고 있으면 다음으로
						break;	  	
					}	
					view.soldOut();						
				} 

				if(!model.sideUpdate(vo)) {		// 사이드 선택을 실패했는데
					if(!(vo.getNum() == 0)) {	// 사이드 미선택도 아닌 경우
						view.fail();			// 무엇인가 큰 오류 발생
						continue;				// --> 다시 처음으로	
					}
				}	
				// 사이드 메뉴 선택 성공 --> 주문 완료
				view.success();
				// 장바구니????????????????
				// 주문 결과, 총 가격 사용자에게 보여주는 기능 추가?????????????????


			}

			else if(view.action == 2) { // 2) 프로그램 종료
				view.end();
				break;
			}

			//			else if(view.action == 3) { // 3) 관리자 모드 : 임환욱 담당
			//				
			//			}
		}

	}
}

