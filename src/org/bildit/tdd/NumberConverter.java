package org.bildit.tdd;

/**
 * Number converter from Arabs to Roman and vice versa
 *
 * @author Goran Arsenic
 *
 */
public class NumberConverter {
	
	static final char[] ROMAN = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	static final int[] ROMAN_VALUES = { 1, 5, 10, 50, 100, 500, 1000};
	
	public String convertArabicToRoman(int number) {

		StringBuilder result = new StringBuilder();
		
		char min, mid, max;
		
		if(number > 0) {
			min = ROMAN[0];
			mid = ROMAN[1];
			max = ROMAN[2];
			
			int firstDigit = number % 10;
			
			result.append(convertIntToRoman(firstDigit, min, mid, max));
				
			if(number >= 10) {
				min = ROMAN[2];
				mid = ROMAN[3];
				max = ROMAN[4];
				
				int secondDigit = (number / 10) % 10;
				
				result.insert(0, convertIntToRoman(secondDigit, min, mid, max));
			}
			if(number >= 100) {
				min = ROMAN[4];
				mid = ROMAN[5];
				max = ROMAN[6];
				
				int thirdDigit = (number / 100) % 10;
				
				result.insert(0, convertIntToRoman(thirdDigit, min, mid, max));
			}
			if(number >= 1000 && number < 5000) {
				
				int fourthDigit = (number / 1000) % 10;
				
				for(int i = 0; i < fourthDigit; i++) {
					result.insert(0, "M");
				}
			}
		}
		return result.toString();
	}
	
	public String convertIntToRoman(int number, char min, char mid, char max) {
		
		StringBuilder sb = new StringBuilder();
		
		if(number == 0) {
			sb.append("");
		}
		else if(number <= 3) {
			for(int i = 0; i < number; i++){
				sb.append(min);
			}
		}
		else if(number >=4 && number <= 8) {
			sb.append(mid);
			if(number > 5) {
				for(int i = 0; i < number - 5; i++){
					sb.append(min);
				}
			}
			else if(number == 4){
				sb.insert(0, min);
			}
		}
		else if(number == 9) {
			sb.append(min);
			sb.append(max);
		}
		return sb.toString();
		
	}
	
	/**
	 * Method for convert Roman numbers to Arabic
	 * @param roman, String
	 * @return result, int
	 * 
	 * @author goran
	 */
	
	public int convertRomanToArabic(String roman) {
			
		StringBuilder sb = new StringBuilder();
		// put string of Roman number into string builder so it can be change
		sb.append(roman);
		
		int result = 0;
		
		// idea: take first character from number, determine it's value, add value to result, and remove it
		// if number have more then one character, relationship between first two must be determined
		// if two characters create one value, remove both
		
		while(sb.length() > 0) {
			
			// index for first character from number in array ROMAN
			int index1 = 0;
			
			char romanChar1 = sb.charAt(0);
			
			// search for match in array ROMAN to find index
			for(int i = 0; i < ROMAN.length; i++) {
				if(romanChar1 == ROMAN[i]) {
					index1 = i;
				}
			}
			
			if(sb.length() > 1) {
				
				char romanChar2 = sb.charAt(1);
				// index for second character from number in array ROMAN
				int index2 = 0;
				// search for match in array ROMAN to find index for second character
				for(int i = 0; i < ROMAN.length; i++) {
					if(romanChar2 == ROMAN[i]) {
						index2 = i;
					}
				}
				// if second char have greater index than first, it means that they together crate one value (e.g. IX) 
				if(index1 < index2) {
					result += ROMAN_VALUES[index2] - ROMAN_VALUES[index1];
					// deleting second character, because it's already used
					sb.deleteCharAt(1);
				}
				else {
					result += ROMAN_VALUES[index1];
				}
				
			}
			else {
				result += ROMAN_VALUES[index1];

			}
			// delete first character
			sb.deleteCharAt(0);
			
		}
		return result;
	}

}

