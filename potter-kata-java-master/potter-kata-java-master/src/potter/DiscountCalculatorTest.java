package potter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class DiscountCalculatorTest {
	DiscountCalculator calculator = null;
	public static final double ERROR_DELTA = 0.001;
	
	@Before
	public void createCalculator() {
		calculator = new DiscountCalculator();
	}
	
	@Test
	public void emptyBasketShouldBeZero() {
		int[] shoppingCart = {};
				
		double result = calculator.calculate(shoppingCart);
		
		assertEquals(result, 0.0, ERROR_DELTA);
	}
	
	@Test
	public void onlyOneBookShouldNotHaveAnyDiscounts() {
		int[] shoppingCart = { 0 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0, ERROR_DELTA);
	}
	
	@Test
	public void twoBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 2 * 0.95, ERROR_DELTA);
	}
	
	@Test
	public void threeBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1, 2 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 3 * 0.9, ERROR_DELTA);
	}
	@Test
	public void fourBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1, 2, 3 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 4 * 0.8, ERROR_DELTA);
	}
	@Test
	public void fiveBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1, 2, 3, 4 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 5 * 0.75, ERROR_DELTA);
	}
	@Test
	public void sixBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 0, 1};
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result,(8 +  (8.0 * 2 * 0.95)), ERROR_DELTA);
	}
}