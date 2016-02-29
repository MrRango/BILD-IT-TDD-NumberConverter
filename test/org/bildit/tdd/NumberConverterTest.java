package org.bildit.tdd;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class NumberConverterTest {

	NumberConverter cc;

	@Before
	public void setUp() throws Exception {
		cc = new NumberConverter();
	}

	@Test
	public void testRomanToArabic1() {
		int expected = 1;

		int result = cc.convertRomanToArabic("I");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic2() {
		int expected = 2;

		int result = cc.convertRomanToArabic("II");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic3() {
		int expected = 3;

		int result = cc.convertRomanToArabic("III");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic4() {
		int expected = 4;

		int result = cc.convertRomanToArabic("IV");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic5() {
		int expected = 5;

		int result = cc.convertRomanToArabic("V");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic6() {
		int expected = 6;

		int result = cc.convertRomanToArabic("VI");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic7() {
		int expected = 7;

		int result = cc.convertRomanToArabic("VII");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic8() {
		int expected = 8;

		int result = cc.convertRomanToArabic("VIII");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic9() {
		int expected = 9;

		int result = cc.convertRomanToArabic("IX");

		assertEquals(expected, result);
	}

	@Test
	public void testRomanToArabic10() {
		int expected = 10;

		int result = cc.convertRomanToArabic("X");

		assertEquals(expected, result);
	}

	@Test
	public void testToArabicFromFile() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("numbers.txt")))) {
			while (br.ready()) {
				System.out.println("=========");
				String readLine = br.readLine();
				System.out.println(readLine);
				String st = readLine.split("=")[1];
				assertEquals(Integer.parseInt(readLine.split("=")[0]), cc.convertRomanToArabic(st));
			}
			System.out.println("=========");
			System.out.println("FINISHED");
		}
	}

	@Test
	public void testReturnNegativ() {
		// test data
		String expected = "";

		// execute method
		String result = cc.convertArabicToRoman(-50);

		// assert
		assertEquals(expected, result);
	}

	@Test
	public void testReturnZero() {
		// test data
		String expected = "";

		// execute method
		String result = cc.convertArabicToRoman(0);

		// assert
		assertEquals(expected, result);
	}

	@Test
	public void testReturnOne() {
		String expected = "I";

		String result = cc.convertArabicToRoman(1);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnTwo() {
		String expected = "II";

		String result = cc.convertArabicToRoman(2);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnThree() {
		String expected = "III";

		String result = cc.convertArabicToRoman(3);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnFour() {
		String expected = "IV";

		String result = cc.convertArabicToRoman(4);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnFive() {
		String expected = "V";

		String result = cc.convertArabicToRoman(5);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnSix() {
		String expected = "VI";

		String result = cc.convertArabicToRoman(6);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnSeven() {
		String expected = "VII";

		String result = cc.convertArabicToRoman(7);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnEight() {
		String expected = "VIII";

		String result = cc.convertArabicToRoman(8);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnNine() {
		String expected = "IX";

		String result = cc.convertArabicToRoman(9);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn10() {
		String expected = "X";

		String result = cc.convertArabicToRoman(10);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn18() {
		String expected = "XVIII";

		String result = cc.convertArabicToRoman(18);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn37() {
		String expected = "XXXVII";

		String result = cc.convertArabicToRoman(37);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn222() {
		String expected = "CCXXII";

		String result = cc.convertArabicToRoman(222);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn500() {
		String expected = "D";

		String result = cc.convertArabicToRoman(500);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn1500() {
		String expected = "MD";

		String result = cc.convertArabicToRoman(1500);

		assertEquals(expected, result);
	}

	@Test
	public void testReturn3694() {
		String expected = "MMMDCXCIV";

		String result = cc.convertArabicToRoman(3694);

		assertEquals(expected, result);
	}

	@Test
	public void testToRomanFromFile() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("numbers.txt")))) {
			while (br.ready()) {
				System.out.println("=========");
				String readLine = br.readLine();
				System.out.println(readLine);
				Integer dec = Integer.valueOf(readLine.split("=")[0]);
				assertEquals(readLine.split("=")[1], cc.convertArabicToRoman(dec));
			}
			System.out.println("=========");
			System.out.println("FINISHED");
		}
	}

}
