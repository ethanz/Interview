package treeAndgraph;

import stackAndQueues.Node;
//Write an algorithm to find the ‘next’ node (e.g., in-order successor) of 
//a given node in a binary search tree where each node has a link to its parent.
//In order 是中序遍历  先遍历左子树  在遍历 root 再遍历右子树 
//首先 先复习下中序是怎么遍历的。参考4_4最后那两个打印语句（eg:在123456...100的BST里 in order 的顺序也是123456..100）

//1. 首先，第一个被遍历的节点是整个树的左子树的最左的节点

//2.如果当前被处理的节点(不管他在哪里)有右子树，那么他的“next node”就是右子树最左边的节点

//3.如果当前被处理的节点current没有右子树 
//3.a.如果当前的current本身是他父节点的左儿子. 那么他的“next node”就是他的parent Node
//3.b 如果当前的current本身是他父节点的右儿子，那么按照inorder的顺序，他的左边的节点都处理过了，所以都是他的前驱节点。
//他得一直往上层去找，找到没处理过的那一个，就是“next node”。具体怎么找呢，一层层往上找。一直找一个节点是他父亲节点的左儿子，那么他的父结点就是next node  
//（表示parent 左子树都遍历完了）所以parent就是next node
public class FindNextNode4_5 {

	// 找最左 （上面1. 2.都会用到这方法）这个方法一般是丢右子树的root进去
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
   * 这代码写的不好 参考第五版书上代码好
   */
	public static TreeNode inOrderSucc(TreeNode current) {
		if (current == null) {
			return null;
			if(current.parent == null || current.getRight() != null){ //是root（假如root的右子树没有那返回null好了），或者有右子树  
			} else { //情况2                             或 有一个true就是true  
			return findMostLeft(current.getRight());
		}else{//情况3 不是root也没有右子树
			 TreeNode parent=current.parent;
			 if(parent.getLeft()==current){return parent;}//case 3a
			 //case 3b  一层层网上找 直到找到current是parent的左儿子（表示parent 左子树都遍历完了）所以parent就是next node
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
