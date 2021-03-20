package fraction;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	double delta;

	@BeforeEach
	public void setUp() {
		this.delta = 0.000001;
	}

	@Test
	void testFraction() {
		
		//test 1
		Fraction fraction = new Fraction(4, 16);
		assertEquals(4, fraction.numerator);
		assertEquals(16, fraction.denominator);
		
		//test 2
		fraction = new Fraction(4, -16);
		assertEquals(-4, fraction.numerator);
		assertEquals(16, fraction.denominator);
		
		//test 3
		fraction = new Fraction(0, -100);
		assertEquals(0, fraction.numerator);
		assertEquals(100, fraction.denominator);
		
		//test 4
		fraction = new Fraction(-1, -2);
		assertEquals(1, fraction.numerator);
		assertEquals(2, fraction.denominator);		
		
	}
	

	
	@Test
	void testFindDivisors() {
		//test 1
		int num = 8;
		ArrayList<Integer> res = Fraction.findDivisors(num);		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(4);
		list.add(2);
		list.add(1);
		
		assertEquals(res, list);
		
		//test 2
		num = 7;
		res = Fraction.findDivisors(num);
		list = new ArrayList<Integer>();
		list.add(7);
		list.add(1);
		assertEquals(res, list);
		
		//test 3
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		assertNotEquals(res, list);
		
		//test 4
		num = 10;
		res = Fraction.findDivisors(num);
		list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(2);
		list.add(1);
		assertEquals(res, list);
		
	}
	

	
	@Test
	void testReduceToLowestForm() {
		//test 1
		Fraction fraction = new Fraction(4, 16);
		fraction.reduceToLowestForm();
		
		assertEquals(1, fraction.numerator);
		assertEquals(4, fraction.denominator);
		
		//test 2
		fraction = new Fraction(0, 4);
		fraction.reduceToLowestForm();
		
		assertEquals(0, fraction.numerator);
		assertEquals(1, fraction.denominator);
		
		//test 3
		fraction = new Fraction(-50, -300);
		fraction.reduceToLowestForm();
		
		assertEquals(1, fraction.numerator);
		assertEquals(6, fraction.denominator);
		
		//test 4
		fraction = new Fraction(320, 240);
		fraction.reduceToLowestForm();
		assertEquals(4, fraction.numerator);
		assertEquals(3, fraction.denominator);
		
		//test 5
		fraction = new Fraction(10, -15);
		fraction.reduceToLowestForm();
		assertEquals(-2, fraction.numerator);
		assertEquals(3, fraction.denominator);		
		
	}
	
	@Test
	void testAdd() {
		//test 1
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.add(fraction2);
		assertEquals(9, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		//test 2
		fraction1 = new Fraction(3, 7);
		fraction2 = new Fraction(2, 7);
		newFraction = fraction1.add(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(7, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		//test 3
		fraction1 = new Fraction(3, 5);
		fraction2 = new Fraction(1, 4);
		newFraction = fraction1.add(fraction2);
		assertEquals(17, newFraction.numerator);
		assertEquals(20, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		//test 4
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, -3);
		newFraction = fraction1.add(fraction2);
		assertEquals(-7, newFraction.numerator);
		assertEquals(6, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
	}

	@Test
	void testSubtract() {
		
		//test 1
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.subtract(fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		
		//test 2
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(2, newFraction.numerator);
		assertEquals(9, newFraction.denominator);
		
		//test 3
		fraction1 = new Fraction(3, 4);
		fraction2 = new Fraction(5, 32);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(19, newFraction.numerator);
		assertEquals(32, newFraction.denominator);
		
		//test 4
		fraction1 = new Fraction(1, 7);
		fraction2 = new Fraction(1, 6);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(42, newFraction.denominator);
		
	}

	@Test
	void testMul() {
		
		//test 1
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.mul(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(64, newFraction.denominator);
		
		//test 2
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.mul(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(27, newFraction.denominator);
		
		//test 3
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.mul(fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(3, newFraction.denominator);
		
		//test 4
		fraction1 = new Fraction(-1, 10);
		fraction2 = new Fraction(2, 20);
		newFraction = fraction1.mul(fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(100, newFraction.denominator);
		
	}

	@Test
	void testDiv() {
		//test 1
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.div(fraction2);
		assertEquals(4, newFraction.numerator);
		assertEquals(5, newFraction.denominator);
		
		//test 2
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.div(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(3, newFraction.denominator);
		
		//test 3
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.div(fraction2);
		assertEquals(3, newFraction.numerator);
		assertEquals(4, newFraction.denominator);
		
		//test 4
		fraction1 = new Fraction(7, 8);
		fraction2 = new Fraction(1, 5);
		newFraction = fraction1.div(fraction2);
		assertEquals(35, newFraction.numerator);
		assertEquals(8, newFraction.denominator);
				
	}

	@Test
	void testDecimal() {
		//test 1
		Fraction fraction1 = new Fraction(4, 16);
		double dec = fraction1.decimal();
		assertEquals(.25, dec, this.delta);
		
		//test 2 
		fraction1 = new Fraction(5, 16);
		dec = fraction1.decimal();
		assertEquals(.3125, dec, this.delta);
		
		//test 3
		fraction1 = new Fraction(-2, 4);
		dec = fraction1.decimal();
		assertEquals(-.5, dec, this.delta);
		
		//test 4
		fraction1 = new Fraction(1, 3);
		dec = fraction1.decimal();
		assertEquals(.3333333333333333, dec, this.delta);
		
	}

	@Test
	void testSqr() {
		//test 1
		Fraction fraction1 = new Fraction(2, 3);
		fraction1.sqr();
		assertEquals(4, fraction1.numerator);
		assertEquals(9, fraction1.denominator);
		
		//test 2
		fraction1 = new Fraction(4, 16);
		fraction1.sqr();
		assertEquals(1, fraction1.numerator);
		assertEquals(16, fraction1.denominator);
		
		//test 3
		fraction1 = new Fraction(-1, 5);
		fraction1.sqr();
		assertEquals(1, fraction1.numerator);
		assertEquals(25, fraction1.denominator);
		
		//test 4
		fraction1 = new Fraction(0, 4);
		fraction1.sqr();
		assertEquals(0, fraction1.numerator);
		assertEquals(1, fraction1.denominator);		
				
	}

	@Test
	void testEquals() {
		//test 1
		Fraction fraction1 = new Fraction(2, 3);
		Fraction fraction2 = new Fraction(2, 3);
		assertEquals(fraction1, fraction2);
		
		//test 2
		fraction1 = new Fraction(4, 16);
		fraction2 = new Fraction(1, 4);
		assertEquals(fraction1, fraction2);
		
		//confirm the fractions were not (permanently) reduced to lowest form
		assertEquals(4, fraction1.numerator);
		assertEquals(16, fraction1.denominator);
		assertEquals(1, fraction2.numerator);
		assertEquals(4, fraction2.denominator);
		
		//test 3
		fraction1 = new Fraction(3, 9);
		fraction2 = new Fraction(1, 3);
		assertEquals(fraction1, fraction2);
		
		//confirm the fractions were not (permanently) reduced to lowest form
		assertEquals(3, fraction1.numerator);
		assertEquals(9, fraction1.denominator);
		assertEquals(1, fraction2.numerator);
		assertEquals(3, fraction2.denominator);
		
		//test 4
		fraction1 = new Fraction(0, 16);
		fraction2 = new Fraction(0, 100);
		assertEquals(fraction1, fraction2);
		
		//confirm the fractions were not (permanently) reduced to lowest form
		assertEquals(0, fraction1.numerator);
		assertEquals(16, fraction1.denominator);
		assertEquals(0, fraction2.numerator);
		assertEquals(100, fraction2.denominator);
				
	}
	
	@Test
	void testToString() {
		//test 1
		Fraction fraction1 = new Fraction(2, 3);
		String str = fraction1.toString();
		assertEquals("2/3", str);
		
		//test 2
		fraction1 = new Fraction(-6, 3);
		str = fraction1.toString();
		assertEquals("-6/3", str);
		
		//test3
		fraction1 = new Fraction(2, -3);
		str = fraction1.toString();
		assertEquals("-2/3", str);
		
		//test 4
		fraction1 = new Fraction(4, 16);
		str = fraction1.toString();
		assertEquals("4/16", str);		
		
	}

	@Test
	void testAverageFraction() {
		//test 1
		Fraction fraction1 = new Fraction(1, 2);
		Fraction otherFraction = new Fraction(3, 4);
		Fraction avgFraction = fraction1.average(otherFraction);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);
		
		//test 2
		fraction1 = new Fraction(5, 8);
		otherFraction = new Fraction(-12, 16);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(-1, avgFraction.numerator);
		assertEquals(16, avgFraction.denominator);
		
		//test 3
		fraction1 = new Fraction(-6, 7);
		otherFraction = new Fraction(3, -7);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(-9, avgFraction.numerator);
		assertEquals(14, avgFraction.denominator);
		
		//test 4
		fraction1 = new Fraction(1, 5);
		otherFraction = new Fraction(1, 7);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(6, avgFraction.numerator);
		assertEquals(35, avgFraction.denominator);
				
	}

	@Test
	void testAverageFractionArray() {

		//test 1
		Fraction fraction1 = new Fraction(3, 4);
		Fraction fraction2 = new Fraction(3, 5);
		Fraction fraction3 = new Fraction(3, 6);
		
		Fraction[] fractions = new Fraction[] {fraction1, fraction2, fraction3};
		Fraction avgFraction = Fraction.average(fractions);
		
		assertEquals(37, avgFraction.numerator);
		assertEquals(60, avgFraction.denominator);
		
		//test 2
	    fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(1, 3);
	    fraction3 = new Fraction(-1, 6);
		
		fractions = new Fraction[] {fraction1, fraction2, fraction3};
		avgFraction = Fraction.average(fractions);
		
		assertEquals(2, avgFraction.numerator);
		assertEquals(9, avgFraction.denominator);
		
		//test 3
		fraction1 = new Fraction(-10, 50);
		fraction2 = new Fraction(-5, 6);
	    fraction3 = new Fraction(6, 2);
		
		fractions = new Fraction[] {fraction1, fraction2, fraction3};
		avgFraction = Fraction.average(fractions);
		
		assertEquals(59, avgFraction.numerator);
		assertEquals(90, avgFraction.denominator);
		
		//test 4
		fraction1 = new Fraction(4, 1);
		fraction2 = new Fraction(0, 3);
	    fraction3 = new Fraction(-1, 6);
		
		fractions = new Fraction[] {fraction1, fraction2, fraction3};
		avgFraction = Fraction.average(fractions);
		
		assertEquals(23, avgFraction.numerator);
		assertEquals(18, avgFraction.denominator);
				
	}

	@Test
	void testAverageIntArray() {

		//test 1
		int[] ints = new int[] {1, 2, 3, 4};
		Fraction avgFraction = Fraction.average(ints);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);
		
		//test 2
		ints = new int[] {-1, -2, -3, -4};
		avgFraction = Fraction.average(ints);
		
		assertEquals(-5, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);
		
		//test 3
		ints = new int[] {-5, -5, -5, -5, -5, -5, -5, -5};
		avgFraction = Fraction.average(ints);
		
		assertEquals(-5, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
		
		//test 4
		ints = new int[] {};
		avgFraction = Fraction.average(ints);
		
		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
		
		//test 5
		ints = new int[] {4};
		avgFraction = Fraction.average(ints);
		
		assertEquals(4, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
		
	}

}
