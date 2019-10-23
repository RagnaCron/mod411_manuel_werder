package DataStructure.BinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {

	private LinkedBinaryTree<String> tree;

	@BeforeEach
	void setUp() {
		tree = new LinkedBinaryTree<>();
	}

	@Test
	void isEmpty() {
		assertTrue(tree.isEmpty());
		tree.makeTree("A", null, null);
		assertFalse(tree.isEmpty());
	}

	@Test
	void getNodeData() {
		tree.makeTree("A", null, null);
		assertEquals("A", tree.getRootNodeData());
	}

	@Test
	void getRootNode() {
		assertNull(tree.getRootNode());
		tree.makeTree("Root", null, null);
		BinaryTreeNode node = tree.getRootNode();
		assertNotNull(node);
	}

	@Test
	void setRootNodeLeftNode() {
		assertNull(tree.getRootNode());
		tree.makeTree("Root", null, null);
		BinaryTreeNode node = tree.getRootNode();
		assertNotNull(node);
		assertNull(node.getLeftNode());
		node.setLeftNode(new BinaryTreeNode<>("Left"));
		assertNotNull(node.getLeftNode());
		assertEquals("Left", node.getLeftNode().getData());
	}

	@Test
	void setRootNodeRightNode() {
		assertNull(tree.getRootNode());
		tree.makeTree("Root", null, null);
		BinaryTreeNode node = tree.getRootNode();
		assertNotNull(node);
		assertNull(node.getRightNode());
		node.setRightNode(new BinaryTreeNode<>("Right"));
		assertNotNull(node.getRightNode());
		assertEquals("Right", node.getRightNode().getData());
	}

	@Test
	void makeTree() {
		assertDoesNotThrow(() -> tree.makeTree("Root", null, null));
		assertEquals("Root", tree.getRootNodeData());
	}

	@Test
	void traverseInOrder() {
		tree.makeTree("Root", new BinaryTreeNode<>("Left"), new BinaryTreeNode<>("Right"));
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.IN_ORDER));
	}

	@Test
	void traversePreOrder() {
		tree.makeTree("Root", new BinaryTreeNode<>("Left"), new BinaryTreeNode<>("Right"));
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.PRE_ORDER));
	}

	@Test
	void traversePostOrder() {
		tree.makeTree("Root", new BinaryTreeNode<>("Left"), new BinaryTreeNode<>("Right"));
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.POST_ORDER));
	}

	@Test
	void traverseLevelOrder() {
		tree.makeTree("Root", new BinaryTreeNode<>("Left"), new BinaryTreeNode<>("Right"));
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.LEVEL_ORDER));
	}

}