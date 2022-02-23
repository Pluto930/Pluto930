//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /*if(head == null) return null;
        Deque<ListNode> list=new LinkedList();      //堆栈写法
        ListNode node=head;
        while(node!=null){
            list.push(node);
            node=node.next;
        }
        head=list.pop();
        node = head;
        while(!list.isEmpty()){
            node.next=list.pop();
            node=node.next;
        }
        node.next=null;
        return head;*/

        //迭代写法
        if(head == null || head.next==null) return head==null?null:head;
        ListNode pre=null;
        ListNode node=head;
        while(node != null){
            ListNode next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}
