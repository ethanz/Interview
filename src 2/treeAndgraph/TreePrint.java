package treeAndgraph;

import stackAndQueues.Queue;

//traverse����  
//1.1.1 Pre-order ǰ��
//1.1.2 In-order (symmetric) ����
//1.1.3 Post-order ����

//������ж������Ž���������Ȼ���������һ�Σ�������������� 

//http://sjjg.js.zwu.edu.cn/SFXX/sf1/blrcs.html  gif��ʾ

public class TreePrint {
	// preorder��˳��
	// �ȱ������ڵ� �ٱ��������� ���ű���������
	// ����root
	// ������ �ݹ鴦�� ��root����>left��
	// ������ �ݹ鴦�� ��root->right��
	// �ú����ݹ�

	// **����˵ ����root�ķ�����ʼ���У���
	// **Ȼ����root��ʼ���С���Ȼ����root����ʼ���С�Ȼ��root��������ȫ�����˺�
	// **��root���ҿ�ʼ���С�Ȼ����root���ҿ�ʼ���С���Ȼ��root��������ȫ�����˺� ��������root�ķ�����������

	public static void preorder(TreeNode root) {
		if (root != null) { // ��getLeft����null��ʱ��
			print(root);
			preorder(root.getLeft());
			preorder(root.getRight());
		}

	}

	// inorder traverse˳��-----------------------��
	public static void inOrder(TreeNode root) {
		if (root != null) { // ��getLeft����null��ʱ��

			inOrder(root.getLeft());
			// ��䴦�����˵�ʱ������Ѿ�����������ߵĽڵ��ˣ�
			// Ȼ���ӡ ��close�������ص�����Ľڵ㣬��ӡ�󣬣��� close����
			print(root);// �е㡣��

			inOrder(root.getRight());

		}

	}

	// Post-order traverse˳�� ���������µ��� ������
	// ��������С���� ������
	// �����ڵ�
	public static void postOrder(TreeNode root) {
		if (root != null) {

			postOrder(root.getLeft());

			postOrder(root.getRight());
			print(root);// ����ӡ

		}

	}

	// levelOrder traverse
	// 1
	// 2 3
	// 4 5 6 7
	// ���ϵ��� ������traverse

	// ����˼· �Ƚ�root��� Ȼ�����ʱ���ж���ӵĽڵ����Ҷ����Ƿ�Ϊ��
	// Ȼ��Ѳ�Ϊ�յĶ�������У��Դ�loop����ֱ������Ϊ��
	public static void levelOrder(TreeNode root) {
		if (root != null) {
			Queue q = new Queue();
			q.enqueue(root);
			//����while�ж��ﲻ��д dequeue ��Ϊ��Ļ�Ѷ�������³���.
			while (q.peek() != null) {
				TreeNode temp = (TreeNode) q.dequeue();
				if (temp.getLeft() != null) {
					q.enqueue(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.enqueue(temp.getRight());
				}
						print(temp);
			}
		}
	}

	public static void print(TreeNode p) {
		System.out.println(p.getData() + " ");
	}

}
