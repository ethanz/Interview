package linkedLists;
//carrercup 2.5检测链表中的环的位置 
// A -> B -> C -> D -> E -> C  求node at the beginning of the loop. （在例子情况下是C）
// 为什么会这样呢，因为这样是一个半（或者说不定） circular linkedlist

//         E----D   
//          \  /   
//     A--B---C
// 这题有一个著名解法  叫龟兔解法  also known as Floyd's cycle detection algorithm.
//乌龟每次走一格，兔子走2格,然后 他们会再见面的
//这个node很重要，这时候把兔子扔回头，改步速为1，乌龟则留在metting point 也改步速为1，他们相遇的点 就是环首
//我试过了 真的这样
//eg： ABC(DEFGH(C))
// slow ABCDEFGHCDEFGHCDEFGH
// fast ACEGCEGCEGCEGC
//            |meeting point 距离C 有2  但是head A距离C也有2 。我把环size改了也是这样

public class halfCircular2_5 {

	
  public static LinkedListNode	detectCircularHead(LinkedListNode head){
		if(head==null||head.next==null){ return null;}
		else{  LinkedListNode fast=head.next.next;
		       LinkedListNode slow=head.next;
			//为什么要这么写呢,因为假设没有环，就是单链表，肯定是跑到快的fast先跑到尾巴啊。
			while(fast.next!=null){
				fast= fast.next.next;
				slow=slow.next.next;
				if(fast==slow){
					break;  //跳出这个while循环 此时 fast==slow==meeting point
				}			}
			//假设真的没有环，到尾巴了 就返回null
			if (fast.next == null) {
				 return null; }
			
			slow=head;
			//把步速都设为1
			while(slow!=fast){
				slow=slow.next;
				fast=fast.next;
			}
			//跳出后  fast和slow都已经是那个circle start了
			return fast;
		}}
		
		
		
		
		
		
		
		
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}
