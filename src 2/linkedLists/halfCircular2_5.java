package linkedLists;
//carrercup 2.5��������еĻ���λ�� 
// A -> B -> C -> D -> E -> C  ��node at the beginning of the loop. ���������������C��
// Ϊʲô�������أ���Ϊ������һ���루����˵������ circular linkedlist

//         E----D   
//          \  /   
//     A--B---C
// ������һ�������ⷨ  �й��ýⷨ  also known as Floyd's cycle detection algorithm.
//�ڹ�ÿ����һ��������2��,Ȼ�� ���ǻ��ټ����
//���node����Ҫ����ʱ��������ӻ�ͷ���Ĳ���Ϊ1���ڹ�������metting point Ҳ�Ĳ���Ϊ1�����������ĵ� ���ǻ���
//���Թ��� �������
//eg�� ABC(DEFGH(C))
// slow ABCDEFGHCDEFGHCDEFGH
// fast ACEGCEGCEGCEGC
//            |meeting point ����C ��2  ����head A����CҲ��2 ���Ұѻ�size����Ҳ������

public class halfCircular2_5 {

	
  public static LinkedListNode	detectCircularHead(LinkedListNode head){
		if(head==null||head.next==null){ return null;}
		else{  LinkedListNode fast=head.next.next;
		       LinkedListNode slow=head.next;
			//ΪʲôҪ��ôд��,��Ϊ����û�л������ǵ������϶����ܵ����fast���ܵ�β�Ͱ���
			while(fast.next!=null){
				fast= fast.next.next;
				slow=slow.next.next;
				if(fast==slow){
					break;  //�������whileѭ�� ��ʱ fast==slow==meeting point
				}			}
			//�������û�л�����β���� �ͷ���null
			if (fast.next == null) {
				 return null; }
			
			slow=head;
			//�Ѳ��ٶ���Ϊ1
			while(slow!=fast){
				slow=slow.next;
				fast=fast.next;
			}
			//������  fast��slow���Ѿ����Ǹ�circle start��
			return fast;
		}}
		
		
		
		
		
		
		
		
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}
