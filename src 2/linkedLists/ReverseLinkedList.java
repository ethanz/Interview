package linkedLists;

import java.util.Stack;

//把一个linkedlist reverse
//把linkedlist压入栈LIFO 再pop组成linkedlist
public class ReverseLinkedList {

	public static LinkedListNode reverseStack(LinkedListNode n){
		Stack<LinkedListNode> stack=new Stack<LinkedListNode>();
	while(n!=null){
		stack.push(n);
		n=n.next;
	}
	LinkedListNode current=stack.pop();//原表的组后一个 本表的新的一个
	n= current;
	while(!stack.isEmpty()==true){
			LinkedListNode next=stack.pop();
			next.next=null;//防止尾巴指向头
			current.next=next;
			current=next;
	}
	return n;
	}
	
	//方法 2 iterator 反转 
//	 假设列表是 1->2->3->4->null 
//	 解释 三个变量  head() next newHead(初始是null)
//	 在一个循环里 
//	 1.	next=head.next（第一轮是2）
//	 2.	head.next= newHead(第一轮是null)             此时 列表是  null<-1  2->3->4
//	 3.	newhead=head  (第一轮是1)
//	 4.	head= next（第一轮是2）
//	 然后第二轮循环 
//	 1.	next=head.next(第二轮是3)
//	 2.	head.next=newhead(此时 newhead是1)  此时 列表是  null<-1<-2  3->4
//	 3.	newHead=head(第二轮是2);
//	 4.	head=next(第二轮是3)
//	假设是N次循环 
//	  所以 第一句之前 head=N, next 是N, newHead是N-1 ,  head后面还是正序的 没被反过来。
//	  第一句时候 更新next 为N+1;
//	此时head=N, next 是N+1, newHead是N-1
//	第二句的时候 更新head.next=newHead=N-1    （这时候head指向之前的linkedlist了）
//	第三句的时候 更新newHead=head=N （newHead向后移一位）
//	此时head=N, next 是N+1, newHead是N
//	最后head=next =N+1
//	此时 之前 head=N+1, next 是N+1, newHead是N   三个都往后移了一位 然后新Head之后是原序


	public  static LinkedListNode reverse(LinkedListNode head) {
	        LinkedListNode newHead = null;
	        while (head != null) {
	          LinkedListNode next=head.next; //本质是next往后唯一一位
	          head.next=newHead;  //newHead在第二句永远是head前一位，这样就让head.next指向 head之前那个
	          newHead=head;  //newhead 往后位移一位
	          head=next; //head 往后位移一位
	        }
	        return newHead;
	    }

	
	public static void main(String[] args) {
	  LinkedListNode a =new LinkedListNode(1);
	  LinkedListNode b =new LinkedListNode(2);
	  LinkedListNode c =new LinkedListNode(3);
	  LinkedListNode d =new LinkedListNode(4);
	 a.next=b;
	 b.next=c;
	 c.next=d;
	 
	 reverse(a);
	}

}
