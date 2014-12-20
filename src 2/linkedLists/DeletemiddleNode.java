 
package linkedLists;
//删除单链表的中间节点,可以返回true 或者false表示删没删对
//这里和书上原题不一样，书上原题是给你那个node了
public class DeletemiddleNode {

	public static boolean deleteMid(LinkedListNode head){
		if(head==null||head.next==null){return false;}
		int count=0;
		LinkedListNode temp = head;
		while(temp.next!=null){
			temp=temp.next;
			count++;
		}
		//System.out.println(count);
		int mid= count/2;
		
		temp=head;
		//关键点，
		for(int i=0;i<mid-1;i++){
			temp=temp.next;
		}
	temp.next=temp.next.next;
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
		 deleteMid(list);
			list.print();
	}

}
