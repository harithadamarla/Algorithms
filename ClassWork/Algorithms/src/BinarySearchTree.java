//test
//Question:Implement a Binary Search Tree data structure which supports the followingqueries:•insert(item)- Insertsiteminto the tree.•contains(item)- Returns True ifitemis in the tree, otherwise False.•print()-  Prints  elements  of  the  tree  inorder.    (python  users  shouldchange the name of this function to something else)•size()- Returns the number of nodes in the tree.•smallest()- Returns the smallest element in the tree.•largest()- Returns the largest element in the tree.Discuss the Best and Worst case time and space complexities of all the queries.2.  Using the previously constructed BST class, write a function greaterSumTree()which  transforms  the  tree  such  that  each  node  contains  sum  of  all  nodesgreater than that node.  Analyze its time and space complexities.  In addition,call print() on the tree before and after you perform greaterSumTree() andinclude it in the discussion
//input: input.txt
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
class Node1 {
	Node1 left;
	Node1 right;
	int data;

	public Node1(int data, Node1 left, Node1 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class Sum {
	int sum = 0;
}

public class BinarySearchTree {
	Node1 root;
	Sum s = new Sum();

	BinarySearchTree() {
		root = null;
	}

	void insert(Node1 newNode) {
		Node1 root = this.getroot();

		if (root == null) {
			this.root = newNode;
			return;
		}

		Node1 current = root;
		Node1 parent = null;

		while (true) {
			parent = current;
			if (newNode.data < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	private Node1 treeSearch(int i) {
		Node1 n = treeSearch(this.getroot(), i);
		return n;
	}

	private static Node1 treeSearch(Node1 root, int i) {

		if (root == null || i == root.data)
			return root;

		if (i < root.data) {
			return treeSearch(root.left, i);
		} else {
			return treeSearch(root.right, i);
		}

	}

	private Node1 getroot() {
		// TODO Auto-generated method stub
		return this.root;
	}

	private static void printInOrder(Node1 r) {
		// TODO Auto-generated method stub
		if (r != null) {
			printInOrder(r.left);
			System.out.println(r.data);
			printInOrder(r.right);
		}
	}

	private static int treesize(Node1 root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		} else {
			return treesize(root.left) + 1 + treesize(root.right);
		}
	}

	private static Node1 treeMinimum(Node1 min) {
		// TODO Auto-generated method stub
		while (min.left != null) {
			min = min.left;
		}
		return min;
	}

	private static Node1 treeMaximum(Node1 max) {
		// TODO Auto-generated method stub
		while (max.right != null) {
			max = max.right;
		}
		return max;
	}

	private Node1 greaterSumTree(Node1 root) {
		// TODO Auto-generated method stub
		constructNewTree(root, s);
		return root;
	}

	private static void constructNewTree(Node1 root, Sum ptr_sum) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		constructNewTree(root.right, ptr_sum);
		ptr_sum.sum = ptr_sum.sum + root.data;

		root.data = ptr_sum.sum-root.data;
		constructNewTree(root.left, ptr_sum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		// reading input from a file and constructing a tree
		String filename = "input.txt";
		File f = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(f));

		String line;
		while ((line = br.readLine()) != null) {
			String values[] = line.split(",");
			for (String str : values) {
				Node1 newNode = new Node1(Integer.parseInt(str), null, null);
				// bst.insert(bst.getroot(), newNode);
				bst.insert(newNode);
				// bst.insert(Integer.parseInt(str));
			}

		}
		// call the functions
		printInOrder(bst.getroot());
		Node1 n = bst.treeSearch(11);
		if (n != null) {
			System.out.println("found");

		} else {
			System.out.println("notfound");
		}

		Node1 min = treeMinimum(bst.getroot());
		System.out.println("minimum value node=" + min.data);

		Node1 max = treeMaximum(bst.getroot());
		System.out.println("maximum value node=" + max.data);

		int size = treesize(bst.getroot());
		System.out.println("size of the tree is " + size);

		System.out.println("--------------------------------------------------------");
		System.out.println("Before--------------------------------------------------------");

		printInOrder(bst.getroot());

		bst.greaterSumTree(bst.getroot());

		System.out.println("After..........................................................");
		printInOrder(bst.getroot());
	}
}
