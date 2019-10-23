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
	void getRoot() {
		tree.makeTree("A", null, null);
		assertEquals("A", tree.getRootNode());
	}

	@Test
	void makeTree() {

	}

	@Test
	void traverse() {
	}

	@Test
	void setLeftNode() {
	}

	@Test
	void setRightNode() {
	}

	@Test
	void getLeftNode() {
	}

	@Test
	void getRightNode() {
	}
}