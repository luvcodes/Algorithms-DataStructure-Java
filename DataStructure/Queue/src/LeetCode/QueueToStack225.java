package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yangrunze
 * LeetCode225: https://leetcode.cn/problems/implement-stack-using-queues/description/
 */
public class QueueToStack225 {
    public static void main(String[] args) {

    }
}


// /**
// 方法一: 使用两个队列来实现栈的效果
// 这种方法是q2接收新元素，然后q1压入q2，再把q2中的所有交换到q1
//  */
// class MyStack {

//     Queue<Integer> queue1;
//     Queue<Integer> queue2;

//     public MyStack() {
//         // 声明两个队列
//         queue1 = new LinkedList<Integer>();
//         queue2 = new LinkedList<Integer>();
//     }

//     /**
//     添加元素
//      */
//     public void push(int x) {
//         // 直接将新元素添加到辅助队列中
//         queue2.offer(x);
//         // 判断主要队列是否为空，不为空从q1的左侧弹出，从q2的右侧压入q2
//         while (!queue1.isEmpty()) {
//             queue2.offer(queue1.poll());
//         }
//         // 用一个临时队列来交换q1和q2，把q2全都交换到q1
//         // 这样做是为了保证原始q1中的元素顺序
//         Queue<Integer> temp = queue1;
//         queue1 = queue2;
//         // 清空q2，准备下一轮
//         queue2 = temp;
//     }


//     // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
//     /**
//     弹出元素
//      */
//     public int pop() {
//         return queue1.poll();
//     }

//     /**
//     得到头部元素
//      */
//     public int top() {
//         return queue1.peek();
//     }

//     /**
//     判断是否为空
//      */
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }

// /**
//  * Your MyStack object will be instantiated and called as such:
//  * MyStack obj = new MyStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * boolean param_4 = obj.empty();
//  */


/**
 * 方法二: 使用两个队列来实现栈的效果
 * 这种方式是先把q1所有元素压入q2这样就清空了q1，然后q1接收新元素，然后再依次把q2压入q1
 */
class MyStack {

    //q1作为主要的队列，其元素排列顺序和出栈顺序相同
    Queue<Integer> q1 = new ArrayDeque<>();
    //q2仅作为临时放置
    Queue<Integer> q2 = new ArrayDeque<>();

    public MyStack() {
    }

    /**
     * 添加元素
     */
    public void push(int x) {
        while (q1.size() > 0) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (q2.size() > 0) {
            q1.add(q2.poll());
        }
    }


    // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可

    /**
     * 弹出元素
     */
    public int pop() {
        return q1.poll();
    }

    /**
     * 得到头部元素
     */
    public int top() {
        return q1.peek();
    }

    /**
     * 判断是否为空
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
