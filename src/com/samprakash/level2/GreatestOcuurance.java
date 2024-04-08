package com.samprakash.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GreatestOcuurance {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String...");
		String word = sc.nextLine();
		wordMostOccured(word);

	}

	private static void wordMostOccured(String word) {
		Map<Character, Integer> freq = new HashMap<>();
		for (char ch : word.toCharArray()) {
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}
		System.out.println(freq);
		int max = 0;
		char ch = ' ';
		Set<Map.Entry<Character, Integer>> entry  =  freq.entrySet();
		for (Map.Entry<Character, Integer> entrySet : entry) {
			if(entrySet.getValue() > max) {
				max = entrySet.getValue();
				ch = entrySet.getKey();
			}
		}
		System.out.println(ch+" Occurs "+max+" times");
	}

}
