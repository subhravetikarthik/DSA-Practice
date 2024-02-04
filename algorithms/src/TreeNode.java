public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
