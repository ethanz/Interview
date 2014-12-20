package linkedLists;


	public class LinkedListNode {
		 LinkedListNode  next = null;
	     int data;
	     public LinkedListNode (int d) { data = d; }
	     void appendToTail(int d) {
	    	 LinkedListNode end = new LinkedListNode (d);
	    	 LinkedListNode  n = this;
	    	 while (n.next != null) { n = n.next; }
	    	 n.next = end;
	    	 }
	 	void print(){
			System.out.println(this.data);
			LinkedListNode temp=this.next;
			while(temp!=null){
			
				System.out.println(temp.data);
				temp=temp.next;}}//最后一次打印完后temp为null
	 	LinkedListNode deleteNode(LinkedListNode head, int d) {
	 		LinkedListNode n = head;
	 		 if (n.data == d) {
	 		 return head.next; /* moved head */
	 		 }
	 		 while (n.next != null) {
	 		 if (n.next.data == d) {
	 		 n.next = n.next.next;
	 		 return head; /* head didn’t change */
	 		 }
	 		 n = n.next;
	 		 }
	 		 return null;
	 		 }		 
	
	
	
	}
