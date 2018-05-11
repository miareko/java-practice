package io.github.miareko.samples.algorithms.sort.impl;

import io.github.miareko.samples.algorithms.sort.AbstractSort;

import java.util.Arrays;


public class RadixSort extends AbstractSort {

	int[] tmpArr = new int[100];

	@Override
	public void sort(int[] arr, int start, int end) {
		
		for (int i = start; i <= end; i++) {
			tmpArr[arr[i]]++;
		}
		
		int j = start;
		
		
		for (int i = 0; i < tmpArr.length; i++) {
			if (tmpArr[i] > 0) {
				Arrays.fill(arr, j, j + tmpArr[i], i);
				j += tmpArr[i];
			}
		}
		
	}

}
