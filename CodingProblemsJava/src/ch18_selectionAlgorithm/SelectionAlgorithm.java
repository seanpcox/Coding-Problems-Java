// @author: seanpcox

package ch18_selectionAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SelectionAlgorithm {

	// O(n) normal time
	// O(n^2) worst case time, but usually does not happen
	// Median of medians is an algorithm that will always guarantee O(n) time, but is complex and prob don't need to learn
	
	public static void main(String[] args) {
		int[] a = {2,4,1,4,7,3,9};
		System.out.println(Arrays.toString(a));
		System.out.println(findKthElement(a, 7));
		System.out.println(Arrays.toString(a));
	}
	
	private static int findKthElement(int[] a, int k) {
		if(a == null || a.length == 0 || k <= 0 || k > a.length) {
			throw new RuntimeException("Invalid arguments");
		}
		
		// k-1 to put it into zero index
		return selectionAlgorithm(a, 0, a.length-1, k-1);
	}

	private static int selectionAlgorithm(int[] a, int s, int e, int k) {
		int p = getRandomIndex(s, e);
		int i = partition(a, s, e, p);
		
		if(i == k) {
			return a[i];
		} else if(i > k) {
			return selectionAlgorithm(a, s, i-1, k);
		} else {
			return selectionAlgorithm(a, i+1, e, k);
		}
	}
	
	private static int partition(int[] a, int s, int e, int p) {
		// Swap the pivot with the start
		swap(a, s, p);
		
		// Mark the cloud point
		int less = s;
		
		// We will start one past the start which is now the pivot
		for(int i = s + 1; i <= e; i++) {
			// If the current value is less or equal than the pivot we want it in the cloud
			if(a[i] <= a[s]) {
				swap(a, less + 1, i);
				// Increase the cloud size
				less++;
			}
		}
		
		// Swap the pivot outside of the cloud of <= pivot
		swap(a, s, less);
		
		// Return the pivot
		return less;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static int getRandomIndex(int s, int e) {
		return new Random().nextInt(e - s + 1) + s;
	}
	
}
