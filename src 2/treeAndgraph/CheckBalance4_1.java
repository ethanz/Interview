//递归 永远是最顶层的一点点调用下去 然后最低层的一点点return回来 
package treeAndgraph;



//完成一个用来判断一颗树是否是平衡树的函数。
//平衡树是指两个叶结点在距离根结点的距离上不会超过1。
//pg123 解答 思路很简单：最小深度(最浅的leaf是几层)与最大深度（最深的leaf是几层）
//的差别是 不超过 1.因此最大与最小深度的差值就是树中最大的深度差值。 
//so 求最小深度 和最大深度
public class CheckBalance4_1 {

	// 参考求高度的那个递归 在binarysearhtree类里,他是直接return到上一个层方法的return里
	public static int minHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 每一个叶子到root的路径都是唯一的，用了min之后最后root返回给main的方法里
		// 不管怎么样都会返回出最短到root的那个节点的层数 (因为是二叉树)
		// return min（3,1） +1 =2 （因为是min，所以永远向父节点的方法返回自己最浅叶子距离自己的层数）
		//            3/ \1
		//          2/ \1
		//         1/
		// 得出最浅的叶子是2层
		// 同理 max的方法 永远返回最深的 max (3,1) 第四层
		return Math.min(minHeight(root.getLeft()), minHeight(root.getRight())) + 1;}
	
	public static int maxHeight(TreeNode root){
		if(root== null){
			return  0;}
		return Math.max(maxHeight(root.getLeft()), maxHeight(root.getRight()))+1;
	}
	
		
		public static boolean isBlance(TreeNode root){
			return (maxHeight(root)-minHeight(root)<=1);
	
	}

}
