package treeAndgraph;

// ��Ƭ�ռ���һЩ�ײ�֪ʶ������
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

	// ��ΪBST������� ���Կ�����ô��,�Ҳ�������������root�᷵��root
	public static TreeNode findBST(TreeNode root, int a) {
		TreeNode found;
		if (root == null) {
			found = null;
		} else {// object Ҫequals
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

	// �����ĸ߶�
	public int height() {
		if (this.root != null) {
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			// invoke getHeight for ��������
			int hleft = getHeight(left);
			int hright = getHeight(right);
			// �����������Ǹ����� �Ǹ��ߵ��Ǹ��ĸ߶Ⱦ������ĸ߶�
			int height = hleft > hright ? hleft : hright;
			return height + 1;
		}
		return 0;
	}

	// get invoked by height()
	// �����������ĸ߶ȣ�

	// ������΢�ռ�һ�µײ�Ķ���
	// ÿ������ �����õ�ʱ�� ���¿��� stack �洢�Լ��ľֲ�������stack��stack֮���Ƕ����ģ����ǿ���ͨ����ֵ����ֵ
	// �ȷ�˵ ����ݹ顣��������һ��3��� ���������� ��ô������һ���� ���ȵ�������߰�
	// height()���� getHeight(left)��һ��;�����left�ǵڶ��������߽ڵ㣩 �������������
	// ��һ��������ջ,����������hleft����û�и�ֵ
	// Ȼ����������ٵݹ���� getHeight(left)�����������left�ǵ����������߽ڵ㣩 ͬ�� �������������
	// ��һ��������ջ,����������hleft����û�и�ֵ
	// Ȼ����������ٵݹ���� getHeight(left)�����������left�ǵ��Ĳ㣨������ģ�������߽ڵ㣩 ͬ�� �������������
	// ��һ��������ջ,����������hleft����û�и�ֵ
	// Ȼ����������ٵݹ���� getHeight(left)���ģ������ǵ��Ĳ���Ҷ�ӽڵ��ˣ�û�е�����ˣ����Դ���ȥnull������
	// if(root!=null)�� ���������У�ֱ������else�� ֱ�ӷ���0�� ������
	// �����ڰѣ��ģ�stack��ľֲ����� hleft��ֵ��������stack�ľֲ�����hleft����ʱ �������ģ�������
	// Ȼ���ڣ������� hleft ��hright����0 ���� return 0+1 �� ����������ʱ����������
	// ͬ�� ������ return 1+1 ����һ������������������һ��return 2+1= 3 �� height()�� ��һ�������� ���
	// height() ����4 �������ĸ߶�
	//

	/*
	 * pps Ҷ��.getLeft�ǲ��ᱨ��ģ����ǻ᷵��һ��null�������� //��ָ���������null.xxx��ʱ��
	 * ��Ϊnull���޷����ɵ�Ҳ�޳�Ա�����ɵ�)
	 */

	private int getHeight(TreeNode root) {
		if (root != null) {
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			// also, recursive
			int hleft = getHeight(left); // �����ݹ�
			int hright = getHeight(right); // �����ݹ�
			int height = hleft > hright ? hleft : hright;
			return height + 1;
		} else {
			return 0;
		}

	}

	// ��bst��insert node
	public boolean insert(int n){
        boolean flag = insert(n,this.root);
        if(flag) this.size++;
        return flag;
    }
	
	
	// bst����˵�ǲ��ܴ��ظ�ֵ��
	
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
		}else{return false;}// bst����˵�ǲ��ܴ��ظ�ֵ��}
		}
	 
	}

	// http://jpkc.xaau.edu.cn/sjjg/datastru/zxxx/seven%20lesson/733.html
	// �Ӷ�����������ɾ��һ����㣬���ܰ��Ըý��Ϊ����������ɾȥ��ֻ��ɾ�������㣬
	// ���һ�Ҫ��֤ɾ�������õĶ�������Ȼ������������������ʲ��䡣Ҳ����˵��
	// �ڶ�����������ɾȥһ������൱��ɾȥ���������е�һ����㡣

	// http://hi.baidu.com/hbmubai/item/2664141899c6186c71d5e87f
	/**
	 * ����ɾ���ڵ�����ͣ��ֳ����¼������ �������ɾ���Ľڵ���Ҷ�ӽڵ㣬ֱ��ɾ�� �������ɾ���Ľڵ㺬��һ���ӽڵ㣬��ָ��ýڵ��ָ��ָ�����Ķ��ӽڵ�
	 * �������ɾ���Ľڵ㺬�������ӽڵ㣬�ҵ������������ڵ㣬���滻�ýڵ�
	 **/

	public TreeNode delete(TreeNode root, int a) {
		TreeNode current = root;
		TreeNode parent = root;
		boolean findAtLeft = true;// ��Ҫ�ҵ�ֵ�Ƿ�����ߣ�
		// ��ע�����ѭ���� ��������û�ҵ���ʱ��
		// ���С��һֱ������ң�������һֱ���ұ���
		// 1������ҵ�Ҷ�ӽڵ��ˣ�Ҷ�ӵ�left/right ��null Ȼ�����˻�һ�� ����null
		// 2.����ҵ�node�� ����whileѭ�� ִ�������
		while (current.getData() != a) {
			parent = current;// ������֤���������Ϊ�ҵ�������ѭ��ʱ��,parent��root��parent

			if (a < current.getData()) {
				current = current.getLeft();
				findAtLeft = true;
			} else {
				current = current.getRight();
				findAtLeft = false;
			}
			// root Ϊ�� return null
			if (current == null) {
				return null;
			}
		}
		// ���������е����� �϶���current.data= value �ҵ���
		// ��ʱ�ж�����ҵ��Ľڵ���ʲô�������Ҷ�� �����к��ӵȵ�
		
		//current is left, just delete from parent
		if (current.hasLeaf() == false) {
			// ���߽����if ˵���� root.data=a ,��rootû�к���
			// ����root.data =a
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
			 			   //current ֻ�������� 
		}else if(current.hasLeaf()&!current.hasRight()){
			//root.data =a������root����������û��������
			if(current==root){
			root=current.getLeft();//������������������һ��node����root��
		     this.size--;
			return current;
			}else if(findAtLeft){//current��parent����������
				//���Ǻ��Ӷ���current��������ֱ���ø��ڵ���������������������������
				parent.setLeft(current.getLeft());
			     this.size--;
				return current;
			}else{//current��parent���������ϣ����Ǻ��Ӷ���current������
				parent.setRight(current.getLeft());
			     this.size--;
				return current;		}   //current ֻ�������� 
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
	else{ //�ܽ������else  ˵�����current����������
		//���������ӡ��������鷳���������Ϊ��ɾ���ڵ�֮�󣬻�Ҫ��֤���������������Ľṹ��
		//�������ҵ�������е����Ԫ�أ�����ӵ����� successor����ֵ����ɾ���ڵ�current��data
         //Ȼ���� successorԭ��λ�ã�ɾ������ӵ�����
		              
		TreeNode successor = getSuccessor(current);
		TreeNode temp= current;
		current.setData(successor.getData());
		return temp;
		
					
		
//		if(current == root) {
//			root = successor;
//			return current;
//		} else if(findAtLeft) { //current��parent�����
//			parent.setLeft(successor); 
//			return current;
//		} else{//current��parent���ұ�
//			parent.setRight(successor); 
//			return current;
//		}
//		//��Ҫ�ǵõ�������
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
		//���ѭ������� successorӦ���� �����������ң�current��null
	//successorParent�����������ҵĵ�
	   this.size--;
		successorParent.setRight(null);
	    return successor;
	}
	
	
	
	// ///////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
