package io.github.miareko.test.designpattern;

import io.github.miareko.samples.designpattern.singleton.InnerClassSingleton;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Created by miareko on 2018/5/12.
 */
public class SingletonTest {

    @Test
    public void testCrackSingleton() throws Exception {

        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();

        // 反射破解
        Constructor<InnerClassSingleton> constructor = InnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InnerClassSingleton instance2 = constructor.newInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        // 序列化破解
        // readResolve() 防破解
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Singleton"));
             ObjectInputStream is = new ObjectInputStream(new FileInputStream("Singleton"))
        ) {

            os.writeObject(instance1);
            InnerClassSingleton instance3 = (InnerClassSingleton) is.readObject();

            System.out.println(instance1 == instance3);
            System.out.println(instance1.hashCode());
            System.out.println(instance3.hashCode());
        }
    }
}
