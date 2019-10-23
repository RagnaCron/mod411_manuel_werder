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
	void makeDefaultAlphabetTree() {
		tree.makeDefaultAlphabetTree();
		assertEquals("A", tree.getRootNodeData());
		assertEquals("B", tree.getRootNode().getLeftNode().getData());
		assertEquals("D", tree.getRootNode().getLeftNode().getLeftNode().getData());
		assertEquals("E", tree.getRootNode().getLeftNode().getRightNode().getData());
		assertEquals("C", tree.getRootNode().getRightNode().getData());
		assertEquals("F", tree.getRootNode().getRightNode().getLeftNode().getData());
		assertEquals("G", tree.getRootNode().getRightNode().getRightNode().getData());
	}

	@Test
	void traverseInOrder() {
		tree.makeDefaultAlphabetTree();
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.IN_ORDER));
	}

	@Test
	void traversePreOrder() {
		tree.makeDefaultAlphabetTree();
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.PRE_ORDER));
	}

	@Test
	void traversePostOrder() {
		tree.makeDefaultAlphabetTree();
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.POST_ORDER));
	}

	@Test
	void traverseLevelOrder() {
		tree.makeDefaultAlphabetTree();
		assertDoesNotThrow(() -> tree.traverse(LinkedBinaryTree.LEVEL_ORDER));
	}


}