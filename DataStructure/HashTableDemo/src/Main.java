import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建HashTable
        HashTable hashTable = new HashTable(7);

        // 写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("input id");
                    int id = scanner.nextInt();
                    System.out.println("input name");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("input id");
                    int idFind = scanner.nextInt();
                    hashTable.findEmpById(idFind);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

// 创建hashtable，管理多条链表
class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    // 构造器
    public HashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // 遍历所有链表，遍历hashtable
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id，查找雇员
    public void findEmpById(int id) {
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员 id=%d\n", (empLinkedListNO+1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员！");
        }
    }

    // 编写散列函数, 使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    // 添加雇员到链表
    // 1. 假定当添加雇员时，id是自增长
    // 因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }

        // 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        // 退出时，直接将emp加入链表
        temp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no+1) + "链表为空！");
            return;
        }
        System.out.println("第" + (no+1) + "链表的雇员信息为：");
        Emp temp = head;
        while (true) {
            System.out.println("=> id = " + temp.id + ", name = " + temp.name);
            if (temp.next == null) { // 说明temp已经是最后节点
                break;
            }
            temp = temp.next;
        }
    }

    // 根据id查找雇员
    // 如果查找到，就返回Emp，如果没有找到，就返回null
    public Emp findEmpById(int id) {
        // 如果链表为空，则直接返回null
        if (head == null) {
            System.out.println("链表为空！");
            return null;
        }

        // 遍历链表
        Emp temp = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            if (temp.next == null) { // 说明temp已经是最后节点
                temp = null; // 直接把当前设置为空，因为只有当前不满足条件，才会需要向下继续选择，而下一位又是null
                break;
            }
            temp = temp.next;
        }
        return temp; // 返回emp，如果没有找到，就返回null
    }
}