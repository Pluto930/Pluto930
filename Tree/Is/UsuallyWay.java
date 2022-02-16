package study.Tree.Is;
/*
常用套路 可判断任一树
 */
public class UsuallyWay { //实例  判断搜索树
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

    public static class ReturnType {   //搜索树 返回 左树右树是否时搜索树 最大值 最小值
        public boolean isBST;
        public int max;
        public int min;

        public ReturnType(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
    
    public static ReturnType process(Node head){
        if(head == null) return null;   //因为不确定
        
        ReturnType left=process(head.left);  //递归
        ReturnType right=process(head.right);

        int max=head.value;   //返回值
        int min=head.value;
        if(left!=null) {
            min = Math.min(left.min, min);
            max=Math.max(left.max,max);
        }
        if(right!=null){
            min = Math.min(right.min, min);
            max=Math.max(right.max,max);
        }

        boolean isBST=true;
        if(left!=null && (!left.isBST || left.max>=head.value)) isBST=false;   //左树存在 且左树时搜索树  且 左树的最大值小于本节点
        if(right!=null && (!right.isBST || right.min<=head.value)) isBST=false;

        return new ReturnType(isBST,max,min);
    }
    
    public static boolean is(Node head){
        ReturnType process=process(head);
        return process.isBST;
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

        System.out.println(is(n1));
    }
}
