package treeAndgraph;
//二叉排序树（Binary Sort Tree）又称二叉查找树Binary Search Tree，亦称二叉搜索树。
//它或者是一棵空树；或者是具有下列性质的二叉树：
//（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
//（2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值； 
//（3）左、右子树也分别为二叉排序树；



//这题不是career cup里的 是数据结构中文那本教材里的，这算法也非常重要
//本题：输入数组的，输出BST，BST就是左到右是从小到大的
//            5
//          3    7
//         1 4  6 8
//最后这树应该说是这样子
//做法，先吧数组[0] 设为root,然后后面的元素和root比较，如果比root小，
//就判断左儿子为不为空，如果为就插入，如果不为，就在和左儿子比大小，如果比左儿子小
//就在看左孙子，如果为空就插入 不为空就再比较大小。。。以此类推。。recursive
public class implementSortedBT {

	
	public static TreeNode arrayToSortedTree(int[] raw) {

		int length = raw.length;
		if(length==0){return null;}

		TreeNode root = new TreeNode(raw[0]);
		for (int n = 1; n < length; n++) {
			insert(raw[n], root);
		}
		return root;
	}
//往bst里insert node
	public static void insert(int a, TreeNode root) {
		if (root == null) {
			return;
		}
		if (a <= root.getData()) {
			if (!root.hasLeft()) {
				TreeNode sub = new TreeNode(a);
				root.setLeft(sub);
			} else {
				root = root.getLeft();
				insert(a, root);
			}

		} else {
			if (!root.hasRight()) {
				TreeNode sub = new TreeNode(a);
				root.setRight(sub);
			} else {
				root = root.getRight();
				insert(a, root);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int raw[] = new int[] { 5,1,2,3,4,5,6,7,8,9 };
		TreeNode root = arrayToSortedTree(raw);
		//TreePrint.levelOrder(root);
	
		
	}

}
