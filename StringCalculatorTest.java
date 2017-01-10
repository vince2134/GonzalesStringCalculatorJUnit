package com.ideyatech.ut.exercise;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

	private StringCalculator cal1;
	
	@Before //INITIALIZATION OF VARIABLES AT THE START
	public void init(){
		//System.out.println("This will run BEFORE any unit test method.");
		cal1 = new StringCalculator();
	}
	
	@Test
	public void testScenario1(){
		assertEquals(0, cal1.calculate(null));
	}
	
	@Test
	public void testScenario2(){
		assertEquals(55, cal1.calculate("55"));
	}
	
	@Test
	public void testScenario3(){
		assertEquals(100, cal1.calculate("10,20,30,40"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testScenario4(){
		cal1.calculate("-100");
	}
	
	@Test
	public void testScenario5(){
		assertEquals(0, cal1.calculate("1001"));
	}
	
	@Test
	public void testScenario6(){
		assertEquals(60, cal1.calculate("10,20,30,1001"));
	}
	
	@Test
	public void testScenario7(){
		assertEquals(21, cal1.calculate("//=1=2=3=4=5=6"));
	}
	
	@Test
	public void testScenario8(){
		assertEquals(21, cal1.calculate("//[abc]1abc2abc3abc4abc5abc6"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testScenario9(){
		cal1.calculate("//=1=2=3=4=5=6=2000=-1");
	}
	
	@Test
	public void testScenario10(){
		assertEquals(21, cal1.calculate("//=1=2=3=4=5=6=2000"));
	}
}
