package LeetCode;

import java.util.HashSet;

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



        return null;
    }
}
