package io.github.miareko.samples.designpattern.singleton;

/**
 * 饿汉式单例
 *
 * created by fanlu on 04/19/2017
 */
public class HungrySingleton {
	
	private static HungrySingleton inst = new HungrySingleton();
	
	private HungrySingleton() {}
	
	public static HungrySingleton getInstance() {
		return inst;
	}

}
