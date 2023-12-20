import java.util.Scanner;

/**
 * 单链表实现栈
 * */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        /**
         * 在栈的典型实现中，通常不会预先创建节点然后再将它们添加到栈中。
         * 相反，当调用 push 方法时，通常会在那一刻创建新的节点并将其加入到栈中。
         * */
        LinkedListStack stack = new LinkedListStack();
        String key = " ";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 表示退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("peak: 表示查看栈顶的数据");
            key = scanner.next();
            switch (key) {
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int value1 = stack.pop();
                    System.out.printf("出栈的数据是: %d", value1);
                    break;
                case "peek":
                    int value2 = stack.peak();
                    System.out.printf("头结点数据是: %d", value2);
                    break;
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

class LinkedListStack {
    private Node top;

    public LinkedListStack() {
        top = null;
    }

    // 节点入栈
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // 节点出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = top.value;
        top = top.next;
        return value;  // 返回出栈的节点的值
    }

    // 查看top节点
    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return top.value;
    }

    // 显示所有节点
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        Node cur = top;
        while (cur != null) {
            System.out.printf("stack values: %d\n", cur.value);
            cur = cur.next;
        }
        System.out.println(); // 换行，输出格式整齐
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false; // 不考虑栈满的情况，只考虑栈空的情况
    }
}

class Node {
    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
