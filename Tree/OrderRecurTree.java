package study.Tree;

import java.util.Stack;

/*
遍历
递归：先序 中序 后序
非递归： 先序 中序 后序

栈:stack
队列：LinkedList
 */
public class OrderRecurTree {
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int data){
            this.value=data;
        }
    }

    public static void forTree(Node head){   //递归序
        if(head == null) return;
        //1先序   在这里添加代码   头 左 右

        forTree(head.left);
        //2 中序  在这里添加代码   左 头 右

        forTree(head.right);
        //3  后序    左 右 头
    }

    public static void preOrderRecur(Node head){   //先序遍历
        if(head == null) return;

        System.out.println(head.value+" ");

        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){   //中序遍历
        if(head == null) return;

        preOrderRecur(head.left);
        System.out.println(head.value+" ");

        preOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){   //后序遍历
        if(head == null) return;

        preOrderRecur(head.left);

        preOrderRecur(head.right);
        System.out.println(head.value+" ");
    }

    public static void preOrderUnRecur(Node head){  //非递归先序  利用栈的先入后出  先弹出一个，打印，压右 压左
        System.out.println("pre-order: ");
        if(head !=null){
            Stack<Node> stack=new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                head=stack.pop();  //①弹出

                System.out.println(head.value+" ");  //②打印

                if(head.right!=null){   //③ 压右左子节点，若无，则不操作
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head){  //非递归中序  先压二叉树的左边界，然后弹出， 压入弹出的右树左边界  继续弹出  相当于 有左节点就压入，没有了弹出
        System.out.println("pre-order: ");
        if(head !=null){
            Stack<Node> stack=new Stack<>();
            while(!stack.isEmpty() || head!=null){
                if(head!=null){   //head不等于null 就继续看他有没有左节点  直到没有 也就时head =null
                    stack.push(head);
                    head=head.left;
                }else{   //此时head = null   说明已经到最左边下面，开始弹出，弹出一个 打印  再看它有没有右树， 有则压栈 然后右树继续 判断有没有左边界
                    head=stack.pop();
                    System.out.println(head.value+" ");
                    head=head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur(Node head){  //非递归后序  利用栈的先入后出  先弹出一个，入收集栈，压左 压右   最后整体弹出
        System.out.println("pre-order: ");
        if(head !=null){
            Stack<Node> stack1=new Stack<>();
            Stack<Node> stack2=new Stack<>();   //收集栈
            stack1.add(head);
            while(!stack1.isEmpty()){
                head=stack1.pop();       //①弹出

                stack2.push(head);      //②压栈

                if(head.left!=null){        //③ 压左右子节点，若无，则不操作
                    stack1.push(head.left);
                }
                if(head.right!=null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.println(stack2.pop().value+" ");
            }
        }
        System.out.println();
    }
}

