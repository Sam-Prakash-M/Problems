package com.samprakash.level2;

import java.util.Scanner;

public class GenerateMaximumTime {

	public static void main(String[] args) {

		System.out.println("Enter a Test Case Count....");
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		while (testCase-- != 0) {
			System.out.println("Enter a Time in format of(24 hours)...");
			System.out.println("Maximum Valid Time is : " + getMaxTime(sc.nextLine().toCharArray()));
		}

	}

	private static String getMaxTime(char[] time) {

		// for zero th position

		if (time[1] <= '2' && time[1] > time[0]) {
			swap(0, 1, time);

		}
		if (time[3] <= '2' && time[3] > time[0]) {

			swap(0, 3, time);
		}
		if (time[4] <= '2' && time[4] > time[0]) {

			swap(0, 4, time);
		}

		// for first Position
		if (time[0] == '2') {

			if (time[3] <= '3' && time[3] > time[1]) {

				swap(1, 3, time);
			}
			if (time[4] <= '3' && time[4] > time[1]) {

				swap(1, 4, time);
			}
		} else {
			if (time[3] > time[1]) {

				swap(1, 3, time);
			}
			if (time[4] > time[1]) {

				swap(1, 4, time);
			}
		}

		if (time[3] > '5' || (time[4] <= '5' && time[4] > time[3])) {

			swap(3, 4, time);
		}

		return new String(time);
	}

	private static void swap(int i, int j, char[] time) {
		char swap = time[i];
		time[i] = time[j];
		time[j] = swap;

	}

}
