package io.github.miareko.samples.datastruct.tree;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

public final class TreeHelper {

    public static void print(TreeNode tree, PrintStream ps) {
        int depth = getTreeDepth(tree);
        try {
            String treeString = getPrintString(tree, 1, depth);
            ps.println(treeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印树形结构
     *
     * @param tree
     */
    public static void print(TreeNode tree) {
        print(tree, System.out);
    }

    private static int getTreeDepth(TreeNode tree) {
        return tree == null ? 0 : Math.max(getTreeDepth(tree.left), getTreeDepth(tree.right)) + 1;
    }

    public static String getPrintString(TreeNode tree, int f, int n) throws Exception {
        if (f == n) {
            return tree == null ? "    " : String.format("[%s] ", tree.key);
        }
        StringBuilder sb = new StringBuilder();
        if (tree == null) {
            for (int i = 0; i < ((n-f) << 1) + 1; i++) {
                for (int j = 0; j < 1 << n-f-1; j++) {
                    sb.append("        ");
                }
                sb.append("\r\n");
            }
            return sb.toString();
        }

        for (int i = 0; i < (1 << n-f-1) - 1; i++) {
            sb.append("    ");
        }
        sb.append("  ").append("[").append(tree.key).append("]").append("   ");
        for (int i = 0; i < (1 << n-f-1) - 1; i++) {
            sb.append("    ");
        }
        sb.append("\r\n");

        for (int i = 0; i < (1 << n-f-1) - 1; i++) {
            sb.append("    ");
        }
        sb.append("  ").append(tree.left != null ? "/ " : "  ").append(tree.right != null ? "\\" : " ").append("   ");
        for (int i = 0; i < (1 << n-f-1) - 1; i++) {
            sb.append("    ");
        }
        sb.append("\r\n");

        String leftTreeString = getPrintString(tree.left, f+1, n);
        String rightTreeString = getPrintString(tree.right, f+1, n);

        BufferedReader leftTreeReader = new BufferedReader(new StringReader(leftTreeString));
        BufferedReader rightTreeReader = new BufferedReader(new StringReader(rightTreeString));

        String leftLine;
        String rightLine;
        while ((leftLine = leftTreeReader.readLine()) != null && (rightLine = rightTreeReader.readLine()) != null) {
            sb.append(leftLine).append(rightLine).append("\r\n");
        }
        return sb.toString();
    }

    private TreeHelper() {}
}
