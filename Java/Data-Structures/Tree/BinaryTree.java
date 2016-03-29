package diakabana.datastructures.tree;

/**
 * Class <tt>BinaryTreeNode</tt> represents a leaf that
 * will reside in a binary tree
 * @author Bethy Diakabana
 *
 * @param <T> node type
 */
class BinaryTreeNode<T extends Comparable<T>> {
	BinaryTreeNode<T> leftNode; 
	T nodeData;
	BinaryTreeNode<T> rightNode;
	
	
	/**
	 * Constructs a <tt>BinaryTreeNode</tt> object
	 * by initializing data, and makes it the root 
	 * of the tree
	 * @param nodeData node entry
	 */
	public BinaryTreeNode(T nodeData) {
		this.nodeData = nodeData;
		leftNode = rightNode = null; // no children
	} // end constructor
	
	/**
	 * Locates a point and inserts a new node
	 * @param nodeData data to be inserted 
	 */
	public void insert(T dataToInsert) {
		if (dataToInsert.compareTo(nodeData) < 0) {
			if (leftNode == null)
				leftNode = new BinaryTreeNode<T>(dataToInsert);
			else 
				leftNode.insert(dataToInsert);	
		} else if (dataToInsert.compareTo(nodeData) > 0) {
			if (rightNode == null)
				rightNode = new BinaryTreeNode<T>(dataToInsert);
			else
				rightNode.insert(dataToInsert);
		} // end if
	} // end method insert	
} // end class BinaryTreeNode


/**
 * Class <tt>BinaryTree</tt> constructs a two dimensional tree
 * which consists of <tt>BinaryTreeNode</tt> objects
 * @author Bethy Diakabana
 *
 * @param <T> Integer, Double, or Float
 */
public class BinaryTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root;
	
	/**
	 * Constructs a new <tt>BinaryTree</tt> object with an empty 
	 * root
	 */
	public BinaryTree() {
		root = null;
	} // end constructor
	
	/**
	 * Adds a lead to the root of a <tt>BinaryTree</tt>. 
	 * If the root node is null, then the first data 
	 * object will be the root node
	 * @param data
	 */
	public void insertLeaf(T data) {
		if (root == null) 
			root = new BinaryTreeNode<T>(data);
		else
			root.insert(data);
	} // end method insertLeaf
	
	public int getHeight() {
		return getLeafHeight(root);
	} // end method getHeight
	
	private int getLeafHeight(BinaryTreeNode<T> leaf) {
		int height = 0;
		if (leaf != null) {
			height = 1 + Math.max(getLeafHeight(leaf.leftNode), getLeafHeight(leaf.rightNode));
		} // end if
		return height;
	} // end method getLeafHeight

	/**
	 * Performs pre-order traversal by calling the 
	 * private method <tt>preorderTraversal</tt> which 
	 * will begin from the root
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	} // end method PreorderTraversal
	
	/**
	 * Performs pre-order traversal starting from the root 
	 * @param node binary tree leaf
	 */
	private void preorderTraversal(BinaryTreeNode<T> node) {
		if (node != null) {
			System.out.printf("%s ", node.nodeData);
			preorderTraversal(node.leftNode);
			preorderTraversal(node.rightNode);
		} // end if
	} // end method preorderTraversal
	
	/**
	 * Performs inorder traversal by calling the 
	 * private method <tt>inorderTraversal</tt> which 
	 * will begin from the root
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	} // end method inorderTraversal
	
	/**
	 * Performs inorder traversal starting from the root 
	 * @param node binary tree leaf
	 */
	private void inorderTraversal(BinaryTreeNode<T> node) {
		if (node != null) {
			inorderTraversal(node.leftNode);
			System.out.printf("%s ", node.nodeData);
			inorderTraversal(node.rightNode);
		} // end if
	} // end private method inorderTraversal
	
	/**
	 * Performs post-order traversal by calling the 
	 * private method <tt>postorderTraversal</tt> which 
	 * will begin from the root
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	} // end method postorderTraversal
	
	/**
	 * Performs post-order traversal starting from the root 
	 * @param node binary tree leaf
	 */
	private void postorderTraversal(BinaryTreeNode<T> node) {
		if (node != null) {
			postorderTraversal(node.leftNode);
			postorderTraversal(node.rightNode);
			System.out.printf("%s ", node.nodeData);
		} // end if
	} // end private method postorderTraversal
}
