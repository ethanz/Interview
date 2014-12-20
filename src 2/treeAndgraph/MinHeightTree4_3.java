package treeAndgraph;


//Given a sorted (increasing order) array,
//write an algorithm to create a binary tree with minimal height.
//ps:��Ȼ��Ŀ��ûҪ����BST�� ���ǰ�����Ŀ���Ĵ� ���껹����BST �������ǾͰ���BST����
//��С�߶���ζ��ʲô����ζ���� ����װ��������¶�װ������ȥ��չ�µ�һ��
//���Խ�������һ��������������ÿһ����㣬�����֧�Ľ���������ҷ�֧�Ľ������һ�¡� 
//

//���Կ������ҳ����顰�е㡱�ĵ�root,�ٰѱ���С�ķ���ߣ�������ķ��ұߡ�
//��������root֮�� ������ ��С��2���������𣨶�Ӧ������������ �ٰ�С�ġ��е㡱 ����������root��
//�Ѵ������ġ��е㡱������������root���Դ�����  ���ⷴӳ�ˡ��ֶ���֮���ķ��� �� 
//��������ָ�����ġ����顰������������ġ������������͡�������������������Ӧ������
//�����õݹ�����
public class MinHeightTree4_3 {
public static TreeNode addToBST(int[] a,int begin, int end){
	//Ϊ�˷�ֹstackoverflow�����޵ݹ飩Ҫ�����Щ�±꣨�ָend=begin ��˵���޷��ٷ��ˣ���һ��int�ˣ�
	if(end<begin){return null;}
	
	//begin ��end�� mid�������±�
	int mid =(begin+end)/2;
	TreeNode root= new TreeNode(a[mid]);
	// recursive
	
	root.setLeft(addToBST(a,begin,mid-1)); //���Ǵ���ԭ���Ǹ�����ֻ�ô��벻ͬ�±꼴�ɣ����ö����鱾����зָ����ʲô��
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
