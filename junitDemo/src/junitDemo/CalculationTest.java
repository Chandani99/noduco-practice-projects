package junitDemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class CalculationTest {
	
	@Test
	 public void findMaxTest() {
		 int maxReal = Calculation.findMax(new int[] {4,10,15,2, 50});
		 int maxExpected = 50;
		 assertEquals(maxExpected, maxReal);
	 }
	 
	 @Test
	 public void findMinTest() {
		 int minReal = Calculation.findMin(new int[] {4,10,15,2, 50});
		 int minExpected = 2;
		 assertEquals(minExpected, minReal);
	 }
	 
	 @Test
	 public void sortDataTest() {
		 int[] result = Calculation.sortData(new int[] {4,10,15,2, 50});
		 
		 int[] expextedResult = {2, 4, 15, 40};
		 
		 assertEquals(result, expextedResult);
		 
		 assertNotNull(result);
	 }
}
