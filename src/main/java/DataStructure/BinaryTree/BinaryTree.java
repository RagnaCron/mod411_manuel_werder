package DataStructure.BinaryTree;

public interface BinaryTree {
	public boolean isEmpty();
	public Object getRoot();
	public void makeTree(Object root, Object left, Object right);
	public void traverse(int strategy);
}
