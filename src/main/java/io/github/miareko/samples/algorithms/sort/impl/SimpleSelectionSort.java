package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

public class SimpleSelectionSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			int min = arr[i];
			int pos = i;
			
			for (int j = i + 1; j <= end; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			
			if (pos != i) {
				swap(arr, i, pos);
			}
		}
	}

}
