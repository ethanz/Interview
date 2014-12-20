package stackAndQueues;



public class Node {
       Node  next = null;
       Object data;
    public Node (Object d) { data = d; }
    void appendToTail(Object d) {
   	 Node end = new Node (d);
   	 Node  n = this;
   	 while (n.next != null) { n = n.next; }
   	 n.next = end;
   	 }
	void print(){
		System.out.println(this.data);
		Node temp=this.next;
		while(temp!=null){
		
			System.out.println(temp.data);
			temp=temp.next;}}//最后一次打印完后temp为null
	Node deleteNode(Node head, Object d) {
		Node n = head;
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



