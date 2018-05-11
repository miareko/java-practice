package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

public class QuickSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		if (start < end) {
			int i = start;
			int j = end;

			int privot = arr[start];
			while (i < j) {
				while (i < j && arr[j] >= privot) {
					j--;
				}
				arr[i] = arr[j];

				while (i < j && arr[i] <= privot) {
					i++;
				}
				arr[j] = arr[i];
			}
			arr[i] = privot;

			sort(arr, start, i - 1);
			sort(arr, i + 1, end);
		}
	}

}
