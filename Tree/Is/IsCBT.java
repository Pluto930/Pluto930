package study.Tree.Is;

import java.util.LinkedList;
import java.util.Queue;

/*
判断完全二叉树
层序遍历  即 宽度优先遍历
①任意节点 有右无左  false
② 在①的基础上 第一次出现左右不双全的情况 那么接下来 所有的节点都是叶节点（没有左右节点）
 */
public class IsCBT {
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

    public static boolean isCTB(Node head) {
        if (head == null) return true;
        Queue<Node> queue = new LinkedList<>();   //队列 先进先出

        boolean leaf = false;  //当第一次遇见两不全  变成true 之后的节点都只能时叶节点
        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();

            if (leaf && (head.left != null || head.right != null))
                return false;   //当遇到后，leaf变为true  在判断是否有子节点 有返回false

            if (head.left == null && head.right != null) return false;  //有右无左

            if (head.left != null) queue.add(head.left);

            if (head.right != null) queue.add(head.right);

            if (head.left == null || head.right == null) leaf = true;  //经过条件一筛选，现在只要有节点为空，说明后面的节点都不满 都为叶节点
        }
        return true;
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

        System.out.println(isCTB(n1));
    }
}
