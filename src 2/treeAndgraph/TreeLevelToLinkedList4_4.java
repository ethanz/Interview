package treeAndgraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import stackAndQueues.Queue;
import linkedLists.LinkedListNode;

//Given a binary search tree, design an algorithm which creates 
//a linked list of all the nodes at each depth 
//(eg, if you have a tree with depth D, you��ll have D linked lists).
//��BST���е�ÿһ��ת����һ��linkedlist  ���Բο��Ǹ����������ҡ�����
//���Ǻ��������ұ����е�С���� ���ǵ�����һ�������ʱ�򣬷�������֪������������ ����һ����
//Ȼ����һ���µ�linkedlist
//�����԰���Щlinkedlist ����arraylist ��
//CC������л���level order���򵥵����� 
public class TreeLevelToLinkedList4_4 {

	public static ArrayList<LinkedList<TreeNode>> convertToLinkedLists(TreeNode root){
		 ArrayList<LinkedList<TreeNode>> arrayList =new ArrayList<LinkedList<TreeNode>>();
		 LinkedList<TreeNode> currentList=new LinkedList<TreeNode>();
		// LinkedList<TreeNode> previousList=new LinkedList<TreeNode>();
		 arrayList.add(currentList);
		 
		 /*Ҫ����ÿ�������еĽڵ��ڵڼ��� �����޸�һ��BST�����ҽڵ�ķ�����
		  *ÿ���ȴ�С֮������ һ���ʱ�� height+1 ��height ������Ϊһ��static��
		  *
		  * �������ͨ�� ��ô���أ� Ҳ������found��������Ϊ��ͨ��Ҳ��traverse��node
		  * ������traverse��ͨ��recursiveʵ�ֵġ� ��ôÿ��ݹ����һ�ε�ʱ�� height����+1
		  * ��TreeNode ��� findLevel���� 
		  */
		 
		 //������Բο� levelOrder�ķ�������queueʵ�֣��ڳ�queue��ʱ���жϺ�֮ǰ�ĳ���level�Ƿ�һ�£�һ�¾�ֱ��add��
		 //��ǰ��array list�������֮ǰlevel��һ�¾�newһ�������鵱���µ�current arraylist Ȼ����append��arraylist��
		 //��6������ currentList (LinkedList �������һ��)
		 //current  previous��(������node����һ��������node)
		 //currentHeight previousHeigh(���ڵ�߶Ⱥ���һ���ڵ�߶�)
			
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
		
		
 //�ڶ��ַ��� cc150�����ķ��� bsp ��privous ��curr ���Ҫ����curr��ֻҪ����privous�������ӽڵ㼴��
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
