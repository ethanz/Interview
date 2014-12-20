package treeAndgraph;

import java.security.PublicKey;
//Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
//avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
//找最近的那个共同祖先，要普通binary tree可用 不一定是BST
//这也是著名的LCA问题（lowest common ancestor）
public class FindCommonAncestor4_6 {

//假如node里有指向父节点的reference。就可以一路追踪上去知道找到。（
//这里讨论不用父节点的方法
	
//首先这题分2种情况，要找的两个node在root的同一侧（同一个子树上），或者在root的不同子树上？
//所以 要有这方法 （总root的左右儿子传给这方法的root参)
	private  boolean isChild(TreeNode root, TreeNode toFind){
             if(root==null||toFind==null){return false;}
             if(root==toFind){return true;}
             return isChild(root.getLeft(), toFind)||isChild(root.getRight(), toFind); 
             //这种写法就是2个里面有一个true就true了啊
             	}
	
	
	//首先要建立的一个基础认知是，在二叉树上，如果一个节点在自己的左子树上，一个节点在自己的右子树上，
	//那么自己就是最小公共节点
	public TreeNode LCAoneside(TreeNode root, TreeNode first,TreeNode second){
		//如果first和second都在左侧
		if(isChild(root.getLeft(),first)&&isChild(root.getLeft(), second)){
			return LCAoneside(root.getLeft(),first,second);}//就把root的左儿子当新root然后recursive
		if(isChild(root.getRight(),first)&&isChild(root.getRight(), second)){
			return LCAoneside(root.getRight(),first,second);}//就把root的右儿子当新root然后recursive
		//反正这样递归能正确一层一层下去。
		//然后如果到如果一个节点在自己的左子树上，一个节点在自己的右子树上， 就跳出了2个if。就return了当前这个root 
		//如果root本来就是最小CA 那么自然也不会走着两个if 直接返回root

	return root;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
