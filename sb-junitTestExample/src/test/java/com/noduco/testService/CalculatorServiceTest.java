package com.noduco.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.noduco.service.CalculatorService;

public class CalculatorServiceTest {
	
	 private final CalculatorService calculatorService = new CalculatorService();
	 
	 @Test
	 public void findMaxTest() {
		 int maxReal = CalculatorService.findMax(new int[] {4,10,15,2, 50});
		 int maxExpected = 50;
		 assertEquals(maxExpected, maxReal, "maxReal should equal expected");
	 }
	 
	 @Test
	 public void findMinTest() {
		 int minReal = CalculatorService.findMin(new int[] {4,10,15,2, 50});
		 int minExpected = 2;
		 assertEquals(minExpected, minReal, "minReal should equal expectedMin");
	 }

	    @Test
	    void testAddition() {
	        int result = calculatorService.add(5, 3);
	        assertEquals(8, result, "5 + 3 should equal 8");
	    }

	    @Test
	    void testSubtraction() {
	        int result = calculatorService.subtract(5, 3);
	        assertEquals(2, result, "5 - 3 should equal 2");
	    }

}
