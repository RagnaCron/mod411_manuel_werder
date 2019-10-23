package DataStructure.BinaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode {

	private Object payload;
	private BinaryTreeNode left, right;

	public BinaryTreeNode() {
		this(null);
	}

	public BinaryTreeNode(Object payload) {
		this(payload, null, null);
	}

	public  BinaryTreeNode(Object payload, BinaryTreeNode left, BinaryTreeNode right) {
		this.payload = payload;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return payload.toString();
	}
}
