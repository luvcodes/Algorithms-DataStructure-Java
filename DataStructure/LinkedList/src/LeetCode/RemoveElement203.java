package LeetCode;

/**
 * @author yangrunze
 * LeetCode203 移除链表节点
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */
public class RemoveElement203 {
    public static void main(String[] args) {

    }

    /**
     * 有三种方法解决：
     * 1. 在同一个链表中直接实现删除节点操作
     * 2. 添加头结点的方式
     * 3. 使用递归的方式
     * */

    // 方式一:
    // /**
    // * 不添加虚拟节点也不使用pre Node方式，即在当前链表中直接实现删除
    // * 时间复杂度 O(n)
    // * 空间复杂度 O(1)
    // * @param head
    // * @param val
    // * @return
    // */
    //    public ListNode1 removeElements(ListNode head, int val) {
    //        // 判断初始状态，是否当前输入的就是需要删除的节点
    //        while (head != null && head.val == val) {
    //            head = head.next;
    //        }
    //
    //        // 设置指针指向当前节点
    //        ListNode1 currNode = head;
    //
    //        // 开始移除操作, 删除中间的节点 (不是头和尾)
    //        while (currNode != null && currNode.next != null) {
    //            if (currNode.next.val == val) {
    //                currNode.next = currNode.next.next;
    //            } else {
    //                // 向后移一位指针
    //                currNode = currNode.next;
    //            }
    //        }
    //
    //        return head;
    //    }


    // /**
    // * 第二种方式：添加头节点方式
    // * 时间复杂度 O(n)
    // * 空间复杂度 O(1)
    // * @param head
    // * @param val
    // * @return
    // */
    // public ListNode1 removeElements(ListNode1 head, int val) {
    //     if (head == null) {
    //         return head;
    //     }
    //     // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
    //     ListNode1 dummy = new ListNode1(-1, head);
    //     ListNode1 pre = dummy;
    //     ListNode1 cur = head;
    //     while (cur != null) {
    //         if (cur.val == val) {
    //             pre.next = cur.next;
    //         } else {
    //             pre = cur;
    //         }
    //         cur = cur.next;
    //     }

    // 最终需要的是返回新链表的头节点
    //     return dummy.next;
    // }


    // /**
    // * 第三种方式：递归的方式，不添加虚拟节点
    // * 时间复杂度 O(n)
    // * 空间复杂度 O(1)
    // * @param head
    // * @param val
    // * @return
    // */
    // public ListNode1 removeElements(ListNode1 head, int val) {
    //     while (head != null && head.val == val) {
    //         head = head.next;
    //     }
    //     // 已经为null，提前退出
    //     if (head == null) {
    //         return head;
    //     }
    //     // 已确定当前head.val != val
    //     ListNode1 pre = head;
    //     ListNode1 cur = head.next;
    //     while (cur != null) {
    //         if (cur.val == val) {
    //             pre.next = cur.next;
    //         } else {
    //             pre = cur;
    //         }
    //         cur = cur.next;
    //     }
    //     return head;
    // }


}

/*class ListNode {
    // 节点存储的数值
    int val;
    // 指向下一个节点的引用
    ListNode1 next;

    // 默认构造函数，用于创建值为0的节点，没有后续节点
    ListNode() {}

    // 构造函数，用于创建一个给定值的节点，没有后续节点
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // 构造函数，用于创建一个给定值的节点，并指定后续节点
    ListNode(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}*/
