package com.samprakash.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class SortElementsUsingFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String to Size of array...");
		int size = sc.nextInt();
		System.out.println("Enter a Elements In an Array...");
		int [] arr = new int[size];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		printTheArrayAccordingToOccurance(arr);
	

	}

	private static void printTheArrayAccordingToOccurance(int[] arr) {
		
		Map<Integer,Integer> freq = new TreeMap<>();
		
		for(int i : arr) {
			if(freq.containsKey(i)) {
				freq.put(i, freq.get(i) + 1);
			}
			else {
				freq.put(i,1);
			}
			
		}
		
		List<Map.Entry<Integer,Integer>> list = new ArrayList<>(freq.entrySet());
		  System.out.println("Before : "+list);
		quickSort(list,0,list.size() - 1);
		 System.out.println("After : "+list);
		for(int i = 0; i < list.size();i++) {
			
			int value = list.get(i).getValue();
			while(value-- != 0) {
				System.out.print(list.get(i).getKey()+" ");
			}
		}
		 
	}

	private static void quickSort(List<Map.Entry<Integer, Integer>> list, int low, int high) {
		
		if(low == high) {
			return;
		}
		int start = low, end = high;
		Map.Entry<Integer,Integer> pivot = list.get((start+end)/2);
		
		while(start < end) {
			 
			while(list.get(start).getValue() < pivot.getValue()) {
				start++;
			}
			while(list.get(end).getValue() > pivot.getValue()) {
				end--;
			}
			if(start <= end) {
				if(list.get(start).getValue() != list.get(end).getValue()) {
					Map.Entry<Integer, Integer> temp = list.get(start);
					list.set(start, list.get(end));
					list.set(end, temp);
				}
				
				start++;
				end--;
			}
		}
		quickSort(list, low, end);
		quickSort(list, start, high);
		
	}

}
