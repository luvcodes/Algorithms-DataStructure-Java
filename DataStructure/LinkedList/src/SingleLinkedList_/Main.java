package SingleLinkedList_;

/**
 * @author yangrunze
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.print();
    }
}


class ListNode {
    int value;
    ListNode next;

    ListNode(int x) {
        value = x;
        next = null;
    }
}

class MyLinkedList {
    private ListNode head;

    public MyLinkedList() {
        head = null;
    }

    public void add(int value) {
        if (head == null) {
            head = new ListNode(value);
        }
        // 如果链表头部不为空，意味着链表中已经有至少一个节点。
        // 在这种情况下，代码首先设置一个current变量指向链表的头节点。
        else {
            ListNode current = head;
            // 它使用一个while循环来遍历链表。while循环的条件是current.next != null，
            // 这意味着只要current节点后面还有节点，循环就会继续执行，
            // current变量就会被更新为链表中的下一个节点。
            while (current.next != null) {
                current = current.next;
            }
            // 当while循环结束时，current将会是链表的最后一个节点（因为current.next为null）
            // 将这个新节点设置为current节点的next节点。这样，新节点就被成功添加到了链表的末尾
            current.next = new ListNode(value);
        }
    }

    public void print() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
