package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

public class BubbleSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		for (int i = end; i >= start; i--) {
			boolean sorted = true;
			
			for (int j = start; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					sorted = false;
				}
			}
			
			if (sorted)  {
				break;
			}
		}
	}

}
