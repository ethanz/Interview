package treeAndgraph;
//������������Binary Sort Tree���ֳƶ��������Binary Search Tree����ƶ�����������
//��������һ�ÿ����������Ǿ����������ʵĶ�������
//��1�������������գ��������������н���ֵ��С�����ĸ�����ֵ�� 
//��2�������������գ��������������н���ֵ���������ĸ�����ֵ�� 
//��3����������Ҳ�ֱ�Ϊ������������



//���ⲻ��career cup��� �����ݽṹ�����Ǳ��̲���ģ����㷨Ҳ�ǳ���Ҫ
//���⣺��������ģ����BST��BST���������Ǵ�С�����
//            5
//          3    7
//         1 4  6 8
//�������Ӧ��˵��������
//�������Ȱ�����[0] ��Ϊroot,Ȼ������Ԫ�غ�root�Ƚϣ������rootС��
//���ж������Ϊ��Ϊ�գ����Ϊ�Ͳ��룬�����Ϊ�����ں�����ӱȴ�С������������С
//���ڿ������ӣ����Ϊ�վͲ��� ��Ϊ�վ��ٱȽϴ�С�������Դ����ơ���recursive
public class implementSortedBT {

	
	public static TreeNode arrayToSortedTree(int[] raw) {

		int length = raw.length;
		if(length==0){return null;}

		TreeNode root = new TreeNode(raw[0]);
		for (int n = 1; n < length; n++) {
			insert(raw[n], root);
		}
		return root;
	}
//��bst��insert node
	public static void insert(int a, TreeNode root) {
		if (root == null) {
			return;
		}
		if (a <= root.getData()) {
			if (!root.hasLeft()) {
				TreeNode sub = new TreeNode(a);
				root.setLeft(sub);
			} else {
				root = root.getLeft();
				insert(a, root);
			}

		} else {
			if (!root.hasRight()) {
				TreeNode sub = new TreeNode(a);
				root.setRight(sub);
			} else {
				root = root.getRight();
				insert(a, root);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int raw[] = new int[] { 5,1,2,3,4,5,6,7,8,9 };
		TreeNode root = arrayToSortedTree(raw);
		//TreePrint.levelOrder(root);
	
		
	}

}
