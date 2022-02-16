package study.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
二叉树的序列化和反序列化
 */
public class SerializeTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    public static String serialize(Node root) {  //先序遍历  有值就返回 值_  无就返回 #_  最后返回  1_#_5_7_#_#_#_
        if(root==null) return "#_";

        String s=root.value+"_";

        s+=serialize(root.left);
        s+=serialize(root.right);

        return s;
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {   //拿到字符串 先反序列化 分隔符_  化成数组 然后遍历到队列中
        String[] values=data.split("_");
        Queue<String> queue=new LinkedList<>();
        for(int i=0;i<values.length;i++){
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }
    public static Node reconPreOrder(Queue<String> queue){  //递归挨个创建节点
        String s=queue.poll();
        if(s.equals("#")) return null;

        Node head=new Node(Integer.valueOf(s));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);

        return head;
    }
}
