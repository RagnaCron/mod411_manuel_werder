package DataStructure.BinaryTree;


import DataStructure.Queue.ArrayQueue;

// In this work, is a lot of code that comes from different people.
// I do not claim ownership of this code, that other people have written.
// I have not included links to the works of other.
// It is a simple work of study, and not meant for the productive environment.

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
	public boolean insert(Comparable data) {
		if (isEmpty()) {
			rootNode = new BinaryTreeNode(data);
			return true;
		}
		BinaryTreeNode parent = null;
		BinaryTreeNode child = rootNode;
		while (child != null) {
			parent = child;
			int cmp = child.compareDataTo((T) data);
			if (cmp == 0)
				return false;
			else
				child = (cmp > 0 ? child.getLeftNode() : child.getRightNode());
		}
		BinaryTreeNode<T> node = new BinaryTreeNode<>((T) data);
		if (parent.compareDataTo(data) > 0)
			parent.setLeftNode(node);
		else
			parent.setRightNode(node);
		return true;
	}

	@Override
	public boolean remove(Comparable data) {
		if (isEmpty()) return false;
		BinaryTreeNode parent = new BinaryTreeNode();
		BinaryTreeNode node = rootNode;
		BinaryTreeNode child = null;
		BinaryTreeNode tmp = null;
		while (node != null)  {
			int cmp = node.compareDataTo(data);
			if (cmp == 0) {
				break;
			}
			else {
				parent = node;
				node = (cmp > 0 ? node.getLeftNode() : node.getRightNode());
			}
		}
		if (node == null) // No node found
			return false;
		// Case 1
		if (node.isLeftNodeNull() && node.isRightNodeNull())
			child = null;
		// Case 2
		else if (node.isLeftNodeNull())
			child = node.getRightNode();
		else if (node.isRightNodeNull())
			child = node.getLeftNode();
		else {
			// Case 3
			// Smallest Element search
			child = node.getRightNode();
			tmp = node;
			while (!child.isLeftNodeNull()) {
				tmp = child;
				child = child.getLeftNode();
			}
			child.setLeftNode(node.getLeftNode());
			if (tmp != node) {
				tmp.setLeftNode(child.getRightNode());
				child.setRightNode(node.getRightNode());
			}
		}
		if (parent.getLeftNode() == node)
			parent.setLeftNode(child);
		else
			parent.setRightNode(child);
		return true;
	}


	@Override
	public boolean containsValue(T data) {
		return (search(rootNode, data) != null);
	}

	@Override
	public BinaryTreeNode search(BinaryTreeNode root, T element) {
		while (root != null) {
			int cmp = root.compareDataTo(element);
			if (cmp == 0) return root;
			else root = (cmp > 0 ? root.getLeftNode() : root.getRightNode());
		}
		return null;
	}

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

	// Create Tree form array, Niklaus Wirth algorithm
	private BinaryTreeNode<T> buildArray(T[] array, int size) {
		if (array == null || size == 0) return null;
		int sizeLeft = size / 2;
		int sizeRight = size - sizeLeft - 1;
		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(array[position++]);
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
			if (!node.isLeftNodeNull())
				queue.put(node.getLeftNode());
			if (!node.isRightNodeNull())
				queue.put(node.getRightNode());
			System.out.print(node.toString() + " ");
		}
	}

}
