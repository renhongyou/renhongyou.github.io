package org.logwing.harvey.questionbank.codinginterviews;

import org.logwing.harvey.questionbank.helper.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author Harvey
 *
 */
public class Question17 {
    /**
     * 思路：<br>
     * 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false。<br>
     * 如果找到了对应Tree2的根节点的点，则以这个根节点为起点判断是否包含Tree2。<br>
     * 如果找不到，就以root的左节点为起点，递归判断是否包含Tree2。<br>
     * 如果还找不到，再以root的右节点为起点，递归判断是否包含Tree2。<br>
     * 如果Tree1确实不包含Tree2，则最终返回false。
     * @param root1
     * @param root2
     * @return true/false
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        
        if (root2 != null && root1 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        
        return result;
    }

    /**
     * 思路：<br>
     * 如果Tree2已经遍历完了都能对应得上，返回true。<br>
     * 如果Tree2没有遍历完而Tree1却遍历结束，则返回false。<br>
     * 如果其中有一个点没有对应上，则返回false。<br>
     * 递归以上所有步骤，分别到子节点去逐个匹配判断。
     * @param root1
     * @param root2
     * @return true/false
     */
    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        
        if (node1 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {
            return false;
        }

        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);
    }
}
