package Learning;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4); // 设置4，但是队列的有效数据最大是3

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        // 输出一个菜单
        while (loop) {
            System.out.println("Show queue: ");
            System.out.println("Exit queue: ");
            System.out.println("Add queue: ");
            System.out.println("Get element: ");
            System.out.println("Head element: ");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.print("Please enter a number: ");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("Get element: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("Head element: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
    }
}

class CircleArray {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头指向队列的第一个元素，不再是头元素的前一个位置了
    private int rear; // 队列尾, 指向队列的最后一个元素的后一个位置，注意: 队列中要空一格的原则。
    private int[] arr; // 该数组用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加入数据~");
            return;
        }
        arr[rear] = n;
        // 让rear后移, 取模才能到前面队列开头的空位
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        // 取模是因为要考虑不能越界，不取模它就会一直往后加1
        front = (front + 1) % maxSize;
        // 返回队列的第一个元素，并且删除元素。
        return value;
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路: 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        // front表示头数据的下标
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + maxSize) % maxSize];
    }
}