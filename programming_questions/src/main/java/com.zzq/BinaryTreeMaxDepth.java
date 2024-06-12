package com.zzq;

import com.zzq.data_structure.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeMaxDepth {

    public static void main(String[] args) {
        BinaryTreeNode root;
        root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        System.out.println("BFS最大高度: " + bfsMaxDepth(root));
        System.out.println("DFS最大高度: " + dfsMaxDepth(root));
    }
    
    // 递归
    public static int dfsMaxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        return Math.max(dfsMaxDepth(root.left), dfsMaxDepth(root.right)) + 1;
    }

    // BFS
    public static int bfsMaxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return depth;
    }


}
