package DataStructure.BinaryTree;

public interface BinaryTree<T> {
	boolean isEmpty();
	BinaryTreeNode getRootNode();
	T getRootNodeData();
	int nodeCount();
	int maxTreeDepth();

	void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode);
	void buildTreeFromArray(T[] array);

	void traverse(TraverseOrder strategy);

	void deleteTree();
	boolean insert(Comparable data);
	boolean remove(Comparable data);

	boolean containsValue(T value);
	BinaryTreeNode search(BinaryTreeNode root, T element);
}
