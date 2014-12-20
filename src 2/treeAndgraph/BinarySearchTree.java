package treeAndgraph;

// 本片普及了一些底层知识，见下
public class BinarySearchTree {

	private TreeNode root;
	private int size;

	public BinarySearchTree(TreeNode root) {
		this.root = root;
		size++;
	}

	public int getSize() {
		return this.size;
	}

	// 因为BST是排序的 所以可以这么干,找不到或者正好是root会返回root
	public static TreeNode findBST(TreeNode root, int a) {
		TreeNode found;
		if (root == null) {
			found = null;
		} else {// object 要equals
			if (root.getData() == a) {
				found = root;
			} else {
				if (a < root.getData()) {
					if (root.getLeft() == null) {
						return root;
					} else {
						found = findBST(root.getLeft(), a);
					}
				} else {
					if (root.getRight() == null) {
						return root;
					} else {
						found = findBST(root.getRight(), a);
					}

				}
			}

		}

		return found;
	}

	// 求树的高度
	public int height() {
		if (this.root != null) {
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			// invoke getHeight for 左右子树
			int hleft = getHeight(left);
			int hright = getHeight(right);
			// 比左右子树那个更高 那个高的那个的高度就是树的高度
			int height = hleft > hright ? hleft : hright;
			return height + 1;
		}
		return 0;
	}

	// get invoked by height()
	// 求左右子树的高度！

	// 这里稍微普及一下底层的东西
	// 每个方法 被调用的时候 会新开的 stack 存储自己的局部变量，stack和stack之间是独立的，但是可以通过赋值传递值
	// 比方说 这个递归。假设树是一个3层的 满二叉树。 那么左右是一样的 就先单讨论左边吧
	// height()调用 getHeight(left)（一）;（这个left是第二层的最左边节点） 这个方法被调用
	// 开一个单独的栈,里面申明了hleft但是没有赋值
	// 然后这个方法再递归调用 getHeight(left)（二）（这个left是第三层的最左边节点） 同理 这个方法被调用
	// 开一个单独的栈,里面申明了hleft但是没有赋值
	// 然后这个方法再递归调用 getHeight(left)（三）（这个left是第四层（最下面的）的最左边节点） 同理 这个方法被调用
	// 开一个单独的栈,里面申明了hleft但是没有赋值
	// 然后这个方法再递归调用 getHeight(left)（四）（但是第四层是叶子节点了，没有第五层了，所以传进去null。所以
	// if(root!=null)的 都不会运行，直接运行else， 直接返回0给 （三）
	// （等于把（四）stack里的局部变量 hleft赋值给（三）stack的局部变量hleft，此时 方法（四）结束）
	// 然后在（三）里 hleft 和hright都是0 所以 return 0+1 给 （二），此时（三）结束
	// 同理 （二） return 1+1 给（一），（二）结束，（一）return 2+1= 3 给 height()， （一）结束。 最后
	// height() 返回4 就是树的高度
	//

	/*
	 * pps 叶子.getLeft是不会报错的，但是会返回一个null当参数， //空指针仅发生在null.xxx的时候
	 * 因为null既无方法可调也无成员变量可调)
	 */

	private int getHeight(TreeNode root) {
		if (root != null) {
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			// also, recursive
			int hleft = getHeight(left); // 左树递归
			int hright = getHeight(right); // 右树递归
			int height = hleft > hright ? hleft : hright;
			return height + 1;
		} else {
			return 0;
		}

	}

	// 往bst里insert node
	public boolean insert(int n){
        boolean flag = insert(n,this.root);
        if(flag) this.size++;
        return flag;
    }
	
	
	// bst按理说是不能存重复值的
	
	private boolean  insert(int a, TreeNode root) {
		if (root == null) {
		this.root=new TreeNode(a);
			return true;
		}else{if (a < root.getData()) {
			if (!root.hasLeft()) {
				TreeNode sub = new TreeNode(a);
				root.setLeft(sub);
				return true;
				
			} else {
				root = root.getLeft();
			  return insert(a, root);
			}

		} else if(a > root.getData()) {
			if (!root.hasRight()) {
				TreeNode sub = new TreeNode(a);
				root.setRight(sub);
				return true;
			} else {
				root = root.getRight();
				return insert(a, root);
			}
		}else{return false;}// bst按理说是不能存重复值的}
		}
	 
	}

	// http://jpkc.xaau.edu.cn/sjjg/datastru/zxxx/seven%20lesson/733.html
	// 从二叉排序树中删除一个结点，不能把以该结点为根的子树都删去，只能删掉这个结点，
	// 并且还要保证删除后所得的二叉树仍然满足二叉排序树的性质不变。也就是说，
	// 在二叉排序树中删去一个结点相当于删去有序序列中的一个结点。

	// http://hi.baidu.com/hbmubai/item/2664141899c6186c71d5e87f
	/**
	 * 根据删除节点的类型，分成以下几种情况 ①如果被删除的节点是叶子节点，直接删除 ②如果被删除的节点含有一个子节点，让指向该节点的指针指向他的儿子节点
	 * ③如果被删除的节点含有两个子节点，找到左子树的最大节点，并替换该节点
	 **/

	public TreeNode delete(TreeNode root, int a) {
		TreeNode current = root;
		TreeNode parent = root;
		boolean findAtLeft = true;// （要找的值是否在左边）
		// 请注意这个循环的 条件，当没找到的时候
		// 如果小就一直往左边找，如果大就一直往右边找
		// 1。如果找到叶子节点了，叶子的left/right 是null 然后再运换一次 返回null
		// 2.如果找到node了 跳出while循环 执行下面的
		while (current.getData() != a) {
			parent = current;// 这样保证了如果是因为找到而跳出循环时候,parent是root的parent

			if (a < current.getData()) {
				current = current.getLeft();
				findAtLeft = true;
			} else {
				current = current.getRight();
				findAtLeft = false;
			}
			// root 为空 return null
			if (current == null) {
				return null;
			}
		}
		// 所以能运行到这里 肯定是current.data= value 找到了
		// 此时判断这个找到的节点是什么情况，是叶子 还是有孩子等等
		
		//current is left, just delete from parent
		if (current.hasLeaf() == false) {
			// 能走进这个if 说明了 root.data=a ,且root没有孩子
			// 而且root.data =a
			if (current == root) {
                         root=null;
                         this.size--;
                         return current;
                          
			}else if(findAtLeft){
			     this.size--;
				parent.setLeft(null);
				return current;
			}else{     this.size--;
				parent.setRight(null);
				return current;
			}
			 			   //current 只有右子树 
		}else if(current.hasLeaf()&!current.hasRight()){
			//root.data =a，但是root有左子树，没有右子树
			if(current==root){
			root=current.getLeft();//（把左子树的最上面一个node当新root）
		     this.size--;
			return current;
			}else if(findAtLeft){//current在parent的左子树上
				//但是孩子都在current左子树，直接让父节点连上他左子树，让引用跳过他
				parent.setLeft(current.getLeft());
			     this.size--;
				return current;
			}else{//current在parent的右子树上，但是孩子都在current左子树
				parent.setRight(current.getLeft());
			     this.size--;
				return current;		}   //current 只有右子树 
		}else if(!current.hasLeaf()&current.hasRight()){
			if(current==root){
				root=current.getRight();
			     this.size--;
				return current;
		}else if(findAtLeft){
			parent.setLeft(current.getRight());
		     this.size--;
			return current;}
		else{
			parent.setRight(current.getRight());
		     this.size--;
			return current;}}
	else{ //能进到这个else  说明这个current有左右子树
		//有两个儿子。这是最麻烦的情况，因为你删除节点之后，还要保证满足搜索二叉树的结构。
		//做法：找到左儿子中的最大元素（左儿子的最右 successor）赋值给待删除节点current的data
         //然后（在 successor原来位置）删掉左儿子的最右
		              
		TreeNode successor = getSuccessor(current);
		TreeNode temp= current;
		current.setData(successor.getData());
		return temp;
		
					
		
//		if(current == root) {
//			root = successor;
//			return current;
//		} else if(findAtLeft) { //current在parent的左边
//			parent.setLeft(successor); 
//			return current;
//		} else{//current在parent的右边
//			parent.setRight(successor); 
//			return current;
//		}
//		//你要记得调整子树
//		successor.setLeft(current.getLeft()); 
					}
	}

	public TreeNode getSuccessor(TreeNode current) {
		TreeNode successor = current;
		TreeNode successorParent = current;
		TreeNode currnet = current.getLeft();
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current =current.getRight();
		}
		//这个循环跑完后 successor应该是 左子树的最右，current是null
	//successorParent是左子树最右的爹
	   this.size--;
		successorParent.setRight(null);
	    return successor;
	}
	
	
	
	// ///////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
