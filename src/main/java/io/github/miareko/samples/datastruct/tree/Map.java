package io.github.miareko.samples.datastruct.tree;

public interface Map<K, V> {

    V get(K key);

    void put(K key, V value);

    V remove(K key);
}
