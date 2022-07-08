package model;

public class ProductVO {
	private int num; 		// PK
	private String ramen;	// 이름
	private String toping;	// 이름
	private String side;	// 이름
	private String water;	// 이름
	private String spicy;	// 이름
	private int cnt;		// 재고량
	private int price;		// 가격 
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRamen() {
		return ramen;
	}
	public void setRamen(String ramen) {
		this.ramen = ramen;
	}
	public String getToping() {
		return toping;
	}
	public void setToping(String toping) {
		this.toping = toping;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getSpicy() {
		return spicy;
	}
	public void setSpicy(String spicy) {
		this.spicy = spicy;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", ramen=" + ramen + ", toping=" + toping + ", side=" + side + ", water="
				+ water + ", spicy=" + spicy + ", cnt=" + cnt + ", price=" + price + "]";
	}
	
	
	
		
	
	
}