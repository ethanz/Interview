package treeAndgraph;
//You have two very large binary trees: T1, with millions of nodes, 
//and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
//可以把T2的root当作一个node去T1 里去找 然后调方法比较 T1的以这个找到的node为根节点的子树和T2是否相同。

//注意。 没说  T1里面node都是唯一的。
//而且一样要完全一样，比方说t2是叶子的地方 t1也要是叶子

public class IsSubTree4_7 {
	
	public static boolean isSubTree(TreeNode t1,TreeNode t2){
		if(t1!=null&&t2==null){return true;} //实际题目中t1 t2 都不是null
		if (t1 == null) {
			return false;
		} else {// object 要equals
			if (t1.getData() == t2.getData()) {
				 boolean flag=isSameTree(t1, t2);
				 if(flag){return true;}
			 
				boolean left = isSubTree(t1.getLeft(), t2);
				boolean right = isSubTree(t1.getRight(), t2);
				
				if(left||right){return true;} //这么写是对的。因为不管的递归到多少层下去。只要有true都会一层层返回上来
				//最总传回第一个方法 （递归的本质见binarySearchTree的注释）
				
			}
		}
		return false;
	}
	
	public static boolean isSameTree(TreeNode tree1,TreeNode tree2){
            //一个是null,一个不是null 当然 肯定不是同一个树了，就返回false		
		if (tree1 == null ^ tree2 == null){// ^是抑或的意思 ,就是 ^两边boolean值不同 就返回true，两边boolean值相同就返回false
			return false;}
		//都不是null 比值，如果不一样还是false
		if(tree1!=null&&tree2!=null){
			if(tree1.getData()!=tree2.getData()){
				return false;
			}
			//本次比较的2个都一样，开始 比下一层，如果下层返回false就本层也返回false，如果一直不返回false
			//就 一层层一直比下去 直到最后一层 2个都是null了 那说明树完了 都一样，返回true
			if(!isSameTree(tree1.getLeft(), tree2.getLeft())){return false;}
			if(!isSameTree(tree1.getRight(), tree2.getRight())){return false;}
		}
			return true;

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
