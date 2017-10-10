package org.logwing.harvey.questionbank.codinginterviews;

import org.junit.Test;
import org.logwing.harvey.questionbank.helper.TreeNode;

public class Question17Test {

    @Test
    public void test() {

        Question17 instance = new Question17();
        
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(0);
        root1.left.left.left = new TreeNode(0);
        root1.left.left.right = new TreeNode(0);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        
        assert(instance.HasSubtree(root1, root2));

        root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(7);
        
        assert(instance.HasSubtree(root1, root2));
        
    }

}