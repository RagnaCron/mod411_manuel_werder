package DataStructure.BinaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode leftNode, rightNode;

	public BinaryTreeNode() {
		this(null);
	}

	public BinaryTreeNode(T data) {
		this(data, null, null);
	}

	public  BinaryTreeNode(T data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
