package study.Tree;

public class SameTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {   //判断两个树是否相等   深度优先算法
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        return q != null && p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

}
