package com.samprakash.level2;

import java.util.Scanner;

public class RepeatingTimes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println("String is : "+getString(str,0)[0]);

	}

	private static String [] getString(String str, int start) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = start; i < str.length(); i++) {
			
			if(str.charAt(i) == '(') {
				
				String [] subRes = getString(str, i + 1);
				sb.append(subRes[0]);
				i = Integer.valueOf(subRes[1]);
				
			}
			else if(str.charAt(i) == ')') {
				if(i + 3 < str.length()) {
					if(Character.isDigit(str.charAt(i + 2))) {
						int repeatCount[] = getRepeatCount(i + 2,str);
						return new String[] {sb.toString().repeat(repeatCount[0]),String.valueOf(repeatCount[1])};
					}
						return new String[] {sb.toString(), String.valueOf(i)};
				}
					return new String[] {sb.toString(), String.valueOf(i)};
			}
			
			else if(Character.isLetter(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
	
		}
		return new String [] {sb.toString(), String.valueOf(1)};
	}

	private static int [] getRepeatCount(int i, String str) {
		int repeatCount = 0 , index = i;
		for(index =  i; str.charAt(index) != '}';index++) {
			repeatCount = repeatCount* 10 + str.charAt(i) - '0';
		}
		
		return new int [] {repeatCount,index};
	}

}
