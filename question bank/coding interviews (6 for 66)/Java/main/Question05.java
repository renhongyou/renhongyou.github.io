package org.logwing.harvey.questionbank.codinginterviews;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
 * @author Harvey
 *
 */
public class Question05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /**
     * 入队。<br>
     * 直接将元素进栈1。
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }
    
    /**
     * 出队。<br>
     * 判断栈2是否为空：<br>
     * 如果为空，则将栈1所有元素pop，并push进栈2，栈2出栈；<br>
     * 如果不为空，栈2直接出栈。
     * @return first
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }
}
