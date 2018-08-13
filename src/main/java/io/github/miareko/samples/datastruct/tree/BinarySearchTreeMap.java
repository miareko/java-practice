package io.github.miareko.samples.datastruct.tree;

public class BinarySearchTreeMap<K extends Comparable, V> implements Map<K, V> {

    private TreeNode<K, V> root;

    @Override
    public V get(K key) {
        return root == null ? null : get(root, key);
    }

    private V get(TreeNode<K, V> tree, K key) {
        if (tree.key == key || key.equals(tree.key)) {
            return tree.value;
        }
        if (key.compareTo(tree.key) < 0) {
            return tree.left == null ? null : get(tree.left, key);
        } else {
            return tree.right == null ? null : get(tree.right, key);
        }
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return;
        }
        put(root, key, value);
        TreeHelper.print(root);
    }

    private void put(TreeNode<K, V> tree, K key, V value) {
        if (tree.key == key || key.equals(tree.key)) {
            tree.value = value;
            return;
        }

        if (key.compareTo(tree.key) < 0) {
            if (tree.left == null) {
                tree.left = new TreeNode(key, value);
                tree.left.parent = tree;
            } else {
                put(tree.left, key, value);
            }
        } else {
            if (tree.right == null) {
                tree.right = new TreeNode(key, value);
                tree.right.parent = tree;
            } else {
                put(tree.right, key, value);
            }
        }
    }

    @Override
    public V remove(K key) {
        if (root == null) {
            return null;
        }
        V value = remove(root, key);
        TreeHelper.print(root);
        return value;
    }

    public V remove(TreeNode<K, V> tree, K key) {
        if (tree == null) {
            return null;
        }
        if (tree.key == key || key.equals(tree.key)) {
            TreeNode<K, V> current = tree;
            if (tree.left == null && tree.right == null) {
                if (tree.parent == null) {
                    root = null;
                } else if (tree == tree.parent.left) {
                    tree.parent.left = null;
                } else {
                    tree.parent.right = null;
                }
            } else if (tree.left == null) {
                tree.right.parent = current.parent;
                if (tree.parent == null) {
                    root = current.right;
                } else if (tree == tree.parent.left) {
                    tree.parent.left = current.right;
                } else {
                    tree.parent.right = current.right;
                }
            } else if (tree.right == null) {
                tree.left.parent = current.parent;
                if (tree.parent == null) {
                    root = current.left;
                } else if (tree == tree.parent.left) {
                    tree.parent.left = current.left;
                } else {
                    tree.parent.right = current.left;
                }
            } else {
                TreeNode<K, V> newNode = tree.right;
                while (newNode.left != null) {
                    newNode = newNode.left;
                }
                tree.key = newNode.key;
                tree.value = newNode.value;
                remove(tree.right, newNode.key);
            }
            return current.value;
        }

        return key.compareTo(tree.key) < 0 ? remove(tree.left, key) : remove(tree.right, key);
    }
}
