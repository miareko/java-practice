package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

public class DirectInsertionSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < arr[i-1]) {
				int x = arr[i];
				int j = i - 1;
				while (j >= start && x < arr[j]) {
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = x;
			}
		}
	}

}
