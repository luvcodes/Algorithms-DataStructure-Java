package DoubleLinkedList_;


/**
 * @author ryanw
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "hero", "hero");
        HeroNode2 heroNode2 = new HeroNode2(2, "hero2", "hero2");
        HeroNode2 heroNode3 = new HeroNode2(3, "hero3", "hero3");
        HeroNode2 heroNode4 = new HeroNode2(4, "hero4", "hero4");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);

        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode3);

        doubleLinkedList.list();
        System.out.println();

        doubleLinkedList.update(new HeroNode2(2, "hero2_update", "hero2nickname2_update"));
        doubleLinkedList.list();
        System.out.println();

        doubleLinkedList.delete(3);
        doubleLinkedList.list();
        System.out.println();

    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加节点
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 添加新节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 按顺序添加节点
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            // 说明temp在链表的最后
            if (temp.next.no > heroNode.no) {
                // 执行 break 跳出循环，因为找到了插入的正确位置。
                break;
            } else if (temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已经存在
                // 修改flag成为true
                flag = true;
                break;
            }
            // 后移引用
            temp = temp.next;
        }

        // 判断flag的值
        if (flag) {
            System.out.printf("The hero id of ready to insert is %d already exists\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }

    // 修改节点
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 找到需要修改的节点，根据no编号
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有找到该节点");
        }

    }

    // 删除节点
    // 对于双向链表，我们可以直接找到要删除的这个节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到该节点");
        }

        temp = null; // 释放资源，否则会导致内存泄露
    }
}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    // 构造器
    public HeroNode2(int hno, String hName, String hNickname) {
        this.no = hno;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "SingleLinkedList_.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}



