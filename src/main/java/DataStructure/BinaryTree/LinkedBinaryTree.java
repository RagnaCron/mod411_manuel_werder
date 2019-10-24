package DataStructure.BinaryTree;


import DataStructure.Queue.ArrayQueue;

public class LinkedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

	private BinaryTreeNode<T> rootNode;

	@Override
	public void deleteTree() {
		if (!isEmpty()) rootNode = null;
	}

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
	public boolean find(T data) {
		return (findNode(data) != null);
	}

	@Override
	public BinaryTreeNode findNode(T data) {
		if (isEmpty()) return null;
		return searchNode(rootNode, data);
	}

	private BinaryTreeNode searchNode(BinaryTreeNode node, T data) {
		if (node == null) return null;
		int cmp = data.compareTo((T) node.getData());
		if (cmp == 0) return node;
		if (cmp < 0)
			return searchNode(node.getLeftNode(), data);
		return searchNode(node.getRightNode(), data);
	}

//	if (node == null) return null;
//	T d = (T) node.getData();
//		if (d.compareTo(data) == 0)
//			return node;
//		else if (d.compareTo(data) < 0)
//			return searchNode(node.getLeftNode(), data);
//		else
//				return searchNode(node.getRightNode(), data);

	//		BinaryTreeNode n = node;
//		while (n != null) {
//			int cmp = data.compareTo((T) n.getData());
//			if (cmp == 0)
//				return n;
//			else
//				n = (cmp < 0 ? n.getLeftNode() : n.getRightNode());
//		}
//		return null;

	@Override
	public void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.rootNode = new BinaryTreeNode<>(data, leftNode, rightNode);
	}

	private static int position = 0;
	@Override
	public void buildTreeFromArray(T[] array) {
		if (isEmpty()) {
			position = 0;
			rootNode = buildArray(array, array.length);
		}
	}

	private BinaryTreeNode buildArray(T[] array, int size) {
		if (array == null || size == 0) return null;
		int sizeLeft = size / 2;
		int sizeRight = size - sizeLeft - 1;
		BinaryTreeNode newNode = new BinaryTreeNode<T>(array[position++]);
		newNode.setLeftNode(buildArray(array, sizeLeft));
		newNode.setRightNode(buildArray(array, sizeRight));
		return newNode;
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
	public void traverse(TraverseOrder strategy) {
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
			System.out.print(node.toString() + " ");
			printInOrder(node.getRightNode());
		}
	}

	private void printPreOrder(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.toString() + " ");
			printPreOrder(node.getLeftNode());
			printPreOrder(node.getRightNode());
		}
	}

	private void printPostOrder(BinaryTreeNode node) {
		if (node != null) {
			printPostOrder(node.getLeftNode());
			printPostOrder(node.getRightNode());
			System.out.print(node.toString() + " ");
		}
	}

	private void printLevelOrder(ArrayQueue<BinaryTreeNode> queue) {
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			if (node.getLeftNode() != null)
				queue.put(node.getLeftNode());
			if (node.getRightNode() != null)
				queue.put(node.getRightNode());
			System.out.print(node.toString() + " ");
		}
	}

}
