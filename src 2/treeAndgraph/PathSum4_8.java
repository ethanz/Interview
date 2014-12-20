package treeAndgraph;

import java.util.ArrayList;
import java.util.LinkedList;

//You are given a binary tree in which each node contains a value.
//Design an algorithm to print all paths which sum up to that value. 
//Note that it can be any path in the tree - it does not have to start at the root
//��һ���� ÿ��node����int Ȼ��дһ���㷨 ���ڸ�����һ�����֣����᷵�����м��������������·������һ����root��ʼ��
// �ȷ�˵�� ArrayList<LinkedList<TreeNode>> ��ʽ����  

//ps��path����������ָ�Ĵ��ϵ��£������µ��ϣ���һ��·���������ػأ�����/\������ÿ��level���һ��node
//����⿴��ȥ���ѣ������������Ķ�������Ļ�����ʵ���ѡ�
//����path���壬ÿ��path���Ǵ��ϵ��»��ߴ��µ��ϵ� ����ôֻҪ��ÿ���ڵ㶼�����ڵ㷽��ȥ�ߣ����ǲ�һ��Ҫ�ߵ�����
//���ܵó�����path��(path �������������� path���ص�Ҳ���������⣬ֻ���������Ǵ������ϡ��������� ����ʹ��·�������޵Ĺ��ɳ���)
// 
//                      \
//                 /    / 
//            / /  \    \
//           / /    \    \
//          /\      /\  ��Ҳ����node��ֻ������path��  

public class PathSum4_8 {

	public static void findSum(TreeNode root, int sum) {
		int[] path = new int[TreeNode.getHeight(root)]; // ���������root�����root��Ҷ�ӽڵ��������
														// ����path����ĳ���
		findSum(root, sum, path, 0); // ��ע��path��int[] �洢���� ·������·����Ԫ�ص�data(int)
	}
                                                                    //level��ʾ��root��Ĳ���
	private static void findSum(TreeNode root, int sum, int[] path, int level) {
		if (root == null) {
			return;
		}
		path[level] = root.getData();// level��ʾ�� Ŀǰ���node�ڵ�ǰ��������path���ǵڼ��� 
		int currentSum = 0;
		for (int i = level; i >= 0; i--) {  //��ע�� �����һ���ش�ؼ������forѭ��
			currentSum = currentSum + path[i]; //���level��ʾ��root�ľ��룬Ȼ��--����һ�����ӻ�ȥ��i��ʾ�Ӽ�����      
			if (currentSum == sum) {      //�ͺñ�һ��100�������������level50��Ȼ��forѭ��--
				print(path,i,level);      //����50+49+48 һֱ���� ���㿴����û�д�Ҷ�ӿ�ʼ���϶��Ǵӵ�ǰlevel��ʼ���𣡣�   
				}                         //i ���� 49.48.��47.��һֱ��0
			
			}
		findSum(root.getLeft(), sum, path, level+1);//�����path���ǵڶ����� ���root
		findSum(root.getRight(), sum, path, level+1);
	}
 
	

public static void print(int[] path,int current,int level){
	System.out.println(" ");
	for(int i= current;i<=level;i++){//��Ϊ¼��path��ʱ���ǵ���¼�ġ���50.��49.��48.�������ӡ���Ŵ�ӡ ����������
		
		System.out.print(path[i]+" ");
	}
}

	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		TreeNode root = MinHeightTree4_3.converToMinTree(array);
		findSum(root, 25);
		
	}

}
