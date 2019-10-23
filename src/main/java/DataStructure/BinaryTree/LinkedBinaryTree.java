package DataStructure.BinaryTree;


import DataStructure.Queue.ArrayQueue;

public class LinkedBinaryTree<T> implements BinaryTree<T> {

	public static final int IN_ORDER = 1;
	public static final int PRE_ORDER = 2;
	public static final int POST_ORDER = 3;
	public static final int LEVEL_ORDER = 4;

	private BinaryTreeNode rootNode;

	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	@Override
	public T getRootNode() {
		return isEmpty() ? null : (T) rootNode.getPayload();
	}

	@Override
	public void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.rootNode = new BinaryTreeNode(data, leftNode, rightNode);
	}

	@Override
	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		rootNode.setLeftNode(leftNode);
	}

	@Override
	public void setRightNode(BinaryTreeNode<T> rightNode) {
		rootNode.setRightNode(rightNode);
	}

	@Override
	public BinaryTreeNode getLeftNode() {
		return rootNode.getLeftNode();
	}

	@Override
	public BinaryTreeNode getRightNode() {
		return rootNode.getRightNode();
	}

	@Override
	public void traverse(int strategy) {
		switch (strategy) {
			case IN_ORDER:
				printInOrder(rootNode);
				break;
			case PRE_ORDER:
				printPreOrder(rootNode);
				break;
			case POST_ORDER:
				printPostOrder(rootNode);
				break;
			case LEVEL_ORDER:
				ArrayQueue<BinaryTreeNode> queue = new ArrayQueue<>();
				queue.put(rootNode);
				printLevelOrder(queue);
				break;
			default:
		}
	}

	private void printInOrder(BinaryTreeNode node) {
		if (node != null) {
			printInOrder(node.getLeftNode());
			System.out.println(node.toString());
			printInOrder(node.getRightNode());
		}
	}

	private void printPreOrder(BinaryTreeNode node) {
		if (node != null) {
			System.out.println(node.toString());
			printPreOrder(node.getLeftNode());
			printPreOrder(node.getRightNode());
		}
	}

	private void printPostOrder(BinaryTreeNode node) {
		if (node != null) {
			printPostOrder(node.getLeftNode());
			printPostOrder(node.getRightNode());
			System.out.println(node.toString());
		}
	}

	private void printLevelOrder(ArrayQueue<BinaryTreeNode> queue) {
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			if (node.getLeftNode() != null)
				queue.put(node.getLeftNode());
			if (node.getRightNode() != null)
				queue.put(node.getRightNode());
			System.out.println(node.toString());
		}
	}

}
