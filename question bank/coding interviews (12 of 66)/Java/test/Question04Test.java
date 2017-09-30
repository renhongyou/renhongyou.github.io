package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question04Test {

    @Test
    public void test() {
        
        Question04 instance = new Question04();
        
        int[] test = {};
        TreeNode root = instance.reConstructBinaryTree(test, test);
        
        assertEquals(root, null);
        
        int[] in = { 3, 2, 4, 1, 6, 5, 7 };
        int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
        int[] answer = { 1, 2, 5, 3, 4, 6, 7 };
        
        root = instance.reConstructBinaryTree(pre, in);
        int[] result = { root.val, root.left.val, root.right.val, root.left.left.val, 
                root.left.right.val, root.right.left.val, root.right.right.val };
               
        assertArrayEquals(result, answer);
        
    }

}
