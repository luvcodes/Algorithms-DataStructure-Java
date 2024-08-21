package LeetCode;

/**
 * @author yangrunze
 * LeetCode707: 选择使用单链表或者双链表，设计并实现自己的链表。
 */
@SuppressWarnings("all")
public class _2GenerateLinkedList707 {
    public static void main(String[] args) {}
}

class MyLinkedList {
    int size;  // 存储链表元素的个数
    ListNode head;  // 虚拟头节点

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);  // 虚拟头节点
    }

    // 获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;  // 如果index非法，返回-1
        }

        ListNode currentNode = head;
        // 包含虚拟头节点，查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    // 在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;  // 如果index大于链表长度，返回空
        }
        if (index < 0) {
            index = 0;
        }
        size++;  // 扩大链表容量

        ListNode pred = findPred(index);  // 找到要插入节点的前驱
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;  // 如果index非法，返回
        }
        size--;  // 减少链表容量

        ListNode pred = findPred(index);  // 找到要删除节点的前驱
        pred.next = pred.next.next;
    }

    // 查找给定索引的前驱节点
    private ListNode findPred(int index) {
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        return pred;
    }
}


/**
 * 双链表
 */
/*class ListNode {
    int val;
    ListNode next, prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}


class MyLinkedList {

    //记录链表中元素的数量
    int size;
    //记录链表的虚拟头结点和尾结点
    ListNode head, tail;

    public MyLinkedList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        //判断index是否有效
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = this.head;
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
        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //新建结点
        ListNode newNode = new ListNode(val);
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
        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
    }
}*/
