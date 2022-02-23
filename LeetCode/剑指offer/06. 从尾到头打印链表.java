输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int[] res;
    int count=0;
    int i=0;
    public int[] reversePrint(ListNode head) {
    
        /*Deque<Integer> dq=new LinkedList<Integer>();      //堆做法
        while(head!=null){
            dq.push(head.val);
            head=head.next;
        }
        int[] nums=new int[dq.size()];
        int i=0;
        while(!dq.isEmpty()){
            nums[i++]=dq.removeFirst();
        }
        return nums;*/
        
        
        re(head);
        return res;
    }
    void re(ListNode head){     //递归做法  直接递归到最下面， count计算几个数，i代表第几轮
        if(head == null){
            res = new int[count];
            return;
        }
        count++;
        re(head.next);
        res[i]=head.val;
        i++;
    }
}
