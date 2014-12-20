package linkedLists;
//给你linkedlist当中 一个node 要求你删掉该node
public class DeletemiddleNode2_3withargument {
                                      //参数里是要删的node ，n要被删
	//书上的解法是，把n.next的引用和值 全部复制给n 然后把n.next删掉
	//我真是蠢猫
	public static boolean deleteNode(LinkedListNode n) {
		 if (n == null || n.next == null) {
		 return false; // Failure
		 }
		   LinkedListNode next = n.next;
		 //下一个node的data给n
		   //让n直接指向下下个node,所以实际上n.next被删了但是他的值和引用是都给了n所以
		   //效果和删n是一样的
		 n.data = next.data;
		 n.next = next.next;
		 return true;
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode list= new LinkedListNode(0); 
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		
		
		list.print();
		System.out.println("");
		deleteNode(new LinkedListNode(4));
			list.print();
	}

}
