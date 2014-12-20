package treeAndgraph;

import stackAndQueues.Queue;

//traverse遍历  
//1.1.1 Pre-order 前序
//1.1.2 In-order (symmetric) 中序
//1.1.3 Post-order 后序

//你把所有东西都放进二叉树，然后中序遍历一次，就是有序输出了 

//http://sjjg.js.zwu.edu.cn/SFXX/sf1/blrcs.html  gif演示

public class TreePrint {
	// preorder的顺序
	// 先遍历根节点 再遍历左子树 最后才遍历右子树
	// 处理root
	// 往左走 递归处理 （root——>left）
	// 往右走 递归处理 （root->right）
	// 好好理解递归

	// **就是说 处理root的方法开始运行，，
	// **然后处理root左开始运行。。然后处理root左左开始运行。然后root的左子树全部完了后
	// **再root的右开始运行。然后处理root右右开始运行。。然后root的右子树全部完了后 整个处理root的方法才算完了

	public static void preorder(TreeNode root) {
		if (root != null) { // 当getLeft等于null了时候
			print(root);
			preorder(root.getLeft());
			preorder(root.getRight());
		}

	}

	// inorder traverse顺序-----------------------》
	public static void inOrder(TreeNode root) {
		if (root != null) { // 当getLeft等于null了时候

			inOrder(root.getLeft());
			// 这句处理完了的时候就是已经到树最最左边的节点了，
			// 然后打印 ，close方法，回到次左的节点，打印左，，右 close方法
			print(root);// 中点。。

			inOrder(root.getRight());

		}

	}

	// Post-order traverse顺序 左子树从下到上 从左到右
	// 右子树从小到上 从左到右
	// 最后根节点
	public static void postOrder(TreeNode root) {
		if (root != null) {

			postOrder(root.getLeft());

			postOrder(root.getRight());
			print(root);// 最后打印

		}

	}

	// levelOrder traverse
	// 1
	// 2 3
	// 4 5 6 7
	// 从上倒下 从左到右traverse

	// 解题思路 先将root入队 然后入队时候，判断入队的节点左右儿子是否为空
	// 然后把不为空的都放入队列，以此loop。。直到队列为空
	public static void levelOrder(TreeNode root) {
		if (root != null) {
			Queue q = new Queue();
			q.enqueue(root);
			//这里while判断里不能写 dequeue 因为真的会把队列里的吐出来.
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
