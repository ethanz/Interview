package linkedLists;
//����linkedlist���� һ��node Ҫ����ɾ����node
public class DeletemiddleNode2_3withargument {
                                      //��������Ҫɾ��node ��nҪ��ɾ
	//���ϵĽⷨ�ǣ���n.next�����ú�ֵ ȫ�����Ƹ�n Ȼ���n.nextɾ��
	//�����Ǵ�è
	public static boolean deleteNode(LinkedListNode n) {
		 if (n == null || n.next == null) {
		 return false; // Failure
		 }
		   LinkedListNode next = n.next;
		 //��һ��node��data��n
		   //��nֱ��ָ�����¸�node,����ʵ����n.next��ɾ�˵�������ֵ�������Ƕ�����n����
		   //Ч����ɾn��һ����
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
