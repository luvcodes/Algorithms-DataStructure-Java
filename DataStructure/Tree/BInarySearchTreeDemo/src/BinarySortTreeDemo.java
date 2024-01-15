/**
 * @author ryanw
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环地添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}

// 定义一个二叉排序树
class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    // 查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //删除结点
    public void delNode(int value) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前这棵二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                // 这里实际上是联合了root.left == null && root.right == null和targetNode == null这两个条件
                // 都满足的时候，实际上就证明了二叉排序树只有一个结点，就是根节点
                root = null;
                return;
            }

            // 去找到targetNode的父结点
            Node parent = searchParent(value);

            // 如果要删除的结点是叶子结点
            if(targetNode.left == null && targetNode.right == null) {
                // 判断targetNode 是父结点的左子结点，还是右子结点
                // 是左子结点
                if(parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }
                // 是右子结点
                else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }
            // 删除有两颗子树的节点
            else if (targetNode.left != null && targetNode.right != null) {
                // 这里是举例实现如果要删除的目标节点恰好是在右面的子树
                int minVal = delRightTreeMin(targetNode.right);
                // 最小节点的值替换. 将 targetNode 的值替换为它的中序后继的值，因为它的值已经被delRightTreeMin方法里替换掉了
                targetNode.value = minVal;
                // 使用中序后继或中序前驱
                // int minVal = delRightTreeMin(targetNode.right); // 使用中序后继
                // int maxVal = delLeftTreeMax(targetNode.left); // 使用中序前驱
                // targetNode.value = maxVal; // 或者使用minVal，取决于使用哪种方式
            }
            // 删除只有一颗子树的结点
            else {
                // 如果要删除的结点有左子结点
                if(targetNode.left != null) {
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.left.value == value) {
                            parent.left = targetNode.left;
                        }
                        // targetNode 是 parent 的右子结点
                        else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                }
                // 如果要删除的结点有右子结点
                else {
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.left.value == value) {
                            parent.left = targetNode.right;
                        }
                        // 如果 targetNode 是 parent 的右子结点
                        else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    // 编写方法:
    // 1. 删除node 为根结点的二叉排序树的最小结点
    /**
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 使用 delRightTreeMin(targetNode.right) 是为了找到 targetNode 的中序后继节点，即它右子树中的最小节点。
     * delRightTreeMin 方法不仅返回这个最小值 minVal，而且还从树中删除了包含这个最小值的节点。
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        // 这时 target就指向了最小结点
        // 删除最小结点
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除node为根节点的二叉排序树的最大节点
     *
     * @param node 传入的节点（当做二叉排序树的根节点）
     * @return 返回以node为根节点的二叉排序树的最大节点的值
     */
    public int delLeftTreeMax(Node node) {
        Node target = node;
        // 循环查找右子节点，就会找到最大值
        while (target.right != null) {
            target = target.right;
        }
        // 这时target就指向了最大节点
        // 删除最大节点
        delNode(target.value);
        return target.value;
    }
}

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    // 添加节点的方法
    // 递归的形式添加节点，注意需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断传入的节点的值和当前子树的根节点的值的关系
        if (node.value < this.value) {
            // 如果当前节点左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归地向左子树添加
                this.left.add(node);
            }
        }
        // 添加地节点的值大于当前节点的值
        else {
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归地向右子树添加
                this.right.add(node);
            }
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    // 查找要删除的节点
    /**
     * @param value 要查找的节点的值
     * @return 如果找到返回该节点，如果没有返回null
     * */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        // 如果查找的值小于当前节点，向左子树递归查找
        else if (value < this.value) {
            // 如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }
        // 如果查找的值不小于当前节点，向右子树递归查找
        else {
            // 如果右子节点为空
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    // 查找要删除节点的父节点
    /**
     * @param value 要查找的节点的值
     * @return 返回的是要删除的节点的父节点，如果没有，就返回null
     * */
    public Node searchParent(int value) {
        // 如果当前节点就是要删除的节点的父节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value < this.value && this.left != null) {
                // 向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                // 向右子树递归查找
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
}