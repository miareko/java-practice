package io.github.miareko.samples.designpattern.singleton;

import java.io.Serializable;

/**
 * 静态内部类单例模式
 *
 * created by fanlu on 04/19/2017
 */
public class InnerClassSingleton implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6328282898644050781L;

	private static class SingletonHolder {
		private static final InnerClassSingleton INSTANCE = new InnerClassSingleton(); 
	}

	private InnerClassSingleton() {
		
	}
	
	public static InnerClassSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	/**
	 * 防止序列化破解 
	 */
	public Object readResolve() {
		return SingletonHolder.INSTANCE;
	}
	
}
