package others;

public class BinaryTree {
    private BinaryTree leftSubTree;
    private BinaryTree rightSubTree;
    private Object data;
    public final static int MAX = 40;
    // 层次遍历时保存各个节点
    BinaryTree[] elements = new BinaryTree[MAX];
    // 层次遍历时队首
    int front;
    // 层次遍历时队尾
    int rear;

    BinaryTree() {

    }

    BinaryTree(Object data) {
        this.data = data;
    }

    BinaryTree(Object data, BinaryTree leftSubTree, BinaryTree rightSubTree) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
    }

    // ① 递归前序遍历
    public void preOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree != null) {
            visit(binaryTree.data);
            preOrderTraverse(binaryTree.leftSubTree);
            preOrderTraverse(binaryTree.rightSubTree);
        }
    }

    // ② 递归中序遍历二叉树
    public void inOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree != null) {
            inOrderTraverse(binaryTree.leftSubTree);
            visit(binaryTree.data);
            inOrderTraverse(binaryTree.rightSubTree);
        }
    }

    // ③ 递归后序遍历二叉树
    public void postOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree != null) {
            postOrderTraverse(binaryTree.leftSubTree);
            postOrderTraverse(binaryTree.rightSubTree);
            visit(binaryTree.data);
        }
    }

    // ④ 层次遍历二叉树
    public void layerOrderTraverse(BinaryTree binaryTree) {
        elements[0] = binaryTree;
        front = 0;
        rear = 1;
        while (front < rear) {
            if (elements[front].data != null) {
                visit(elements[front].data);
            }
            if (elements[front].leftSubTree != null) {
                elements[rear++] = elements[front].leftSubTree;
            }
            if (elements[front].rightSubTree != null) {
                elements[rear++] = elements[front].rightSubTree;
            }
            front++;
        }
    }

    // 求二叉树的高度
    public static int height(BinaryTree binaryTree) {
        int leftSubTreeHeight;
        int rightSubTreeHeight;
        if (binaryTree == null) {
            return 0;
        } else {
            leftSubTreeHeight = height(binaryTree.leftSubTree);
            rightSubTreeHeight = height(binaryTree.rightSubTree);
            return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight + 1 : rightSubTreeHeight + 1;
        }
    }

    // 访问根节点
    public void visit(Object data) {
        System.out.print(data + " ");
    }
}
