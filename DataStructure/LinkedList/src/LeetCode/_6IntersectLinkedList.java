package LeetCode;

import java.util.HashSet;

/**
 * Leetcode: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * 代码随想录: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.md
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null。
 * @author ryanw
 * */
@SuppressWarnings("all")
public class _6IntersectLinkedList {
    public static void main(String[] args) {}

    /**
     * 两种方法解决此问题
     * 1. 哈希集合
     * 2. 双指针
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. headA遍历链表将所有节点存储到HashSet中
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        // 2. 遍历headB，检测headB中的每一个节点值是否已经在HashSet中有重复
        temp = headB;
        while (temp != null) {
            // 3. 如果有重复，headB第一个所指向的重复的这个节点，就是相交节点
            if (visited.contains(temp)) {
                return temp;
            }
            // 4. 如果没重复，headB继续后移
            temp = temp.next;
        }

        // 5. 如果链表 headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回 null
        return null;

    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
