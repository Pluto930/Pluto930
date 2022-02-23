//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        
        Node node=head;
        while(node!=null){  //将每个节点后面插入一个新节点
            Node reNode=new Node(node.val);
            reNode.next=node.next;
            node.next=reNode;
            node=node.next.next;
        }
        node=head;
        while(node!=null){    //新节点的random指针，为老节点的random指针的next 挨个遍历
            node.next.random= node.random==null ? null : node.random.next;
            node=node.next.next; 
        }

        Node headNew = head.next;
        for (node = head; node != null; node = node.next) {   //原链表恢复原样，断开
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;

    }
}
