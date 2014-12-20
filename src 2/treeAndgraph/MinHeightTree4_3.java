package treeAndgraph;


//Given a sorted (increasing order) array,
//write an algorithm to create a binary tree with minimal height.
//ps:虽然题目里没要求是BST， 但是按照题目给的答案 做完还会是BST 所以我们就按照BST来做
//最小高度意味着什么，意味着在 在能装满的情况下都装满。再去发展新的一层
//尝试建立这样一个二叉树，对于每一个结点，他左分支的结点总数与右分支的结点总数一致。 
//

//所以可以先找出数组“中点”的当root,再把比他小的放左边，比他大的放右边。
//这样除了root之外 不是有 大小，2个数组了吗（对应左右子树）。 再把小的“中点” 当左子树的root。
//把大的数组的“中点”当作右子树的root，以此类推  。这反映了“分而治之”的方法 ， 
//把数组个分割出来的”数组“与二叉树和他的”左右子树“和”左右子树的子树“对应了起来
//可以用递归来做
public class MinHeightTree4_3 {
public static TreeNode addToBST(int[] a,int begin, int end){
	//为了防止stackoverflow（无限递归）要检查这些下标（分割到end=begin 就说明无法再分了，就一个int了）
	if(end<begin){return null;}
	
	//begin 和end和 mid是数组下标
	int mid =(begin+end)/2;
	TreeNode root= new TreeNode(a[mid]);
	// recursive
	
	root.setLeft(addToBST(a,begin,mid-1)); //还是传入原来那个数组只用传入不同下标即可，不用对数组本身进行分割操作什么的
	root.setRight(addToBST(a,mid+1,end));

	//recursive ends
	return root;	
}

public static TreeNode converToMinTree(int[] array){
   return	addToBST(array, 0, array.length-1);
}
	
	
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,28,29,30};
		TreeNode root = converToMinTree(array);
	    // TreePrint.inOrder(root);
		int level=TreeNode.findlevel(root, 22);
	System.out.print((level));
	}

}
