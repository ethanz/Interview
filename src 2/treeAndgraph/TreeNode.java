package treeAndgraph;

import java.io.NotActiveException;

import org.omg.CORBA.PRIVATE_MEMBER;

public class TreeNode {
	private TreeNode left = null;
	private TreeNode right = null;
	private int data;

	public TreeNode(int d) {
		data = d;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int a) {
		this.data = a;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public boolean isLeaf(TreeNode t) {
		if (this.left == t || this.right == t) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasLeaf() {
		if (this.left == null && this.right == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasLeft() {
		if (this.left == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasRight() {
		if (this.right == null) {
			return false;
		} else {
			return true;
		}
	}

	// ����node
	// ����ʵ������preoder traverse
	public static TreeNode findBT(TreeNode root, int a) {
		if (root == null) {
			return null;
		} else {// object Ҫequals
			if (root.data == a) {
				return root;
			} else {
				TreeNode left = findBT(root.getLeft(), a);
				TreeNode right = findBT(root.getRight(), a);
				if (left != null) {
					return left;
				}
				if (left == null && right != null) {
					return right;
				} else {
					return null;
				}
			}
		}
	}

	// public static TreeNode findBT(TreeNode root, TreeNode toFind) {
	//
	// if (root == null) {
	// return null;
	// } else {
	// if (root.equals(toFind)) {
	// //return height
	// return root;
	// } else {
	// TreeNode left = findBT(root.getLeft(), toFind);
	//
	// TreeNode right = findBT(root.getRight(), toFind);
	// if (left != null) {
	// return left;
	// }
	// if (left == null && right != null) {
	// return right;
	// } else {
	// return null;
	// }
	// }
	// }
	// }
	// ��Ԫ�����ڲ���������ж����ͬ�� ��������Ǹ�
	public static int findlevel(TreeNode root, int toFind) {
		int level = 1;
		return findLevel(root, toFind, level);

	}

	private static int findLevel(TreeNode root, int toFind, int level) {
		if (root == null) {
			int notFound = -1;
			return notFound;
		}
		if (root.getData() == toFind) {
			return level;
		}
		int left = findLevel(root.getLeft(), toFind, level + 1);
		int right = findLevel(root.getRight(), toFind, level + 1);
		if (left != -1 || right != -1) {
			return left > right ? left : right;
		}
		int notFound = -1;
		return notFound;
	}


	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));  //ÿ�ݹ�һ��+1��
		//��ײ�᷵��0��������һ�㣬Ȼ������һ��᷵��1+0�������ڶ��㣬Ȼ�����ڶ��λ᷵��2�����������㡣����󷵻�N�����õķ���
	}



}



// ��ΪBST������� ���Կ�����ô��
// public static TreeNode findBST(TreeNode root, int a) {
// TreeNode found;
// if (root == null) {
// found=null;
// } else {// object Ҫequals
// if (root.getData() == a) {
// found=root;
// } else {
//
// if (a < root.data) {
// found= findBST(root.getLeft(), a);
// } else {
// found= findBST(root.getRight(), a);
//
// }
// }
//
// }
// return found;
// }

// public static TreeNode deleteBST(TreeNode root, int a){
// if(root==null||root.getData()==a){System.out.print("you cannot delete this Node  "
// +a) ;}
// else{
// boolean flag=findBST(root, a).hasLeaf();
// if(flag==false){findBST(root, a)=null;}
// }
//
// }
