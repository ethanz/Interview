package treeAndgraph;

import stackAndQueues.Node;
//Write an algorithm to find the ��next�� node (e.g., in-order successor) of 
//a given node in a binary search tree where each node has a link to its parent.
//In order ���������  �ȱ���������  �ڱ��� root �ٱ��������� 
//���� �ȸ�ϰ����������ô�����ġ��ο�4_4�����������ӡ��䣨eg:��123456...100��BST�� in order ��˳��Ҳ��123456..100��

//1. ���ȣ���һ���������Ľڵ�����������������������Ľڵ�

//2.�����ǰ������Ľڵ�(������������)������������ô���ġ�next node����������������ߵĽڵ�

//3.�����ǰ������Ľڵ�currentû�������� 
//3.a.�����ǰ��current�����������ڵ�������. ��ô���ġ�next node����������parent Node
//3.b �����ǰ��current�����������ڵ���Ҷ��ӣ���ô����inorder��˳��������ߵĽڵ㶼������ˣ����Զ�������ǰ���ڵ㡣
//����һֱ���ϲ�ȥ�ң��ҵ�û���������һ�������ǡ�next node����������ô���أ�һ��������ҡ�һֱ��һ���ڵ��������׽ڵ������ӣ���ô���ĸ�������next node  
//����ʾparent ���������������ˣ�����parent����next node
public class FindNextNode4_5 {

	// ������ ������1. 2.�����õ��ⷽ�����������һ���Ƕ���������root��ȥ
	public static TreeNode findMostLeft(TreeNode node) {
		if (node == null) {
			return null;
		}
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;

	}
  /*
   * �����д�Ĳ��� �ο���������ϴ����
   */
	public static TreeNode inOrderSucc(TreeNode current) {
		if (current == null) {
			return null;
			if(current.parent == null || current.getRight() != null){ //��root������root��������û���Ƿ���null���ˣ���������������  
			} else { //���2                             �� ��һ��true����true  
			return findMostLeft(current.getRight());
		}else{//���3 ����rootҲû��������
			 TreeNode parent=current.parent;
			 if(parent.getLeft()==current){return parent;}//case 3a
			 //case 3b  һ��������� ֱ���ҵ�current��parent������ӣ���ʾparent ���������������ˣ�����parent����next node
			 else{while(parent=current.parent!=null) {
				 if(current==parent.getLeft()){break;}
			   current=parent;
			}
			 return  parent;}
			
			}
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
