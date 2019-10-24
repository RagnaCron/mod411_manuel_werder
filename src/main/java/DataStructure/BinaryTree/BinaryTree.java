package DataStructure.BinaryTree;

public interface BinaryTree<T extends Comparable<T>> {
	void deleteTree();
	boolean isEmpty();
	BinaryTreeNode getRootNode();
	T getRootNodeData();
	void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode);
	void buildTreeFromArray(T[] array);
	void traverse(TraverseOrder strategy);
	int nodeCount();
	int maxTreeDepth();
	boolean find(T value);
	BinaryTreeNode findNode(T data);
}
