package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		int length = end - start + 1;
		int delta = 1;
		
		while (delta < length) {
			int i = start;
			while (i <= end) {
				merge(arr, i, Math.min(i + (delta << 1) - 1, end), Math.min(i + delta - 1, end));
				i += (delta << 1);
			}
			delta <<= 1;
		}
	}
	
	private void merge(int[] arr, int start, int end, int mid) {
		int[] tmpArr = Arrays.copyOfRange(arr, start, end + 1);
		
		int tmpMid = mid - start;
		int tmpEnd = end - start;
		
		int i = 0;
		int j = tmpMid + 1;
		
		while (i <= tmpMid && j <= tmpEnd) {
			if (tmpArr[i] > tmpArr[j]) {
				arr[start++] = tmpArr[j];
				j++;
			} else {
				arr[start++] = tmpArr[i];
				i++;
			}
		}
		
		while (i <= tmpMid) {
			arr[start++] = tmpArr[i];
			i++;
		}
		
		while (j <= tmpEnd) {
			arr[start++] = tmpArr[j];
			j++;
		}
	}

}
