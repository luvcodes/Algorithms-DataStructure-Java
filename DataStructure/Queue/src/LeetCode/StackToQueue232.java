package LeetCode;

import java.util.Stack;

/**
 * @author yangrunze
 * LeetCode232: https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * 使用两个栈实现先入先出队列
 */
public class StackToQueue232 {
    public static void main(String[] args) {

    }
}


class MyQueue {
    /**
     这个题目的核心逻辑是定义两个栈来实现队列的逻辑，一个是输入栈，一个是输出栈
     */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     构造器，创造栈
     */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     添加元素，元素push到输入栈中
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     移除元素，元素从输出栈中pop出去
     注意这里应该是输出栈的第一个元素向左pop
     */
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    /**
     查看头元素
     */
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /**
     判断stack是否为空
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么在进行移除元素的时候就需要将stackIn中的元素全部放到stackOut中
    private void dumpstackIn() {
        // 判断stackOut为非空，返回
        if (!stackOut.isEmpty()) return;
        // 如果stackIn中非空，那么循环操作将元素放入stackOut
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */