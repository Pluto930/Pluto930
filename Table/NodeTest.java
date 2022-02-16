package study.Table;

/*
判断一个链表是否为回文结构  ：可以用右部分入栈，弹出的时候先进后出，和链表左部分比较，一样则为回文
快慢指针：漫指针一次走一步，快指针一次走两步，当快指针走完时，慢支针指向中间

链表排序，小于区域 等于区域 大于区域     listPartition(Node head, int pivot)
 */
public class NodeTest {
    //单向链表
    private static class Node {
        public int value;
        public Node next;
//      public Node past;    双向链表

        public Node(int data) {
            this.value = data;
        }
    }

    //链表排序，小于区域 等于区域 大于区域
    public static Node listPartition(Node head, int pivot) {
        Node sH = null;  //small head
        Node sT = null;  //small tail
        Node eH = null;  //equal head
        Node eT = null;
        Node mH = null;  //big head
        Node mT = null;
        Node next = null;  //save next node
        while (head != null) {
            next = head.next;  //保存head之后的链表
            head.next = null;  //取出head这单个节点
            if (head.value < pivot) {  //小于
                if (sH == null) {
                    sH = head;
                    sT = head;//代表小于区域时空的，然后头尾都指向head节点
                } else {
                    sT.next = head;
                    sT = head;   //代表小于区域不为空，则边界的下一个节点指向head，然后边界指向head
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }

        //small and equal reconnect
        if (sT != null) {//小于区域不为null
            sT.next = eH;
            eT = eT == null ? sT : eT;  //下一步，谁去链接大于区域的头，谁就变成eT
        }

        //上面的if不管跑了没有，et
        //all reconnect
        if (eT != null) {  //如果小于区域和等于区域不是都没有
            eT.next = mH;
        }

        return sH != null ? sH : (eH != null ? eH : mH);
    }


}
