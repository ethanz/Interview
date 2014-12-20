package linkedLists;

import java.util.Stack;

//��һ��linkedlist reverse
//��linkedlistѹ��ջLIFO ��pop���linkedlist
public class ReverseLinkedList {

	public static LinkedListNode reverseStack(LinkedListNode n){
		Stack<LinkedListNode> stack=new Stack<LinkedListNode>();
	while(n!=null){
		stack.push(n);
		n=n.next;
	}
	LinkedListNode current=stack.pop();//ԭ������һ�� ������µ�һ��
	n= current;
	while(!stack.isEmpty()==true){
			LinkedListNode next=stack.pop();
			next.next=null;//��ֹβ��ָ��ͷ
			current.next=next;
			current=next;
	}
	return n;
	}
	
	//���� 2 iterator ��ת 
//	 �����б��� 1->2->3->4->null 
//	 ���� ��������  head() next newHead(��ʼ��null)
//	 ��һ��ѭ���� 
//	 1.	next=head.next����һ����2��
//	 2.	head.next= newHead(��һ����null)             ��ʱ �б���  null<-1  2->3->4
//	 3.	newhead=head  (��һ����1)
//	 4.	head= next����һ����2��
//	 Ȼ��ڶ���ѭ�� 
//	 1.	next=head.next(�ڶ�����3)
//	 2.	head.next=newhead(��ʱ newhead��1)  ��ʱ �б���  null<-1<-2  3->4
//	 3.	newHead=head(�ڶ�����2);
//	 4.	head=next(�ڶ�����3)
//	������N��ѭ�� 
//	  ���� ��һ��֮ǰ head=N, next ��N, newHead��N-1 ,  head���滹������� û����������
//	  ��һ��ʱ�� ����next ΪN+1;
//	��ʱhead=N, next ��N+1, newHead��N-1
//	�ڶ����ʱ�� ����head.next=newHead=N-1    ����ʱ��headָ��֮ǰ��linkedlist�ˣ�
//	�������ʱ�� ����newHead=head=N ��newHead�����һλ��
//	��ʱhead=N, next ��N+1, newHead��N
//	���head=next =N+1
//	��ʱ ֮ǰ head=N+1, next ��N+1, newHead��N   ��������������һλ Ȼ����Head֮����ԭ��


	public  static LinkedListNode reverse(LinkedListNode head) {
	        LinkedListNode newHead = null;
	        while (head != null) {
	          LinkedListNode next=head.next; //������next����Ψһһλ
	          head.next=newHead;  //newHead�ڵڶ�����Զ��headǰһλ����������head.nextָ�� head֮ǰ�Ǹ�
	          newHead=head;  //newhead ����λ��һλ
	          head=next; //head ����λ��һλ
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
