package io.github.miareko.samples.designpattern.singleton;

/**
 * 懒汉式单例
 *
 * created by fanlu on 04/19/2017
 */
public class LazySingleton {
	
	private static LazySingleton inst = null;
	
	private LazySingleton() {}
	
	public synchronized static LazySingleton getInstance() {
		if (inst == null) {
			inst = new LazySingleton();
		}
		return inst;
	}

}
