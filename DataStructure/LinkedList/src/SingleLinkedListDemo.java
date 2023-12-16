public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "hero1", "heronickname1");
        HeroNode heroNode2 = new HeroNode(2, "hero2", "heronickname2");
        HeroNode heroNode3 = new HeroNode(3, "hero3", "heronickname3");
        HeroNode heroNode4 = new HeroNode(4, "hero4", "heronickname4");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.list();

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();
        System.out.println();

        // 测试修改节点的代码
        HeroNode updateHeroNode = new HeroNode(2, "hero2_update", "hero2nickname2_update");
        singleLinkedList.update(updateHeroNode);

        singleLinkedList.list();
        System.out.println();

        // 删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.list();
        System.out.println();

        singleLinkedList.del(4);
        singleLinkedList.list();
        System.out.println();
    }
}

// 定义SingleLinkedList管理英雄
class SingleLinkedList {
    // 初始化头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // 添加节点，添加到最后
    // 思路: 当不考虑编号顺序时
    // 1. 先找到最后一个节点
    // 2. 将最后一个节点的next域指向新的节点
    public void add(HeroNode heroNode) {
        HeroNode temp = head; // head不能动，所以需要一个辅助变量遍历
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 否则，temp后移，继续找
            temp = temp.next;
        }
        // 这里退出了while循环，就证明已经找到最后一个节点，下一步就是添加新节点
        temp.next = heroNode;
    }

    // 第二种方式 在添加英雄时，根据排名将英雄插入到指定位置
    //
    public void addByOrder(HeroNode heroNode) {

        // 通过一个辅助指针来帮助找到添加的位置
        // 因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // 标识添加的编号是否存在，默认为false

        while (true) {
            if (temp.next == null) { // 说明temp在链表的最后
                break;
            }
            // 拿temp的下一个节点比较
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已经存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移
        }

        // 判断flag的值
        if (flag) {
            // 不能添加，说明编号存在
            System.out.printf("The hero id of ready to insert is %d already exists\n", heroNode.no);
        } else {
            // 插入到temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点信息
    // 1. 根据newHeroNode的no来修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点

        while (true) {
            if (temp == null) {
                break; // 到链表的最后了
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     *
     * head不能动，我们需要一个temp辅助节点来代表待删除节点的前一个节点
     * 所以是在验证temp.next.no是否等于待删除结点的no
     * */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标记是否找到待删除结点
        while (true) {
            if (temp.next == null) {
                System.out.println("链表为空");
                break;
            }
            if (temp.next.no == no) {
                // 找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 这样就是找到，可以删除了
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号%d的节点，不能删除\n", no);
        }
    }

    /**
     * 显示链表内容
     * */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点
    // 构造器
    public HeroNode(int hno, String hName, String hNickname) {
        this.no = hno;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}
