package Josephu;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
    }
}

class CircleSingleLinkedList {
    // 创建一个first节点，没有编号所以暂时填写-1
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        // for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 判断是不是第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成第一个节点指向自己的环状
                curBoy = first; // 让curBoy指向第一个节点。因为first不能动，所以只能靠curBoy来构建环状链表
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; // 让curBoy指向新添加的节点。
            }
        }
    }

    // 输出小孩节点
    // curBoy从first开始遍历，直到curBoy.next == first; 证明是遍历完成
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为first不能动，因此我们仍然使用辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getId());
            if (curBoy.getNext() == first) { // 说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy后移
        }
    }
}

class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }
}
