package io.github.miareko.samples.algorithms.sort.impl;


import io.github.miareko.samples.algorithms.sort.AbstractSort;

import java.util.Arrays;

public class HeapSort extends AbstractSort {

	@Override
	public void sort(int[] arr, int start, int end) {
		int length = arr.length;
		int[] tmpArr = Arrays.copyOf(arr, length);
		buildHeap(tmpArr);
		
		for (int i = 0; i < length - 1; i++) {
			arr[i] = tmpArr[0];
			adjustHeap(tmpArr, length - i);
		}
		arr[length - 1] = tmpArr[0];
	}
	
	private void buildHeap(int[] arr) {
		int n = arr.length;
		
		for (int i = (n - 1) >> 1; i >= 0; i--) {
			buildHeap4Root(arr, i, n);
		}
	}
	
	/**
	 * 以root为根构造小顶堆
	 * @param arr
	 * @param root
	 * @param size
	 */
	private void buildHeap4Root(int[] arr, int root, int size) {
		int left = (root << 1) + 1;
		int right = (root << 1) + 2;
		
		if (left < size) {
			if (right < size) {
				if (arr[root] > arr[left] || arr[root] > arr[right]) {
					if (arr[left] >= arr[right]) {
						swap(arr, root, right);
						buildHeap4Root(arr, right, size);
					} else {
						swap(arr, root, left);
						buildHeap4Root(arr, left, size);
					}
				}
			} else {
				if (arr[root] > arr[left]) {
					swap(arr, root, left);
				}
			}
		}
		
	}
	
	private void adjustHeap(int[] arr, int size) {
		arr[0] = arr[size - 1];
		buildHeap4Root(arr, 0, size - 1);
	}
	
}
