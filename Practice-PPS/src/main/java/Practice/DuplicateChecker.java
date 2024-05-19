package Practice;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class DuplicateChecker {
    public static boolean hasDuplicates(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer prevVal = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (prevVal != null && current.val == prevVal) {
                return true;
            }
            prevVal = current.val;
            current = current.right;
        }

        return false;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {2, 4, 6, 8, 10, 12, 2, 2};

        for (int val : values) {
            root = insert(root, val);
        }

        if (hasDuplicates(root)) {
            System.out.println("The tree contains duplicates.");
        } else {
            System.out.println("The tree does not contain duplicates.");
        }
    }
}
