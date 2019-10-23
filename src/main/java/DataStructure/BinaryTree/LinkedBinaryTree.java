package DataStructure.BinaryTree;


import DataStructure.Queue.ArrayQueue;

public class LinkedBinaryTree implements BinaryTree {

	private static final int IN_ORDER = 1;
	private static final int PRE_ORDER = 2;
	private static final int POST_ORDER = 3;
	private static final int LEVEL_ORDER = 4;

	private BinaryTreeNode root;

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Object getRoot() {
		return isEmpty() ? null : root.getPayload();
	}

	@Override
	public void makeTree(Object root, Object left, Object right) {
		this.root = new BinaryTreeNode(
				root,
				((LinkedBinaryTree) left).root,
				((LinkedBinaryTree) right).root);
	}

	public void traverse(int strategy) {
		switch (strategy) {
			case IN_ORDER:
				printInOrder(root);
				break;
			case PRE_ORDER:
				printPreOrder(root);
				break;
			case POST_ORDER:
				printPostOrder(root);
				break;
			case LEVEL_ORDER:
				ArrayQueue<BinaryTreeNode> queue = new ArrayQueue<>();
				queue.put(root);
				printLevelOrder(queue);
				break;
			default:
		}
	}


	private void printInOrder(BinaryTreeNode node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println(node.toString());
			printInOrder(node.getRight());
		}
	}

	private void printPreOrder(BinaryTreeNode node) {
		if (node != null) {
			System.out.println(node.toString());
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	private void printPostOrder(BinaryTreeNode node) {
		if (node != null) {
			printPostOrder(node.getLeft());
			printPostOrder(node.getRight());
			System.out.println(node.toString());
		}
	}

	private void printLevelOrder(ArrayQueue<BinaryTreeNode> queue) {
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			if (node.getLeft() != null)
				queue.put(node.getLeft());
			if (node.getRight() != null)
				queue.put(node.getRight());
			System.out.println(node.toString());
		}
	}

}
