package LeetCode;


/**
 * @author yangrunze
 * LeetCode203: https://leetcode.cn/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */
public class RemoveElement203 {
    public static void main(String[] args) {

    }

    /*public ListNode1 removeElements(ListNode1 head, int val) {
        // 判断当前节点是否为null
        if (head == null) {
            return head;
        }

        // 设置头节点前面的虚节点
        ListNode1 dummy = new ListNode1(-1, head);
        ListNode1 preNode = dummy;
        ListNode1 currentNode = head;

        while (currentNode != null) {
            if (currentNode.val == val) {
                // 移除当前节点
                preNode.next = currentNode.next;
            } else {
                // preNode指向当前节点，也就是往后移动了一位
                preNode = currentNode;
            }
            // 移动当前节点的指针向后一位
            currentNode = currentNode.next;
        }

        // 直接返回dummy节点的下一个节点就是结果所需要的新的头节点
        return dummy.next;
    }*/

    // /**
    // * 添加虚节点方式
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
    //     return dummy.next;
    // }
    // /**
    // * 不添加虚拟节点方式
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
    // /**
    // * 不添加虚拟节点and pre Node方式
    // * 时间复杂度 O(n)
    // * 空间复杂度 O(1)
    // * @param head
    // * @param val
    // * @return
    // */
    // public ListNode1 removeElements(ListNode1 head, int val) {
    //     while(head!=null && head.val==val){
    //         head = head.next;
    //     }
    //     ListNode1 curr = head;
    //     while(curr!=null){
    //         while(curr.next!=null && curr.next.val == val){
    //             curr.next = curr.next.next;
    //         }
    //         curr = curr.next;
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
