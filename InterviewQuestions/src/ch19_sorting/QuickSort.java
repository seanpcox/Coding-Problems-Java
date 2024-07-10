// @author: seanpcox

package ch19_sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	// In place, unlike MergeSort
	// O(1) space complexity
	// O(nlogn) average case
	// O(n^2) worst case, but highly unlikely, since we are choosing random
	
	// Uses Dutch National Flag, but recursively
	
	public static void main(String[] args) {
		int[] a = {8,5,1,3,4,2,7,6};
		dutchNationalFlag(a, 0, a.length-1);
	}
	
	private static void dutchNationalFlag(int[] a, int s, int e) {
		if(a == null || a.length == 0 || s >= e || s < 0 || e >= a.length) {
			return;
		}
		
		int pivotIndex = getRandomIndex(s, e);
		int pivot = a[pivotIndex];
		
		System.out.println(s + ":" + e + ":" + pivotIndex);
		
		int i = s;
		int sb = s;
		int eb = e;
		
		while(i <= eb) {
			if(a[i] < pivot) {
				swap(a, i++, sb++);
			} else if(a[i] > pivot) {
				swap(a, i, eb--);
			} else {
				i++;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
		dutchNationalFlag(a, s, sb-1);
		dutchNationalFlag(a, eb+1, e);
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static int getRandomIndex(int s, int e) {
		return new Random().nextInt(e-s+1) + s;
	}
	
}
