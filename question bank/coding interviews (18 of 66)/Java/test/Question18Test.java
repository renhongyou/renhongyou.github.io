package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;
import org.logwing.harvey.questionbank.helper.TreeNode;

public class Question18Test {

    @Test
    public void test() {
        
        Question18 instance = new Question18();
        
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(4);
        
        int[] original = { 8, 6, 10, 5, 7, 9, 11, 4 };
        int[] answer = { 8, 10, 6, 11, 9, 7, 5, 4 };
        

        instance.Mirror01(root);
        
        int[] test01 = { root.val, root.left.val, root.right.val, root.left.left.val, 
                root.left.right.val, root.right.left.val, root.right.right.val, 
                root.right.left.right.val };
        
        assertArrayEquals(test01, answer);

        instance.Mirror02(root);
        
        int[] test02 = { root.val, root.left.val, root.right.val, root.left.left.val, 
                root.left.right.val, root.right.left.val, root.right.right.val, 
                root.left.right.left.val };
        
        assertArrayEquals(test02, original);
        
        instance.Mirror03(root);

        int[] test03 = { root.val, root.left.val, root.right.val, root.left.left.val, 
                root.left.right.val, root.right.left.val, root.right.right.val, 
                root.right.left.right.val };
        
        assertArrayEquals(test03, answer);

    }

}
