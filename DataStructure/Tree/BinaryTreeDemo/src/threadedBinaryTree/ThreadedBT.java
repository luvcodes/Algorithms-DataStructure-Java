package threadedBinaryTree;

/**
 * @author ryanw
 * 这个就是用中序遍历的顺序来实现线索化二叉树，而不是真正地调用中序遍历的方法。
 */
public class ThreadedBT {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode heroNode2 = new HeroNode(3, "jack");
        HeroNode heroNode3 = new HeroNode(6, "smith");
        HeroNode heroNode4 = new HeroNode(8, "mary");
        HeroNode heroNode5 = new HeroNode(10, "king");
        HeroNode heroNode6 = new HeroNode(14, "dim");

        // 手动创建二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        // 测试中序线索化
        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.setRoot(root);
        tree.threadedNodes();
//
//        // 测试结果: 以10号节点
//        HeroNode node5Left = heroNode5.getLeft();
//        HeroNode node5Right = heroNode5.getRight();
//        System.out.println("10号节点的前驱节点是 = " + node5Left);
//        System.out.println("10号节点的后继节点是 = " + node5Right);

        // 使用线索化的方式遍历线索化二叉树
        System.out.println("使用线索化的方式遍历线索化二叉树");
        tree.threadedList();
    }
}


// 定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadBinaryTree {
    private HeroNode root;

    // 为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    // 遍历线索化二叉树的方法
    public void threadedList() {
        // 定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);

            // 如果当前节点的右节点指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }


    // 重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }


    // 编写对二叉树进行中序线索化的方法
    // node就是当前需要进行线索化的节点
    public void threadedNodes(HeroNode node) {
        // 如果当前节点为空，就无法线索化了
        if (node == null) {
            return;
        }

        // 1. 先线索化左子树
        threadedNodes(node.getLeft());

        // 2. 线索化当前节点

        // 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 3. 再线索化右子树
        threadedNodes(node.getRight());
    }

    public HeroNode getRoot() {
        return root;
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // 1. 如果leftType == 0 表示指向的是左子树，如果是1则表示指向前驱节点
    // 2. 如果rightType == 0 表示指向的是右子树，如果是1则表示指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}