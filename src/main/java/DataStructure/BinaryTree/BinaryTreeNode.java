package DataStructure.BinaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode<T> {

	private T payload;
	private BinaryTreeNode leftNode, rightNode;

	public BinaryTreeNode() {
		this(null);
	}

	public BinaryTreeNode(T payload) {
		this(payload, null, null);
	}

	public  BinaryTreeNode(T payload, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		this.payload = payload;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return payload.toString();
	}
}
