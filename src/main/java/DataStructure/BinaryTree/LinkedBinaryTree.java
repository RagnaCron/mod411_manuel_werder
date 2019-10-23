package DataStructure.BinaryTree;

public class LinkedBinaryTree implements BinaryTree {

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

}
