package io.github.miareko.samples.designpattern.singleton;

/**
 * 双重校验锁单例
 *
 * created by fanlu on 04/19/2017
 */
public class DoubleCheckSingleton {
	
	private static volatile DoubleCheckSingleton inst = null;
	
	private static Object lock = new Object();
	
	private DoubleCheckSingleton() {}
	
	public static DoubleCheckSingleton getInstance() {
		if (inst == null) {
			synchronized (lock) {
				if (inst == null) {
					inst = new DoubleCheckSingleton();
				}
			}
		}
		return inst;
	}

}
