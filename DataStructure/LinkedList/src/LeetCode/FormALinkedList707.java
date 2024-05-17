package LeetCode;

/**
 * @author yangrunze
 * LeetCode707: https://leetcode.cn/problems/design-linked-list/description/
 * 选择使用单链表或者双链表，设计并实现自己的链表。
 */
public class FormALinkedList707 {
    public static void main(String[] args) {
        
    }
}

// 单链表
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode1 head;

    //初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode1(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }

        // 虚拟头节点
        ListNode1 currentNode = head;
        // 遍历到第index个实际节点，注意从head开始已经有一个虚拟头节点，所以需要遍历index次
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // 返回第index个实际节点的值
        return currentNode.next.val;
    }

    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode1 pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode1 toAdd = new ListNode1(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode1 pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * 双链表
 */
/*class ListNode1 {
    int val;
    ListNode1 next, prev;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }
}


class MyLinkedList {

    //记录链表中元素的数量
    int size;
    //记录链表的虚拟头结点和尾结点
    ListNode1 head, tail;

    public MyLinkedList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode1(0);
        this.tail = new ListNode1(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        //判断index是否有效
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode1 cur = this.head;
        //判断是哪一边遍历时间更短
        if (index >= size / 2) {
            //tail开始
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        } else {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //index大于链表长度
        if (index > size) {
            return;
        }
        //index小于0
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到前驱
        ListNode1 pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //新建结点
        ListNode1 newNode = new ListNode1(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;

    }

    public void deleteAtIndex(int index) {
        //判断索引是否有效
        if (index < 0 || index >= size) {
            return;
        }
        //删除操作
        size--;
        ListNode1 pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
    }
}*/


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */