
import java.util.Scanner;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		Tree t = new Tree();
		while(true) {
			String a = br.readLine();
			if(a == null) {
				break;
			}
			int p = Integer.parseInt(a);
			t.makeRootNode(new Node(p));
		}
		t.postOrder(t.root);
	}
}

class Tree{
	Node root;
	public void makeRootNode(Node node) {
		if(root == null) {
			root = node;
		}
		else {
			makeNode(root, node);
		}
	}
	public void makeNode(Node node, Node newNode) {
		if(node.data < newNode.data) {
			if(node.right == null) {
				node.right = newNode;
			}
			else {
				makeNode(node.right, newNode);
			}
		}
		else {
			if(node.left == null) {
				node.left = newNode;
			}
			else {
				makeNode(node.left, newNode);
			}
		}
	}
	public void postOrder(Node node) {
		if(node.left != null) {
			postOrder(node.left);
		}
		if(node.right != null) {
			postOrder(node.right);
		}
		System.out.println(node.data);
	}
}
class Node{
	Node left, right;
	int data;
	
	Node(int data){
		this.data = data;
	}
}