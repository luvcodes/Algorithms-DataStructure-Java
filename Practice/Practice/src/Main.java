public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 定义单链表
 * */
class SingleLinkedList {
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    /**
     * 第一种方式添加节点
     * */
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 往下继续找
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 自动按照id顺序添加节点
     * */
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("该节点已存在");
        } else {
            // 把节点接进来
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        // 用一个实际的节点
        Node temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        } else {
            System.out.println("There is no such node with id");
        }
    }

    /**
     * 删除节点
     * */
    public void deleteNode(int no) {
        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                System.out.println("LinkedList is empty");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("There is no such node with id");  // 不需要break，因为这个就是最后一个节点了，所以就直接break了。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。;
        }
    }

    public void list() {
        if (head.next != null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp != null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next; // 往下找
        }
    }
}


class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next; // 指向下一个节点
    // 构造器
    public Node(int hno, String hName, String hNickname) {
        this.no = hno;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "SingleLinkedList_.Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}