package io.github.miareko.samples.designpattern.singleton;

/**
 * 枚举单例
 *
 * created by fanlu on 04/19/2017
 */
public enum EnumSingleton {

	INSTANCE;
	
	public void doSomething() {
		System.out.println("doSomething");
	}
	
}
