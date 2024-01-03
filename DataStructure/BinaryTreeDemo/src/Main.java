public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 递归的方式创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
//        // 测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();


        // 查找
        // 前序查找 4次
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null) {
//            System.out.println("找到了，no=" + resNode.getNo() + " name=" + resNode.getName());
//        } else {
//            System.out.println("没有找到");
//        }

        // 中序查找 3次
//        HeroNode resNode2 = binaryTree.infixOrderSearch(5);
//        if (resNode2 != null) {
//            System.out.println("找到了，no=" + resNode2.getNo() + " name=" + resNode2.getName());
//        } else {
//            System.out.println("没有找到");
//        }


        // 后序查找 2次
        HeroNode resNode3 = binaryTree.postOrderSearch(5);
        if (resNode3 != null) {
            System.out.println("找到了，no=" + resNode3.getNo() + " name=" + resNode3.getName());
        } else {
            System.out.println("没有找到");
        }
        // 测试
        // System.out.println("前序遍历");
        // binaryTree.preOrder();

        // System.out.println("中序遍历");
        // binaryTree.infixOrder();

        // System.out.println("后序遍历");
        // binaryTree.postOrder();

        // 测试删除节点
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }
}

// 定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    // 编写前序遍历的方法
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.deleteNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // 编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);
        // 递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序遍历查找");
        // 比较当前节点是不是目标节点
        if (this.no == no) {
            return this;
        }

        // 判断当前节点左子节点是否为空，如果不为空，则递归前序查找
        // 如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) { // 说明左子树找到
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        // 判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("中序遍历查找");

        // 如果找到则返回，如果没有找到，就和当前节点比较
        if (this.no == no) {
            return this;
        }

        // 否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {

        // 判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) { // 说明在左子树找到
            return resNode;
        }
        // 如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("后序遍历查找");

        // 最后判断当前节点是否为目标节点，如果是，则返回当前节点，否则返回null。
        if (this.no == no) {
            return this;
        }
        return resNode;  // 如果都没有找到，则返回null
    }


    // 递归删除节点
    // 删除非叶子节点，将子节点也删除
    // 如果删除节点是叶子节点，直接将节点删除
    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        // 向左子树进行递归删除
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        // 向右子树进行递归删除
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}