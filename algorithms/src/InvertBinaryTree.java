/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(7);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(9);

        System.out.print("Before inverting binary tree: ");
        printTree(root);
        System.out.println();
        TreeNode<Integer> invertedTree = invertTree(root);
        System.out.print("After inverting binary tree:  ");
        printTree(invertedTree);
    }

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if(root == null) return null;

        TreeNode<Integer> left = invertTree(root.left);
        TreeNode<Integer> right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    public static void printTree(TreeNode<Integer> root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
