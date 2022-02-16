package study.Tree;

//import javax.swing.tree.Node;
import java.util.*;

/*
宽度优先遍历

宽度优先遍历为基础 最宽层节点数   （两种 一种用HashMap   一种不用）
 */
public class TreeMaxWidth {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int data){
            this.value=data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void width(Node head){   //宽度优先遍历    利用队列（先进先出），弹出一个就打印，然后压入左 右
        if(head==null) return;

        Queue<Node> queue=new LinkedList<>();  //队列（双向链表）
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            System.out.println(head.value+" ");

            if(head.left!=null) queue.add(head.left);
            if(head.right!=null) queue.add(head.right);
        }
    }

    public static int getMaxWidth(Node head){   //宽度优先遍历基础上算出层宽
        if(head==null) return 0;

        Queue<Node> queue=new LinkedList<>();  //队列（双向链表）
        queue.add(head);

        HashMap<Node,Integer> levelMap=new HashMap<>();   //利用hashMap  键值对 来锁定每个节点对应的层次
        levelMap.put(head,1);
        int curLevel=1;   //层数
        int curLevelNode=0;   //这层有多少节点
        int max=Integer.MIN_VALUE;   //最宽的

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            int curNodeLever=levelMap.get(cur);   //获取该节点所在层数
            if(curLevel==curNodeLever){   //相等 代表还是本层，本层节点++
                curLevelNode++;
            }else{
                max=Math.max(max,curLevelNode);   //不相等 代表已经进入下一层，max比较，然后层数++  层节点重置为1
                curLevel++;
                curLevelNode=1;
            }

            if(cur.left!=null){
                queue.add(cur.left);
                levelMap.put(cur.left,curLevel+1);   //每个节点入栈的时候都加到map中
            }
            if(cur.right!=null){
                queue.add(cur.right);
                levelMap.put(cur.right,curLevel+1);
            }
        }
        return Math.max(max,curLevelNode);
    }

    public static int getMaxWidth2(Node head){   //不用hashmap算       不对
        if(head==null) return 0;

        Queue<Node> queue=new LinkedList<>();  //队列（双向链表）
        queue.add(head);

        int curLevelNode=0;   //层节点数
        int max=Integer.MIN_VALUE;
        Node curEnd=head;   //本层最后一个节点
        Node NextEnd=head.right!=null?head.right:(head.left!=null?head.left:null);   //下一层最后一个节点

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur==curEnd){   //代表这个节点等于本层最后一个节点
                curLevelNode++;
                max=Math.max(max,curLevelNode);
                curEnd=NextEnd;//去下一层的结尾
                curLevelNode=0;
                NextEnd=null;//重新赋null
            }else{
                curLevelNode++;
            }

            if(cur.left!=null){
                queue.add(cur.left);
                NextEnd=cur.left;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                NextEnd=cur.right;
            }
        }
        return max;
    }

    public List<List<Integer>> levelOrder(Node head) {    //二叉树的层序遍历  BFS
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (head == null) {
            return ret;
        }

        Queue<Node> queue = new LinkedList<Node>();  //队列
        queue.offer(head);  //add

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();   //代表着该层有几个节点

            for (int i = 1; i <= currentLevelSize; ++i) {   //将这几个节点全部遍历，所有子节点添加到队列中去
                Node node = queue.poll();
                level.add(node.value);   //该层每个都添加到level中

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);  //将该层添加到总列表里去
        }

        return ret;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println(getMaxWidth(n1));
    }
}
