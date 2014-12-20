package linkedLists;

//求这个"single linkedlist"链表的倒数第n个元素
//可以问面试官要head
//

public class NthtoLast2_2 {
    //这个是我自己想得，数数组长度的做法。
	public	static LinkedListNode findNthtoLast(LinkedListNode head,int n){
	// robust代码 让代码更健壮  
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
	//p1 此时为链表尾部了
		while(p1.next!=null){
	p1=p1.next;
	count++; //count为检查表里多少个元素
	}
		p2=head;
		//倒数第n个 既为正数count-n个(所以是小于等于)
	for(int i=0;i<=(count-n);i++){
		p2=p2.next;
	}
		return p2;
	}

	//这个是书上做法。
	//大意是 把p2弄到n-1位,把p1 弄到head
	//然后把p1 p2 同时同步 increment 直到p2.next!=null（last node）,
	//此时p1还是距离p2 n, 所以p1是倒数第n个
	
	public	static LinkedListNode nthToLast(LinkedListNode head,int n){
		if (head == null || n < 1) {
			 return null;
			 }
			 LinkedListNode p1 = head;
			 LinkedListNode p2 = head;
			 //弄p2到n-1位置
			 for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			 if (p2 == null) {
			 return null; // not found since list size < n
			 }
			 p2 = p2.next;
			 }
			 //同步自增，到p2为尾节点停止
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
	
	