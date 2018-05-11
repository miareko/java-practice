package io.github.miareko.samples.algorithms.sort;

public class Context implements Runnable {

	private Sort strategy;
	
	public void setStrategy(Sort strategy) {
		this.strategy = strategy;
	}
	
	@Override
	public void run() {
		
	}
	
	public void sort(int[] arr) {
		String strategyName = strategy.getClass().getName();
		System.out.println(strategyName);
		
//		print(arr);
		
		long start = System.currentTimeMillis();
		strategy.sort(arr, 0, arr.length-1);
		long end = System.currentTimeMillis();

//		print(arr);
		
		System.out.println("result: " + isSorted(arr));
		System.out.println("cost: " + (end - start) + "ms");
	}
	
	private boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public void print(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[arr.length - 1]);
	}
	
}
