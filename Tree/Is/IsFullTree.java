package study.Tree.Is;

public class IsFullTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFullTree(Node head){
        if(head==null) return true;
        ReturnType x=process(head);
        
        if(x.nodes!= Math.pow(2,x.height)-1) return false;   //如果总结点数 不等于 2的层数次方-1  说明不是满二叉树
        return true;

//        return x.nodes == (1 << x.height -1);    //更简单返回  2的n次方 可以写成 1 << n   -1：1 << n -1  先计算左移
    }
    
    public static ReturnType process(Node head){
        if(head==null) return new ReturnType(0,0);

        ReturnType left=process(head.left);
        ReturnType right=process(head.right);

        int height=Math.max(left.height,right.height)+1;
        int nodes= left.nodes+right.nodes+1;


        return new ReturnType(height,nodes);
    }

    private static class ReturnType{
        public int height;
        public int nodes;
        public ReturnType(int height,int node){
            this.height=height;
            this.nodes=node;
        }
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

        System.out.println(isFullTree(n1));
    }
}
