package client;

import controller.ProductController;

public class Client {

	public static void main(String[] args) {
		// 지금까지 만든 App을 수행시킬 공간
		// main( )이 존재
		ProductController app = new ProductController();
		
		app.startApp();
		
	}

}
