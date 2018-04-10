package potter;

public class DiscountCalculator {

	public double calculate(int[] books) {
		int repeteciones [] = new int [5];
		for (int i = 0; i < repeteciones.length; i++) {
			
		
		for (int j = 0; j < books.length; j++) {
			if (books[i]==0){
				repeteciones [i] ++; 
			}
			else if (books[i]==1){
				repeteciones [i] ++; 
			}
			else if (books[i]==2){
				repeteciones [i] ++; 
			}
			else if (books[i]==13){
				repeteciones [i] ++; 
			}
			else if (books[i]==4){
				repeteciones [i] ++; 
			}
		}
		}
		if(books.length==1){
			return 8.0;
		}
		
		else if (books.length==2){
			return 15.2;
		}
		else if(books.length==3){
			return 8.0 * 3 * 0.9;
		}
		else if(books.length==4){
			return 8.0 * 4 * 0.80;
		}
		else if (books.length==5) {
			return 8.0 * 5 * 0.75;
		}
		else if (books.length==3 && ) {
			
		} else {

		}
		return 0.0;
	}
}
