package treeAndgraph;

import java.util.ArrayList;
import java.util.LinkedList;

//You are given a binary tree in which each node contains a value.
//Design an algorithm to print all paths which sum up to that value. 
//Note that it can be any path in the tree - it does not have to start at the root
//给一棵树 每个node都是int 然后写一个算法 对于给定的一个数字，树会返回所有加起来是这个数的路径（不一定从root开始）
// 比方说以 ArrayList<LinkedList<TreeNode>> 形式返回  

//ps：path在树里面是指的从上倒下（或者下到上）的一条路径，不能迂回（不能/\这样）每个level最多一个node
//这道题看上去很难，但是如果你真的对树很熟的话，其实不难。
//根据path定义，每条path都是从上倒下或者从下到上的 ，那么只要让每个节点都往根节点方向去走（但是不一定要走到根）
//就能得出所有path。(path 的起点可以是任意 path的重点也可以是任意，只不过方向是从下往上“收敛”的 就能使得路径被有限的归纳出来)
// 
//                      \
//                 /    / 
//            / /  \    \
//           / /    \    \
//          /\      /\  这也是有node的只不过在path里  

public class PathSum4_8 {

	public static void findSum(TreeNode root, int sum) {
		int[] path = new int[TreeNode.getHeight(root)]; // 求出给定的root到这个root的叶子节点的最大距离
														// 就是path的最长的长度
		findSum(root, sum, path, 0); // 请注意path是int[] 存储的是 路径里面路过的元素的data(int)
	}
                                                                    //level表示在root里的层数
	private static void findSum(TreeNode root, int sum, int[] path, int level) {
		if (root == null) {
			return;
		}
		path[level] = root.getData();// level表示了 目前这个node在当前树的这条path上是第几层 
		int currentSum = 0;
		for (int i = level; i >= 0; i--) {  //请注意 这题的一个重大关键在这个for循环
			currentSum = currentSum + path[i]; //这个level表示离root的距离，然后--往上一个个加回去，i表示加几个了      
			if (currentSum == sum) {      //就好比一个100层的树，你现在level50，然后for循环--
				print(path,i,level);      //就是50+49+48 一直往上 （你看不是没有从叶子开始往上而是从当前level开始的吗！）   
				}                         //i 就是 49.48.。47.。一直到0
			
			}
		findSum(root.getLeft(), sum, path, level+1);//在这个path里是第二层了 这个root
		findSum(root.getRight(), sum, path, level+1);
	}
 
	

public static void print(int[] path,int current,int level){
	System.out.println(" ");
	for(int i= current;i<=level;i++){//因为录入path的时候是倒着录的。。50.。49.。48.。这里打印反着打印 负负的正。
		
		System.out.print(path[i]+" ");
	}
}

	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		TreeNode root = MinHeightTree4_3.converToMinTree(array);
		findSum(root, 25);
		
	}

}
