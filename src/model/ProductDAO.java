
package model;

import java.util.ArrayList;

public class ProductDAO { // DB역할
	ArrayList<ProductVO> ramen; // 라멘리스트
	ArrayList<ProductVO> toping; // 토핑 리스트
	ArrayList<ProductVO> side; // 사이드 리스트
	// ==========================재고량 없는것들===================
	ArrayList<ProductVO> water; // 물양 리스트
	ArrayList<ProductVO> spicy; // 메운맛 리스트
	ArrayList<ProductVO> result; // 결과 저장
	ProductVO allPrice;

	// pk 시스템에서 부여
	private int ramenpk;
	private int topingpk;
	private int sidepk;
	private int waterpk;
	private int spicypk;

	// 생성자
	public ProductDAO() {
		// 리스트 생성
		ramen = new ArrayList<ProductVO>();
		toping = new ArrayList<ProductVO>();
		side = new ArrayList<ProductVO>();
		water = new ArrayList<ProductVO>();
		spicy = new ArrayList<ProductVO>();
		result = new ArrayList<ProductVO>();
		allPrice = new ProductVO();
		// 초기 pk값
		ramenpk = 1;
		topingpk = 1;
		sidepk = 1;
		waterpk = 1;
		spicypk = 1;

		// 샘플 데이터 재고량은 전부 50개로 통일
		ProductVO vo = new ProductVO();
		// 라면
		
		// 1
		vo.setCnt(50);
		vo.setRamen("진라면");
		vo.setNum(ramenpk++);
		// 각 라면 가격또한 추가
		vo.setPrice(1500);
		ramen.add(vo);
		// 2
		vo.setCnt(50);
		vo.setRamen("짜파게티");
		vo.setNum(ramenpk++);
		vo.setPrice(2000);
		ramen.add(vo);
		// 3
		vo.setCnt(50);
		vo.setRamen("너구리");
		vo.setNum(ramenpk++);
		vo.setPrice(1500);
		ramen.add(vo);
		// 4
		vo.setCnt(50);
		vo.setRamen("팔도 비빔면");
		vo.setNum(ramenpk++);
		vo.setPrice(2500);
		ramen.add(vo);

		// 토핑
		// 1
		vo.setCnt(50);
		vo.setToping("계란");
		vo.setNum(topingpk++);
		vo.setPrice(500);
		toping.add(vo);
		// 2
		vo.setCnt(50);
		vo.setToping("치즈");
		vo.setNum(topingpk++);
		vo.setPrice(1000);
		toping.add(vo);
		// 3
		vo.setCnt(50);
		vo.setToping("만두");
		vo.setNum(topingpk++);
		vo.setPrice(1500);
		toping.add(vo);
		// 4
		vo.setCnt(50);
		vo.setToping("김가루");
		vo.setNum(topingpk++);
		vo.setPrice(300);
		toping.add(vo);

		// 사이드
		// 1
		vo.setCnt(50);
		vo.setSide("밥");
		vo.setNum(sidepk++);
		vo.setPrice(1000);
		side.add(vo);
		// 2
		vo.setCnt(50);
		vo.setSide("콜라");
		vo.setNum(sidepk++);
		vo.setPrice(1500);
		side.add(vo);
		// 3
		vo.setCnt(50);
		vo.setSide("핫바");
		vo.setNum(sidepk++);
		vo.setPrice(2000);
		side.add(vo);

		// 매운맛

		// 1
		// vo.setCnt(50); <======= 재고량은 없어도됨, 가격도 마찬가지
		vo.setSpicy("순한맛");
		vo.setNum(spicypk++);
		spicy.add(vo);
		// 2
		vo.setSpicy("보통맛");
		vo.setNum(spicypk++);
		spicy.add(vo);
		// 3
		vo.setSpicy("매운맛");
		vo.setNum(spicypk++);
		spicy.add(vo);

		// 물양 401 부터 시작
		// 1
		vo.setWater("적게");
		vo.setNum(waterpk++);
		water.add(vo);
		// 2
		vo.setWater("보통");
		vo.setNum(waterpk++);
		water.add(vo);
		// 3
		vo.setWater("많이");
		vo.setNum(waterpk++);
		water.add(vo);
		
		
		result.add(vo);
	}

	// CRUD 메서드

	// Create(xxxInsert) //주석은 라멘에만 쓰여져있음
	// 일단 전부 구현했는데 요구분석에서 뭐 빠져야 하는거 같은데 내일 수정 할게요 ㅜㅜ(피곤해요)
	// 라멘 인서트
	public boolean ramenInsert(ProductVO vo) {
		try {
			// 넣을수록 PK값은 1씩 증가 !
			vo.setNum(ramenpk++); // 2. 얘는 시스템에서 부여하니 모델에서 구현
			/*
			 * vo.setName(); 1.이친구들은 컨트롤러에서 구현 vo.setCnt();
			 */
			ramen.add(vo);
			// 이때 넣어줬을시엔 메소드 output이 boolean 이므로 return 값 true
			return true;
			// 어떤 오류가 생길지 모르기때문에 Exception 클래스 활용
		} catch (Exception e) { // 실패시

			e.printStackTrace(); // 어떤 예외인지 출력문구
			System.out.println("로그 : Insert()에서 확인되지 않은 예외 발생 !");
			// 예외가 생겼으므로 false 값으로 반환
			return false;
		}
	}

	// 토핑 인서트
	public boolean topingInsert(ProductVO vo) {
		try {
			vo.setNum(topingpk++);
			toping.add(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그 : Insert()에서 확인되지 않은 예외 발생 !");
			return false;
		}
	}

	// 사이드 인서트
	public boolean sideInsert(ProductVO vo) {
		try {
			vo.setNum(sidepk++);
			side.add(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그 : Insert()에서 확인되지 않은 예외 발생 !");
			return false;
		}
	}

	// 물 인서트
	public boolean waterInsert(ProductVO vo) {
		try {
			vo.setNum(waterpk++);
			water.add(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그 : Insert()에서 확인되지 않은 예외 발생 !");
			return false;
		}
	}

	// 매운맛 인서트
	public boolean spicyInsert(ProductVO vo) {
		try {
			vo.setNum(spicypk++);
			spicy.add(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그 : Insert()에서 확인되지 않은 예외 발생 !");
			return false;
		}
	}

	// CRU'D'
	// Deleate(xxxDelete) //주석은 라멘에만 쓰여져있음
	// 1라멘 딜리트

	public boolean ramenDelete(ProductVO vo) {
		for (int i = 0; i < ramen.size(); i++) { // 라면 pk를 찾기위해 포문 사용
			if (ramen.get(i).getNum() == vo.getNum()) {
				// 라멘번호가 뷰애서 입력한 번호가 맞다면
				ramen.remove(i);
				// 그 라멘번호 가 있는정보(이름 재고 )삭제
				return true; // 트루값 반환 (성공)(함수종료)
			}
		}
		// 제거하지 못햇다면
		// System.out.println("입력한 번호를 잘못입력햇스비낟");<=== 애는 뷰에서 구현
		return false;
	}

	// 2 토핑 딜리트
	public boolean topingDelete(ProductVO vo) {
		for (int i = 0; i < toping.size(); i++) {
			if (toping.get(i).getNum() == vo.getNum()) {
				toping.remove(i);
				return true;
			}
		}
		return false;
	}

	// 3 사이드 딜리트
	public boolean sideDelete(ProductVO vo) {
		for (int i = 0; i < side.size(); i++) {
			if (side.get(i).getNum() == vo.getNum()) {
				side.remove(i);
				return false;
			}
		}
		return true;
	}

	// 4 물딜리트
	public boolean waterDelete(ProductVO vo) {
		for (int i = 0; i < water.size(); i++) {
			if (water.get(i).getNum() == vo.getNum()) {
				water.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5 매운맛 딜리트
	public boolean spicyDelete(ProductVO vo) {
		for (int i = 0; i < spicy.size(); i++) {
			if (spicy.get(i).getNum() == vo.getNum()) {
				spicy.remove(i);
				return true;
			}
		}
		return false;
	}
	// CR'U'D
	// 업데이트는 cnt (재고량) 변화를 줄때 사용
	// Update(xxxUpdate) //주석은 라멘에만 쓰여져있음
	// 1라멘 업뎃

	// 가격까지 고려했을때 재고수를 빼야하지 않나.. 요거 고려해보기

	public boolean ramenUpdate(ProductVO vo) {
		for (ProductVO data : ramen) { // 포 이치 문으로 리스트를 data에 저장
			if (data.getNum() == vo.getNum()) { // 저장된 번호와 입력한 번호가 같다면
				data.setCnt(data.getCnt() + vo.getCnt());// 입력한 재고수 만큼 추가
				return true; // 참값을 반환후 메서드 종료
			}
		}
		return false;
	}

	// 2. 사이드 업뎃
	public boolean sideUpdate(ProductVO vo) {
		for (ProductVO data : side) {
			if (data.getNum() == vo.getNum()) {
				data.setCnt(data.getCnt() + vo.getCnt());
				return true;
			}
		}
		return false;
	}

	// 3 토핑 없덱
	public boolean topingUpdate(ProductVO vo) {
		for (ProductVO data : toping) {
			if (data.getNum() == vo.getNum()) {
				data.setCnt(data.getCnt() + vo.getCnt());
				return true;
			}
		}
		return false;
	}

	// 물양이나 매운맛은 재고가 없으니 미구현

	// C'R'UD ==read
	// select는 selcetOne selcetOne 으로 나뉨
	// 요 위에 주석이 selectOne 이랑 selectAll 이라고 쓰신건지는 모르겠지만..
	// selectxxx(xxxselectxxxx) //주석은 라멘에만 쓰여져있음
//=========================내일 하자 =====================================

	// selectOne 각 품목별로 구현
	public ProductVO ramenselectOne(ProductVO vo) {
		// foreach 문을 활용해 ramen 배열리스트를 각각 data로 치환
		for (ProductVO data : ramen) {
			// 만약 data 키값과 vo 키값이 같다면
			if (data.getNum() == vo.getNum()) {
				// data 값을 하나 반환한다.
				return data;
			}
		}
		return null;

	}

	public ProductVO topingselectOne(ProductVO vo) {
		for (ProductVO data : toping) {
			// 만약 data 키값과 vo 키값이 같다면
			if (data.getNum() == vo.getNum()) {
				// data 값을 하나 반환한다.
				return data;
			}
		}
		return null;
	}

	public ProductVO sideselectOne(ProductVO vo) {
		for (ProductVO data : side) {
			// 만약 data 키값과 vo 키값이 같다면
			if (data.getNum() == vo.getNum()) {
				// data 값을 하나 반환한다.
				return data;
			}
		}
		return null;
	}

	public ProductVO waterselectOne(ProductVO vo) {
		for (ProductVO data : water) {
			// 만약 data 키값과 vo 키값이 같다면
			if (data.getNum() == vo.getNum()) {
				// data 값을 하나 반환한다.
				return data;
			}
		}
		return null;
	}

	public ProductVO spicyselectOne(ProductVO vo) {
		for (ProductVO data : spicy) {
			// 만약 data 키값과 vo 키값이 같다면
			if (data.getNum() == vo.getNum()) {
				// data 값을 하나 반환한다.
				return data;
			}
		}
		return null;
	}

	public ArrayList<ProductVO> ramenselectAll(ProductVO vo) {
        // vo에 이름이 있다면 즉 검색을 이용했다면
        if (vo.getRamen() != null) {
            // 검색 [서비스]
            // 검색 결과를 돌려주겠다.
            ArrayList<ProductVO> ramen = new ArrayList<ProductVO>();
            for (int i = 0; i < this.ramen.size(); i++) {
                // 원래 있던 이름과 방금 검색할때 받은 이름을 비교한다.
                if (this.ramen.get(i).getRamen().equals(vo.getRamen())) {
                    // 같다라는 결론이 나오면 추가한다.
                    ramen.add(this.ramen.get(i));
                }
            }
            return ramen;
        }
        return this.ramen;
    }

	public ArrayList<ProductVO> topingselectAll(ProductVO vo) {
		// vo에 이름이 있다면 즉 검색을 이용했다면
		if (vo.getToping() != null) {
			// 검색 [서비스]
			// 검색 결과를 돌려주겠다.
			ArrayList<ProductVO> toping = new ArrayList<ProductVO>();
			for (int i = 0; i < this.toping.size(); i++) {
				// 원래 있던 이름과 방금 검색할때 받은 이름을 비교한다.
				if (this.toping.get(i).getToping().equals(vo.getToping())) {
					// 같다라는 결론이 나오면 추가한다.
					toping.add(this.toping.get(i));
				}
			}
			return toping;
		}
		return this.toping;
	}

	public ArrayList<ProductVO> sideselectAll(ProductVO vo) {
		// vo에 이름이 있다면 즉 검색을 이용했다면
		if (vo.getSide() != null) {
			// 검색 [서비스]
			// 검색 결과를 돌려주겠다.
			ArrayList<ProductVO> side = new ArrayList<ProductVO>();
			for (int i = 0; i < this.side.size(); i++) {
				// 원래 있던 이름과 방금 검색할때 받은 이름을 비교한다.
				if (this.side.get(i).getSide().equals(vo.getSide())) {
					// 같다라는 결론이 나오면 추가한다.
					side.add(this.side.get(i));
				}
			}
			return side;
		}
		return this.side;
	}

	public ArrayList<ProductVO> waterselectAll(ProductVO vo) {
		// vo에 이름이 있다면 즉 검색을 이용했다면
		if (vo.getWater() != null) {
			// 검색 [서비스]
			// 검색 결과를 돌려주겠다.
			ArrayList<ProductVO> water = new ArrayList<ProductVO>();
			for (int i = 0; i < this.water.size(); i++) {
				// 원래 있던 이름과 방금 검색할때 받은 이름을 비교한다.
				if (this.ramen.get(i).getWater().equals(vo.getWater())) {
					// 같다라는 결론이 나오면 추가한다.
					water.add(this.water.get(i));
				}
			}
			return water;
		}
		return this.water;
	}

	public ArrayList<ProductVO> spicyselectAll(ProductVO vo) {
		// vo에 이름이 있다면 즉 검색을 이용했다면
		if (vo.getSpicy() != null) {
			// 검색 [서비스]
			// 검색 결과를 돌려주겠다.
			ArrayList<ProductVO> spicy = new ArrayList<ProductVO>();
			for (int i = 0; i < this.spicy.size(); i++) {
				// 원래 있던 이름과 방금 검색할때 받은 이름을 비교한다.
				if (this.ramen.get(i).getSpicy().equals(vo.getSpicy())) {
					// 같다라는 결론이 나오면 추가한다.
					spicy.add(this.spicy.get(i));
				}
			}
			return spicy;
		}
		return this.spicy;
	}
}