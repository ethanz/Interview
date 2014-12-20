package treeAndgraph;
//You have two very large binary trees: T1, with millions of nodes, 
//and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
//���԰�T2��root����һ��nodeȥT1 ��ȥ�� Ȼ��������Ƚ� T1��������ҵ���nodeΪ���ڵ��������T2�Ƿ���ͬ��

//ע�⡣ û˵  T1����node����Ψһ�ġ�
//����һ��Ҫ��ȫһ�����ȷ�˵t2��Ҷ�ӵĵط� t1ҲҪ��Ҷ��

public class IsSubTree4_7 {
	
	public static boolean isSubTree(TreeNode t1,TreeNode t2){
		if(t1!=null&&t2==null){return true;} //ʵ����Ŀ��t1 t2 ������null
		if (t1 == null) {
			return false;
		} else {// object Ҫequals
			if (t1.getData() == t2.getData()) {
				 boolean flag=isSameTree(t1, t2);
				 if(flag){return true;}
			 
				boolean left = isSubTree(t1.getLeft(), t2);
				boolean right = isSubTree(t1.getRight(), t2);
				
				if(left||right){return true;} //��ôд�ǶԵġ���Ϊ���ܵĵݹ鵽���ٲ���ȥ��ֻҪ��true����һ��㷵������
				//���ܴ��ص�һ������ ���ݹ�ı��ʼ�binarySearchTree��ע�ͣ�
				
			}
		}
		return false;
	}
	
	public static boolean isSameTree(TreeNode tree1,TreeNode tree2){
            //һ����null,һ������null ��Ȼ �϶�����ͬһ�����ˣ��ͷ���false		
		if (tree1 == null ^ tree2 == null){// ^���ֻ����˼ ,���� ^����booleanֵ��ͬ �ͷ���true������booleanֵ��ͬ�ͷ���false
			return false;}
		//������null ��ֵ�������һ������false
		if(tree1!=null&&tree2!=null){
			if(tree1.getData()!=tree2.getData()){
				return false;
			}
			//���αȽϵ�2����һ������ʼ ����һ�㣬����²㷵��false�ͱ���Ҳ����false�����һֱ������false
			//�� һ���һֱ����ȥ ֱ�����һ�� 2������null�� ��˵�������� ��һ��������true
			if(!isSameTree(tree1.getLeft(), tree2.getLeft())){return false;}
			if(!isSameTree(tree1.getRight(), tree2.getRight())){return false;}
		}
			return true;

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
