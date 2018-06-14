package company.Xiaomi;

// 1：构造二叉查找树；
//2：中序遍历二叉查找树，因此结点按从小到大顺序访问，假设之前访问过的结点已经调整为一个双向链表，那么
//    只需要将当前结点连接至双向链表的最后一个结点即可，访问完后，双向链表也就调整完了
public class BinaryToDoubleLink {

    BSTreeNode pHead = null;// 指向循环队列头结点
    BSTreeNode pIndex = null;// 指向前一个结点

    /* 建立二叉排序树 */
    BSTreeNode addBSTreeNode(BSTreeNode pCurrent, int value) {
        // 在这个函数中会要改变指针值，一定要记得使用引用传递
        if (pCurrent == null) {
            BSTreeNode pBSTree = new BSTreeNode();
            pBSTree.m_nValue = value;
            pBSTree.m_pLeft = null;
            pBSTree.m_pRight = null;
            pCurrent = pBSTree;
        } else if (pCurrent.m_nValue < value) {
            pCurrent.m_pRight = addBSTreeNode(pCurrent.m_pRight, value);
        } else if (pCurrent.m_nValue > value) {
            pCurrent.m_pLeft = addBSTreeNode(pCurrent.m_pLeft, value);
        } else {
            System.out.println("node repeated");
        }
        return pCurrent;
    }

    /* 中序遍历二叉树，同时调整结点指针 */
    void inOrderBSTree(BSTreeNode pBSTree) {

        if (null == pBSTree) {
            return;
        }
        if (null != pBSTree.m_pLeft) {
            inOrderBSTree(pBSTree.m_pLeft);
        }

        // if (null!=pBSTree)
        // {
        // cout<<pBSTree.m_nValue;
        // }
        convertToDoubleList(pBSTree);

        if (null != pBSTree.m_pRight) {
            inOrderBSTree(pBSTree.m_pRight);
        }

    }

    /* 调整结点指针 */
    void convertToDoubleList(BSTreeNode pCurrent) {
        pCurrent.m_pLeft = pIndex;// 使当前结点的左指针指向双向链表中最后一个结点
        if (null == pIndex)// 若最后一个元素不存在，此时双向链表尚未建立，因此将当前结点设为双向链表头结点
        {
            pHead = pCurrent;
        } else// 使双向链表中最后一个结点的右指针指向当前结点
        {
            pIndex.m_pRight = pCurrent;
        }

        pIndex = pCurrent;// 将当前结点设为双向链表中最后一个结点

        System.out.print(pCurrent.m_nValue + " ");
    }

    public static void main(String[] args) {
        BinaryToDoubleLink btl = new BinaryToDoubleLink();
        BSTreeNode pRoot = null;
        pRoot = btl.addBSTreeNode(pRoot, 10);
        btl.addBSTreeNode(pRoot, 6);
        btl.addBSTreeNode(pRoot, 14);
        btl.addBSTreeNode(pRoot, 4);
        btl.addBSTreeNode(pRoot, 8);
        btl.addBSTreeNode(pRoot, 12);
        btl.addBSTreeNode(pRoot, 16);
        btl.inOrderBSTree(pRoot);
    }
}

class BSTreeNode {
    int m_nValue;
    BSTreeNode m_pLeft;
    BSTreeNode m_pRight;
}
