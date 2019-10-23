package DataStructure.BinaryTree;

public interface BinaryTree<T> {
	boolean isEmpty();
	T getRootNode();
	void makeTree(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode);
	void traverse(int strategy);
	BinaryTreeNode<T> getRightNode();
	BinaryTreeNode<T> getLeftNode();
	void setLeftNode(BinaryTreeNode<T> leftNode);
	void setRightNode(BinaryTreeNode<T> rightNode);
}
