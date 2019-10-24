package DataStructure.BinaryTree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {

	private LinkedBinaryTree<String> tree;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	void setUp() {
		tree = new LinkedBinaryTree<>();

		System.setOut(new PrintStream(outContent));
	}

	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void restoreStreams() {
		System.setOut(originalOut);
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
	void nodeCount() {
		tree.makeDefaultAlphabetTree();
		assertEquals(7, tree.nodeCount());
	}

	@Test
	void maxTreeDepth() {
		tree.makeDefaultAlphabetTree();
		assertEquals(3, tree.maxTreeDepth());
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
		String expected = "D B E A F C G ";
		tree.traverse(TraverseOrder.IN_ORDER);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void traversePreOrder() {
		tree.makeDefaultAlphabetTree();
		String expected = "A B D E C F G ";
		tree.traverse(TraverseOrder.PRE_ORDER);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void traversePostOrder() {
		tree.makeDefaultAlphabetTree();
		String expected = "D E B F G C A ";
		tree.traverse(TraverseOrder.POST_ORDER);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void traverseLevelOrder() {
		tree.makeDefaultAlphabetTree();
		String expected = "A B C D E F G ";
		tree.traverse(TraverseOrder.LEVEL_ORDER);
		assertEquals(expected, outContent.toString());
	}

}