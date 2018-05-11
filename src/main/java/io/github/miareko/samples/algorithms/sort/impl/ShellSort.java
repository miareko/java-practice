package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

public class ShellSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		int delta = end - start >> 1;
		
		while (delta >= 1) {
			for (int i = start; i < start + delta; i++) {
				
				// 从start位置开始，间隔为delta的一组数做直接插入排序
				for (int j = start + delta; j <= end; j += delta) {
					if (arr[j] < arr[j - delta]) {
						int x = arr[j];
						int k = j - delta;
						while (k >= start && x < arr[k]) {
							arr[k + delta] = arr[k];
							k -= delta;
						}
						arr[k + delta] = x;
					}
				}
			}
			
			delta >>= 1;
		}
	}

}
