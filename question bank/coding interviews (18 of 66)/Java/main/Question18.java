package org.logwing.harvey.questionbank.codinginterviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.logwing.harvey.questionbank.helper.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。<br>
 * 二叉树的镜像定义：<br>
 * 源二叉树：<br>
 *     8        <br>
 *    /  \      <br>
 *   6   10     <br>
 *  / \  / \    <br>
 * 5  7 9  11   <br>
 *镜像二叉树：<br>
 *     8        <br>
 *    /  \      <br>
 *   10   6     <br>
 *  / \  / \    <br>
 * 11 9 7   5
 * @author Harvey
 *
 */
public class Question18 {
    /**
     * 递归。<br>
     * 前序遍历这棵树的每个节点，如果遍历到的结点有子节点，就交换它的两个子节点。<br>
     * 当交换完所有的非叶子节点的左右子节点之后，就得到了树的镜像。
     * @param root
     */
    public void Mirror01(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        Mirror01(root.left);
        Mirror01(root.right);
    }
    
    /**
     * 栈操作。
     * @param root
     */
    public void Mirror02(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode nodeLeft = node.left;
                TreeNode nodeRight = node.right;
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
    
    /**
     * 队列操作。
     * @param root
     */
    public void Mirror03(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode temp;
        
        while (!queue.isEmpty()) {
            temp = queue.poll();
            
            if (temp == null) {
                continue;
            }
            
            TreeNode nodeLeft = temp.left;
            TreeNode nodeRight = temp.right;
            temp.left = nodeRight;
            temp.right = nodeLeft;
            queue.add(nodeRight);
            queue.add(nodeLeft);
        }
    }
}
