package DataStructure.BinaryTree;


import DataStructure.Queue.ArrayQueue;

public class LinkedBinaryTree<T> implements BinaryTree<T> {

	static final int IN_ORDER = 1;
	static final int PRE_ORDER = 2;
	static final int POST_ORDER = 3;
	static final int LEVEL_ORDER = 4;

	private BinaryTreeNode<T> rootNode;

	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	@Override
	public BinaryTreeNode getRootNode() {
		return isEmpty() ? null : rootNode;
	}

	@Override
	public T getRootNodeData() {
		return isEmpty() ? null : rootNode.getData();
	}

	@Override
	public int nodeCount() {
		if (isEmpty()) return 0;
		return count(rootNode);
	}

	private int count(BinaryTreeNode node) {
		if (node == null) return 0;
		return 1 + count(node.getLeftNode()) + count(node.getRightNode());
	}

	@Override
	public int maxTreeDepth() {
		if (isEmpty()) return 0;
		return depth(rootNode);
	}

	private int depth(BinaryTreeNode node) {
		if (node == null) return 0;
		int leftHeight = depth(node.getLeftNode());
		int rightHeight = depth(node.getRightNode());
		return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	}

	@Override
	public void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.rootNode = new BinaryTreeNode<>(data, leftNode, rightNode);
	}

	@SuppressWarnings("unchecked")
	void makeDefaultAlphabetTree() {
		this.makeTree(
				(T) "A",
				new BinaryTreeNode<>("B",
						new BinaryTreeNode<>("D"),
						new BinaryTreeNode<>("E")),
				new BinaryTreeNode<>("C",
						new BinaryTreeNode<>("F"),
						new BinaryTreeNode<>("G"))
		);
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
