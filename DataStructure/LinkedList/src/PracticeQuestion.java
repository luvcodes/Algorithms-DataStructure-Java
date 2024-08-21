import java.awt.*;

/**
 * @author ryanw
 */
@SuppressWarnings("all")
public class PracticeQuestion {
    public static void main(String[] args) {

    }
}

/**
 * 设计并实现自己的链表
 */
class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        // 首先判断index的值是否符合条件
        if (index < 0 || index >= size) {
            return -1;
        }

        // 实现当前指针
        ListNode currentNode = head;

        // for循环遍历链表
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    // 在链表最前面插入一个节点，等价于在第0个元素前添加


    // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加


    // 在第 index 个节点之前插入一个新节点
    public void addAtIndex(int index, int data) {
        // 判断index是否符合要求
        if (index < 0 || index > size) {
            return;
        }

        // 增加链表长度
        size++;

        // 设置当前指针
        ListNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // 要被插入的新节点
        ListNode newNode = new ListNode(data);

        // 执行插入操作
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }


    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;

        if (index == 0) {
            // 删除链表的第一个正式节点
            head = head.next;
        }
    }

}

/**
 * 自定义ListNode
 */
class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
