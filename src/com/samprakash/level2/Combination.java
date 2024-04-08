package com.samprakash.level2;

import java.util.Scanner;

public class Combination {

	public static void main(String[] args) {

		System.out.println("Enter a Number of Test Case...");
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < test; i++) {

			System.out.println("Enter A valid Time 24 hours Format....");
			String time = sc.nextLine();
			if (time.length() == 3) {
				time = "0" + time;
			}
			System.out.println("Find Valid Greatest Time..." + findValidTime(new StringBuilder(time)));
		}

	}

	private static String findValidTime(StringBuilder time) {
		time.deleteCharAt(2);
		return new StringBuilder(getGreatestString(time.toString().toCharArray(), 0)).insert(2, ":").toString();
	}

	private static String getGreatestString(char[] time, int index) {

		if (index == time.length) {
			 System.out.println("curr : "+new String(time));
			if (time[0] > '2') {
				System.out.println("Exit");
				return "";
			}
			if (time[0] == '2') {
				if (time[1] > '3') {
					System.out.println("Exit");
					return "";
				}
				
			}
			if (time[2] > '5') {
				System.out.println("Exit");
				return "";
			}
			
			return new String(time);
		}
		String max = "";
		for (int i = index; i < time.length; i++) {
			swap(i, index, time);
			String res = getGreatestString(time, index + 1);
			max = res.compareTo(max) >= 0 ? res : max;
			swap(i, index, time);
		}
		return max;

	}

	private static void swap(int i, int index, char[] time) {

		char temp = time[i];
		time[i] = time[index];
		time[index] = temp;

	}

}
