package io.github.miareko.samples.datastruct.tree;

public class TreeNode<K, V> {

    K key;
    V value;
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    TreeNode<K, V> parent;

    public TreeNode(){}

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
