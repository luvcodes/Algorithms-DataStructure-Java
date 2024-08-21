package LeetCode;

/**
 * @author yangrunze
 * LeetCode203 移除链表节点
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */
@SuppressWarnings("all")
public class _1RemoveElement203 {
    public static void main(String[] args) {}

    /**
     * 移除链表中的相同元素，有三种方法
     * 1. 使用当前列表，直接移除
     * 2. 使用当前列表，递归方式移除
     * 3. 定义虚拟头节点
     * */
    private static ListNode removeDuplicates1(ListNode head, int val) {
        // 判断头节点是否为空、是否为目标值
        if (head != null && head.value == val) {
            return head;
        }

        // 初始化指针指向当前链表的节点
        ListNode current = head;

        // 判断当前节点不为null、当前节点的下一个节点也不为null (也就是说当前节点不是尾节点)
        while (current != null && current.next != null) {
            // 判断是否下一个节点的值为目标值
            if (current.next.value == val) {
                // 指向下一个节点的下一个节点
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    private static ListNode removeDuplicates2(ListNode head, int val) {
        // 判断head节点是否为空、是否为目标值
        while (head != null && head.value == val) {
            return head;
        }
        // 判断头节点是否为空
        if (head == null) {
            return head;
        }

        // 这里实际上就是另一种写法而已
        ListNode pre = head;
        ListNode current = head.next;

        // 当前节点不为空
        while (current != null) {
            // 开始操作节点的指向
            if (current.value == val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
        }

        return head;
    }


    private static ListNode removeDuplicates3(ListNode head, int val) {
        // 判断head是否为null
        if (head == null) {return head;}

        // 考虑到删除节点有可能是删除头节点，所以设置虚拟头节点 dummy, 统一操作
        ListNode dummy = new ListNode();
        // 链接dummy节点和head节点
        dummy.next = head;
        // 这就是新的头节点 (尽管是虚拟的)
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.value == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // dummy.next才是新的头节点，也就是要返回的节点
        return dummy.next;
    }

}
