public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrBinaryTree = new ArrayBinaryTree(arr);

        System.out.println("前序遍历：");
        arrBinaryTree.preOrder();

        System.out.println("\n中序遍历：");
        arrBinaryTree.inOrder();

        System.out.println("\n后序遍历：");
        arrBinaryTree.postOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空或零长度");
        }
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    private void preOrder(int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void inOrder() {
        this.inOrder(0);
    }

    private void inOrder(int index) {
        if (index >= arr.length) {
            return;
        }
        if (2 * index + 1 < arr.length) {
            inOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length) {
            inOrder(2 * index + 2);
        }
    }

    public void postOrder() {
        this.postOrder(0);
    }

    private void postOrder(int index) {
        if (index >= arr.length) {
            return;
        }
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
