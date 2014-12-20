//�ݹ� ��Զ������һ��������ȥ Ȼ����Ͳ��һ���return���� 
package treeAndgraph;



//���һ�������ж�һ�����Ƿ���ƽ�����ĺ�����
//ƽ������ָ����Ҷ����ھ�������ľ����ϲ��ᳬ��1��
//pg123 ��� ˼·�ܼ򵥣���С���(��ǳ��leaf�Ǽ���)�������ȣ������leaf�Ǽ��㣩
//�Ĳ���� ������ 1.����������С��ȵĲ�ֵ��������������Ȳ�ֵ�� 
//so ����С��� ��������
public class CheckBalance4_1 {

	// �ο���߶ȵ��Ǹ��ݹ� ��binarysearhtree����,����ֱ��return����һ���㷽����return��
	public static int minHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// ÿһ��Ҷ�ӵ�root��·������Ψһ�ģ�����min֮�����root���ظ�main�ķ�����
		// ������ô�����᷵�س���̵�root���Ǹ��ڵ�Ĳ��� (��Ϊ�Ƕ�����)
		// return min��3,1�� +1 =2 ����Ϊ��min��������Զ�򸸽ڵ�ķ��������Լ���ǳҶ�Ӿ����Լ��Ĳ�����
		//            3/ \1
		//          2/ \1
		//         1/
		// �ó���ǳ��Ҷ����2��
		// ͬ�� max�ķ��� ��Զ��������� max (3,1) ���Ĳ�
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
