package Learning.ReverseSingleLinkedList_;

/**
 * @author yangrunze
 */
public class ReverseSSL_ {
    public static void main(String[] args) {
        Node node1 = new Node(1, "A", "B");
        Node node2 = new Node(2, "C", "D");
        Node node3 = new Node(3, "E", "F");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node3);

        // show added nodes
        linkedList.list();
        System.out.println();

        reverse(linkedList.getHead());
        linkedList.list();
    }

    /**
     * Reverse the linkedlist
     * 或者可以把这个方法写进SingleLinkedList里面，不需要传入head参数。调用就直接创建SingleLinkedList实例对象，
     * 然后直接调用reverse方法即可。
     * */
    public static void reverse(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        // 帮助定义原来的链表
        Node temp = head.next;
        // 指向当前节点的下一个节点，也就是temp的下一个节点
        Node next = null;
        Node reverseHead = new Node(0, "", "");

        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }

        head.next = reverseHead.next;
    }
}

class SingleLinkedList {
    private Node head = new Node(0, "", "");

    public Node getHead() { return head;}

    /**
     * Add node with the ordered id number
     * </p>
     * 1. 循环链表，通过id的比对，找到添加节点的id小于head.next.next的id。
     * 2. 将添加节点的next域指向head.next.next
     * 3. 将head.next.next指向添加节点
     * */
    public void addNode(Node node) {
        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("Node already exists");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * Delete the node
     * */
    public void deleteNode(int nodeId) {
        if (head.next == null) {
            System.out.println("The list is empty");
            return;
        }

        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == nodeId) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("There is no such node in the linkedlist");
        }
    }

    /**
     * Update the node
     * */
    public void updateNode(Node newNode) {
        if (head.next == null) {
            System.out.println("The list is empty");
            return;
        }

        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == newNode.id) {
                flag = true;
                break;
            }
            temp  = temp.next;
        }


        if (flag) {
            temp.next.name = newNode.name;
            temp.next.description = newNode.description;
        } else {
            System.out.println("No such node in the linkedlist");
        }
    }


    /**
     * Display the whole linkedlist
     * */
    public void list() {
        if (head.next == null) {
            System.out.println("The list is empty");
            return;
        }

        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class Node {
    public int id;
    public String name;
    public String description;
    public Node next;

    public Node (int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
