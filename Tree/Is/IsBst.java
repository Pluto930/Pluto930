package study.Tree.Is;

import java.util.Stack;

/*
搜索二叉树   左节点比头节点小，右节点比头节点大

判断：直接中序遍历，升序即为二叉树
 */
public class IsBst {
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
                    '}';
        }
    }

    public static long preValue=Long.MIN_VALUE;

    public static boolean isBst(Node head){
        if(head==null) return true;

        boolean leftBst = isBst(head.left);  //中序遍历 然后加判断大小操作
        if(!leftBst) return false;
        if(head.value<=preValue){
            return false;
        }else{
            preValue=head.value;
        }

        return isBst(head.right);

    }

    public static boolean inOrderUnRecur(Node head){  //非递归中序  先压二叉树的左边界，然后弹出， 压入弹出的右树左边界  继续弹出  相当于 有左节点就压入，没有了弹出

        if(head !=null){
            Stack<Node> stack=new Stack<>();
            while(!stack.isEmpty() || head!=null){
                if(head!=null){   //head不等于null 就继续看他有没有左节点  直到没有 也就时head =null
                    stack.push(head);
                    head=head.left;
                }else{   //此时head = null   说明已经到最左边下面，开始弹出，弹出一个 打印  再看它有没有右树， 有则压栈 然后右树继续 判断有没有左边界
                    head=stack.pop();

                    if(head.value<=preValue){
                        return false;
                    }else{
                        preValue=head.value;
                    }

                    head=head.right;
                }
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Node n1=new Node(5);
        Node n2=new Node(3);
        Node n3=new Node(7);
        Node n4=new Node(1);
        Node n5=new Node(4);
        Node n6=new Node(8);
        n1.left=n2;
        n2.left=n4;
        n2.right=n5;
        n1.right=n3;
        n3.right=n6;

        System.out.println(isBst(n1));
    }
}
