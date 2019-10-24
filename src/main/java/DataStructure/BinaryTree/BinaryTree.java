package DataStructure.BinaryTree;

public interface BinaryTree<T> {
	void deleteTree();
	boolean isEmpty();
	BinaryTreeNode getRootNode();
	T getRootNodeData();
	void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode);
	void buildTreeFromArray(T[] array);
	void traverse(TraverseOrder strategy);
	int nodeCount();
	int maxTreeDepth();

//	void searchAndInsert(BinaryTreeNode node, T Data);
	boolean find(T value);
	BinaryTreeNode findNode(T data);
}
