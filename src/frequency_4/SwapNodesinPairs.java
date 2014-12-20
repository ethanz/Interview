package frequency_4;

import frequency_4.MergeKLists.ListNode;
//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. You may not modify the values in the list, 
//only nodes itself can be changed. 
//��linkedlist�� �������ڵ�Node��λ��  ֻ������O(1)�Ŀռ临�Ӷ�
//pre��¼pairǰһ�����
//p��¼pair��һ�����
//first, second��¼pair

//����������1-2-3-4-������1��ԭʼhead
public class SwapNodesinPairs {
	 public ListNode swapPairs(ListNode head) {
		 if (head == null || head.next==null) return head;
	        //p1-1  p2-2  p3-3
	        ListNode p1 = head, p2 = head.next, p3 = p2.next;
	        head = p2;
	        while (true) {
	            p2.next = p1; //2->1
	            
	            if ((p3 == null) || (p3.next == null)) {
	                p1.next = p3;
	                break;
	            } else {          
	                p1.next = p3.next; //p1��nextָ��4 ��Ϊ������3 4Ҳ��Ҫ��λ�õģ�
	            }
	            
	            p1 = p3;          //Ȼ��p1=3
	            p2 = p3.next;     //p2=4
	            p3 = p2.next;    //p3.next.next=5
	        }
	        
	        return head; //2
	    };
	  
	 
	 
	 public static void main(String[] args) {
		    ListNode a1=new ListNode(1);
		     ListNode a2=new ListNode(5);
		     a1.next=a2;
		     ListNode b1=new ListNode(2);
		     ListNode b2=new ListNode(4);
		     a2.next=b1;
		     b1.next=b2;
		     (new SwapNodesinPairs()).swapPairs(a1);
	}

	static class ListNode {
	     int val;
	     ListNode next;
	    ListNode(int x) {
	          val = x;
	        next = null;
	      }
	  }
}


