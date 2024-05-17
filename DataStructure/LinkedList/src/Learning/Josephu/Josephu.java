package Learning.Josephu;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
        System.out.println();

        list.countBoy(1, 2, 5); // 2 -> 4 -> 1 -> 5 -> 3
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

    // 根据用户的输入，计算出节点出圈的顺序
    /**
     * @param startNo 表示从第几个节点开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个节点
     * */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        // 先把first节点移动到startNo位置
        Boy helper = first;
        // 创建辅助指针helper，事先应该指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动startNo-1次。因为要先让first和helper只想开始节点
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当节点报数时，让first和helper的指针同时地移动countNum - 1次，然后出圈
        // 循环操作，直到圈中只有一个节点
        while (true) {
            // 说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            // 让first和helper的指针同时地移动countNum - 1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点就是要出圈的节点
            System.out.printf("节点%d出圈\n", first.getId());
            // 这时将first指向的节点出圈，first指向first的下一个节点
            first = first.getNext();
            helper.setNext(first); // 当出圈时，把first节点设置为helper的下一个节点。因为first节点出圈，helper节点就是first节点的下一个节点。
        }
        System.out.printf("最后留在圈中的节点编号: %d \n", first.getId());
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
