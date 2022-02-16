/*
判断是否时平衡树
左右两树的层高不能超过1

可以用递归  每次递归返回是否平衡 和层高
 */
public class IsBalancedTree {
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

    public static class ReturnType {   //返回值类型，需要用到俩值，所以直接创建返回类
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static ReturnType process(Node head) {  //套路
        if (head == null) return new ReturnType(true, 0);

        ReturnType left = process(head.left);  //递归
        ReturnType right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2);

        return new ReturnType(isBalanced, height);
    }

    public static boolean isBalanced(Node head) {
        ReturnType process = process(head);
        return process.isBalanced;
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

        System.out.println(isBalanced(n1));
    }

}
