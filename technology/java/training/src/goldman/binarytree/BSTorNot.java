/**
 * 
 */
package goldman.binarytree;

import static goldman.binarytree.BinaryTreeUtil.heightOfTree;
import static goldman.binarytree.BinaryTreeUtil.spiralOrderTraversal;

/**
 * @author AR350758 BSTorNot.java Aug 20, 2019 5:06:47 PM
 */
public class BSTorNot {

	/**
	 * @param tree
	 * @return
	 */
	private static boolean isBST(Node root, int leftData, int rightData) {
		if (root == null)
			return true;

		if ((leftData > root.key) || (rightData < root.key)) {
			return false;
		}

		return isBST(root.left, leftData, root.key - 1) && isBST(root.right, root.key + 1, rightData);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println(isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(heightOfTree(tree.root));

		BinaryTree tree1 = new BinaryTree();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(7);
		tree1.root.left.right = new Node(6);
		tree1.root.right.left = new Node(5);
		tree1.root.right.right = new Node(4);

		System.out.println(isBST(tree1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(heightOfTree(tree1.root));
		spiralOrderTraversal(tree1.root);
		System.out.println();
		spiralOrderTraversal(tree1.root);
	}

}
