package treeAndgraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import stackAndQueues.Queue;
import linkedLists.LinkedListNode;

//Given a binary search tree, design an algorithm which creates 
//a linked list of all the nodes at each depth 
//(eg, if you have a tree with depth D, you’ll have D linked lists).
//把BST树中的每一层转换成一个linkedlist  可以参考那个“上下左右”遍历
//但是和上下左右遍历有点小区别， 就是当树的一层走完的时候，方法必须知道本层走完了 到下一层了
//然后开启一个新的linkedlist
//最后可以把这些linkedlist 存在arraylist 里
//CC第五版有基于level order更简单的做法 
public class TreeLevelToLinkedList4_4 {

	public static ArrayList<LinkedList<TreeNode>> convertToLinkedLists(TreeNode root){
		 ArrayList<LinkedList<TreeNode>> arrayList =new ArrayList<LinkedList<TreeNode>>();
		 LinkedList<TreeNode> currentList=new LinkedList<TreeNode>();
		// LinkedList<TreeNode> previousList=new LinkedList<TreeNode>();
		 arrayList.add(currentList);
		 
		 /*要想求每个树当中的节点在第几层 可以修改一下BST里面找节点的方法。
		  *每当比大小之后往下 一层的时候 height+1 （height 可以设为一个static）
		  *
		  * 如果是普通树 怎么办呢？ 也可以用found方法，因为普通树也是traverse找node
		  * 而他的traverse是通过recursive实现的。 那么每多递归调用一次的时候 height可以+1
		  * 见TreeNode 里的 findLevel方法 
		  */
		 
		 //这题可以参考 levelOrder的方法，用queue实现，在出queue的时候，判断和之前的出队level是否一致，一致就直接add到
		 //当前的array list。如果和之前level不一致就new一个新数组当作新的current arraylist 然后在append到arraylist里
		 //有6个对象 currentList (LinkedList 本层和上一层)
		 //current  previous　(弹出的node和尚一个弹出的node)
		 //currentHeight previousHeigh(本节点高度和上一个节点高度)
			
				if (root != null) {
					Queue q = new Queue();
					q.enqueue(root);
				    TreeNode previous=root;
				    
				    int previousHeight=TreeNode.findlevel(root, root.getData());
					while (q.peek() != null) {
						TreeNode current = (TreeNode) q.dequeue();
						if (current.getLeft() != null) {
							q.enqueue(current.getLeft());
						}
						if (current.getRight() != null) {
							q.enqueue(current.getRight());
						}
						if((TreeNode.findlevel(root, current.getData()))==previousHeight){
							 currentList.add(current);
							 previous=current;
							 previousHeight=TreeNode.findlevel(root, current.getData());
						}else{ currentList=new LinkedList<TreeNode>();
						 arrayList.add(currentList);
						 currentList.add(current);
						 previous=current;
						 previousHeight=TreeNode.findlevel(root, current.getData());
							
							}	
					}
				}
		return arrayList;	}
		
		
 //第二种方法 cc150第五版的方法 bsp 加privous 和curr 如果要遍历curr层只要遍历privous的所有子节点即可
	public static ArrayList<LinkedList<TreeNode>> convertToLinkedLists2(TreeNode root){
		 ArrayList<LinkedList<TreeNode>> result =new ArrayList<LinkedList<TreeNode>>();
		 LinkedList<TreeNode> current =new LinkedList<TreeNode>();
	if(root!=null)
		 current.add(root);
	while(current.size()>0){
		result.add(current);
		LinkedList<TreeNode> prev=current;
		current =new LinkedList<TreeNode>();
		for (TreeNode node: prev) {
			if(node.getLeft()!=null){
				current.add(node.getLeft());
			}
			if(node.getRight()!=null){
				current.add(node.getRight());
			}
		}
	}
	return result;}
	
	
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		TreeNode root = MinHeightTree4_3.converToMinTree(array);
		ArrayList<LinkedList<TreeNode>> test=convertToLinkedLists(root);
		for (LinkedList<TreeNode> t : test) {
			System.out.println("");
			for (TreeNode treeNode : t) {
				System.out.print(treeNode.getData());
			}
			
			
		}
		
		System.out.println("");
		TreePrint.inOrder(root);

	}

}
