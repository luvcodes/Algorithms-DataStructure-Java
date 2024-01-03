public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // 创建一个ArrBinaryTree
        ArrayBinaryTree arrBinaryTree = new ArrayBinaryTree(arr);
        arrBinaryTree.preOrder();  // 遍历前序遍历
    }
}

// 编写ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrayBinaryTree {
    private int[] arr; // 存储数据节点的数组
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder
    public void preOrder() {
        this.preOrder(0);  // 向数组中的第0个元素进行前序遍历
    }

    // 编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        // 向右递归遍历
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);  // 向右递归遍历，就是二叉树的后序遍历
        }

        return;  // 递归结束，返回到上一层，继续遍历上一层节点
    }
}
