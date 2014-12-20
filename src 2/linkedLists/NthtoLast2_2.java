package linkedLists;

//�����"single linkedlist"����ĵ�����n��Ԫ��
//���������Թ�Ҫhead
//

public class NthtoLast2_2 {
    //��������Լ���ã������鳤�ȵ�������
	public	static LinkedListNode findNthtoLast(LinkedListNode head,int n){
	// robust���� �ô������׳  
	if (head == null || n < 1) {
				 return null;
		 }
	int count=0;
	LinkedListNode p0=head;
	for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
		 if (p0 == null) {
		 return null; // not found since list size < n
		 }
		 p0 = p0.next;
		 }
	LinkedListNode p1=head;
	LinkedListNode p2;
	//p1 ��ʱΪ����β����
		while(p1.next!=null){
	p1=p1.next;
	count++; //countΪ��������ٸ�Ԫ��
	}
		p2=head;
		//������n�� ��Ϊ����count-n��(������С�ڵ���)
	for(int i=0;i<=(count-n);i++){
		p2=p2.next;
	}
		return p2;
	}

	//���������������
	//������ ��p2Ū��n-1λ,��p1 Ū��head
	//Ȼ���p1 p2 ͬʱͬ�� increment ֱ��p2.next!=null��last node��,
	//��ʱp1���Ǿ���p2 n, ����p1�ǵ�����n��
	
	public	static LinkedListNode nthToLast(LinkedListNode head,int n){
		if (head == null || n < 1) {
			 return null;
			 }
			 LinkedListNode p1 = head;
			 LinkedListNode p2 = head;
			 //Ūp2��n-1λ��
			 for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			 if (p2 == null) {
			 return null; // not found since list size < n
			 }
			 p2 = p2.next;
			 }
			 //ͬ����������p2Ϊβ�ڵ�ֹͣ
			 while (p2.next != null) {
			 p1 = p1.next;
			 p2 = p2.next;
			 }
			 return p1;
		
	}
	
	
	
	public static void main(String[] args) {
		LinkedListNode list= new LinkedListNode(0); 
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		list.print();
		System.out.println("");
		
	
	int k =(findNthtoLast(list,3).data);
	System.out.println(k);
	}

}	
	
	