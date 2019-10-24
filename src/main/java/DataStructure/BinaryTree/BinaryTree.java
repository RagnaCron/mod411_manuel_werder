package DataStructure.BinaryTree;

public interface BinaryTree<T> {
	boolean isEmpty();
	BinaryTreeNode getRootNode();
	T getRootNodeData();
	void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode);
	void traverse(int strategy);
	int nodeCount();
	int maxTreeDepth();
}
