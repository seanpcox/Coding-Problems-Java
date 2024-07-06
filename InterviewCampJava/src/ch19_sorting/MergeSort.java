// @author: seanpcox

package ch19_sorting;

import java.util.Arrays;

public class MergeSort {

	// Time Complexity of Merge Sort:  O(nlog(n)) worst case
	// Space Complexity of Merge Sort: O(n)
	// Usually a stable sort, which means identical values remain in their original order
	
	public static void main(String[] args) {
		int[] a = {9,4,6,1,2,3,5,2,8,1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length-1);
	}
	
	private static void mergeSort(int[] a, int s, int e) {
		if(s >= e) {
			return;
		}
		
		int mid = ((e - s) / 2) + s;
		mergeSort(a, s, mid);
		mergeSort(a, mid+1, e);
		merge(a, s, mid, e);
	}
	
	private static void merge(int[] a, int s, int mid, int e) {
		int rSize = e - s + 1;
		int[] r = new int[rSize];
		
		int aP = s;
		int bP = mid+1;
		
		for(int i = 0; i < rSize; i++) {
			if(aP > mid) {
				r[i] = a[bP++];
			} else if(bP > e) {
				r[i] = a[aP++];
			} else if(a[aP] < a[bP]) {
				r[i] = a[aP++];
			} else {
				r[i] = a[bP++];
			}
		}
		
		for(int i = 0; i < rSize; i++) {
			a[s + i] = r[i];
		}
	}
	
}
