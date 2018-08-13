package io.github.miareko.test.datastruct;

import io.github.miareko.samples.datastruct.tree.BinarySearchTreeMap;
import io.github.miareko.samples.datastruct.tree.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by miareko on 2018/8/14
 */
public class TreeTest {

    @Test
    public void test() {
        Map<Integer, String> map = new BinarySearchTreeMap<>();
        map.put(2, "222");
        map.put(1, "111");
        map.put(5, "555");
        map.put(4, "444");
        map.put(3, "333");

        Assert.assertEquals("555", map.get(5));

        map.put(5, "666");
        Assert.assertEquals("666", map.get(5));
        Assert.assertEquals("666", map.remove(5));
        Assert.assertEquals("333", map.remove(3));
        Assert.assertEquals("111", map.remove(1));
        Assert.assertEquals("222", map.remove(2));
        Assert.assertEquals("444", map.remove(4));
    }
}
