package DataStructure.BinaryTree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {

	private LinkedBinaryTree<String> tree;
	private final String[] array = {"A", "B", "C", "D", "E", "F", "G"};
	private String[] sortedArray;


	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
	void deleteTree() {
		tree.makeDefaultAlphabetTree();
		assertFalse(tree.isEmpty());
		tree.deleteTree();
		assertTrue(tree.isEmpty());
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
		tree.deleteTree();
		tree.buildTreeFromArray(array);
		assertEquals(3, tree.maxTreeDepth());
	}

	@Test
	void remove() {
		assertTrue(tree.insert("D"));
		assertTrue(tree.insert("F"));
		assertTrue(tree.insert("B"));
		assertTrue(tree.insert("A"));
		assertTrue(tree.insert("C"));
		assertTrue(tree.insert("G"));
		assertTrue(tree.insert("E"));

		tree.traverse(TraverseOrder.IN_ORDER);
		assertEquals("A B C D E F G ", outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		assertTrue(tree.remove("F"));
		assertEquals("G", tree.getRootNode().getRightNode().getData());
		assertEquals("E", tree.getRootNode().getRightNode().getLeftNode().getData());

		tree.traverse(TraverseOrder.IN_ORDER);
		assertEquals("A B C D E G ", outContent.toString());
	}

	@Test
	void insert() {
		assertTrue(tree.isEmpty());
		assertTrue(tree.insert("D"));
		assertFalse(tree.isEmpty());
		assertTrue(tree.insert("F"));
		assertTrue(tree.insert("B"));
		assertEquals("F", tree.getRootNode().getRightNode().getData());
		assertEquals("B", tree.getRootNode().getLeftNode().getData());
		assertTrue(tree.insert("A"));
		assertEquals("A", tree.getRootNode().getLeftNode().getLeftNode().getData());
		assertTrue(tree.insert("C"));
		assertEquals("C", tree.getRootNode().getLeftNode().getRightNode().getData());
		assertTrue(tree.insert("G"));
		assertEquals("G", tree.getRootNode().getRightNode().getRightNode().getData());
		assertTrue(tree.insert("E"));
		assertEquals("E", tree.getRootNode().getRightNode().getLeftNode().getData());
	}

	@Test
	void search() {
		tree.insert("D");
		tree.insert("B");
		tree.insert("F");
		tree.insert("A");
		tree.insert("C");
		tree.insert("E");
		tree.insert("G");

		assertEquals("A", tree.search(tree.getRootNode(),"A").getData());
		assertEquals("F", tree.search(tree.getRootNode(),"F").getData());
		assertEquals("C", tree.search(tree.getRootNode(),"C").getData());
		assertEquals("E", tree.search(tree.getRootNode(),"E").getData());

		assertNull(tree.search(tree.getRootNode(), "H"));
	}

	@Test
	void containsValue() {
		tree.makeDefaultAlphabetTree();
		assertTrue(tree.containsValue("C"));
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

	@Test
	void buildTreeFromArrayInOrderCheck() {
		tree.buildTreeFromArray(array);
		assertFalse(tree.isEmpty());
		tree.traverse(TraverseOrder.IN_ORDER);
		assertEquals("C B D A F E G ", outContent.toString());
	}

	@Test
	void buildTreeFromArrayPreOrderCheck() {
		tree.buildTreeFromArray(array);
		assertFalse(tree.isEmpty());
		tree.traverse(TraverseOrder.PRE_ORDER);
		assertEquals("A B C D E F G ", outContent.toString());
	}

	@Test
	void buildTreeFromArrayPostOrderCheck() {
		tree.buildTreeFromArray(array);
		assertFalse(tree.isEmpty());
		tree.traverse(TraverseOrder.POST_ORDER);
		assertEquals("C D B F G E A ", outContent.toString());
	}

	@Test
	void buildTreeFromArrayLevelOrderCheck() {
		tree.buildTreeFromArray(array);
		assertFalse(tree.isEmpty());
		tree.traverse(TraverseOrder.LEVEL_ORDER);
		assertEquals("A B E C D F G ", outContent.toString());
	}


}