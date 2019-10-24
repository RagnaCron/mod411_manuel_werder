package DataStructure.BinaryTree;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("all")
@Getter
@Setter
public class BinaryTreeNode<T extends Comparable<T>> {

	private T data;
	private BinaryTreeNode leftNode, rightNode;

	BinaryTreeNode() {
		this(null);
	}

	BinaryTreeNode(T data) {
		this(data, null, null);
	}

	BinaryTreeNode(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	int compareDataTo(Comparable c) {
		return data == null ? -1 : ((Comparable) data).compareTo(c);
	}

}
