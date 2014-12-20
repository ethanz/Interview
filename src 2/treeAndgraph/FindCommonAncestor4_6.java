package treeAndgraph;

import java.security.PublicKey;
//Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
//avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
//��������Ǹ���ͬ���ȣ�Ҫ��ͨbinary tree���� ��һ����BST
//��Ҳ��������LCA���⣨lowest common ancestor��
public class FindCommonAncestor4_6 {

//����node����ָ�򸸽ڵ��reference���Ϳ���һ·׷����ȥ֪���ҵ�����
//�������۲��ø��ڵ�ķ���
	
//���������2�������Ҫ�ҵ�����node��root��ͬһ�ࣨͬһ�������ϣ���������root�Ĳ�ͬ�����ϣ�
//���� Ҫ���ⷽ�� ����root�����Ҷ��Ӵ����ⷽ����root��)
	private  boolean isChild(TreeNode root, TreeNode toFind){
             if(root==null||toFind==null){return false;}
             if(root==toFind){return true;}
             return isChild(root.getLeft(), toFind)||isChild(root.getRight(), toFind); 
             //����д������2��������һ��true��true�˰�
             	}
	
	
	//����Ҫ������һ��������֪�ǣ��ڶ������ϣ����һ���ڵ����Լ����������ϣ�һ���ڵ����Լ����������ϣ�
	//��ô�Լ�������С�����ڵ�
	public TreeNode LCAoneside(TreeNode root, TreeNode first,TreeNode second){
		//���first��second�������
		if(isChild(root.getLeft(),first)&&isChild(root.getLeft(), second)){
			return LCAoneside(root.getLeft(),first,second);}//�Ͱ�root������ӵ���rootȻ��recursive
		if(isChild(root.getRight(),first)&&isChild(root.getRight(), second)){
			return LCAoneside(root.getRight(),first,second);}//�Ͱ�root���Ҷ��ӵ���rootȻ��recursive
		//���������ݹ�����ȷһ��һ����ȥ��
		//Ȼ����������һ���ڵ����Լ����������ϣ�һ���ڵ����Լ����������ϣ� ��������2��if����return�˵�ǰ���root 
		//���root����������СCA ��ô��ȻҲ������������if ֱ�ӷ���root

	return root;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
