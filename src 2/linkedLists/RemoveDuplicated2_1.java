
package linkedLists;
import java.util.*;
//ȥ���ظ���node
public class RemoveDuplicated2_1 {

	//with a buffer(hashtable)
	// ͨ��hashtable�������ظ�key��feature,��node���data��ΪkeyȻ����hashtable�Դ���
	//containkey����������ظ���data
	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
  //�������� previous�ڵ�
		 LinkedListNode previous = null;
		 while (n != null) {
	//��һ��loop��ʱ��   hashtable�ǿյ� ����϶�û�ж�����,���Ե�һ�ο϶������
			//���hashtable���Ѿ������������ ��ôֱ����ǰ�ڵ��nextָ��n�ĺ�ڵ�
			 //��n�ֿգ�ǰ�ڵ㲻ָ���������Ծ�ɾ����n
			 if (table.containsKey(n.data)) previous.next = n.next;
		 else {
		 table.put(n.data, true);
	//���Ե�һ��loopʱ�� previous����n�ˣ��ڶ���loop�տ�ʼ��ʱ��Ҳ��n
		 previous = n;
		 }
		//��ʱprevious��n��n�ڵ���n.next ����������һλ	 
		 n = n.next;
		 //��ʱ����whileѭ���ڣ�����n=n.next ��������whileѭ�� ���� previous����n��
		 //��������previous,�����������ڵ���������ʵ��previous
		 }
		 }
	
	//practice
	public static void deleteDups2(LinkedListNode n) {
	Hashtable table= new Hashtable();
	LinkedListNode previous=null;
	while (n!=null){
		if(table.containsKey(n.data)){
			previous.next=n.next;
		}
		else{
			table.put(n.data, true);
			previous=n;
		}
		n=n.next;
	}
	}
	
	//����������bufferʱ��(����hashtable)
	//eg���� ��  1  2   3 ����node
  //                                              1  	
	public static void deleteDups3(LinkedListNode n){
		if(n==null){return;}
		 //                1
		LinkedListNode previous =n;
		//                2
		LinkedListNode current=n.next;
	//��linkedlist��û�е���ͷ��ʱ��
	            //2	
		while(current!=null){
			                //1
			LinkedListNode runner = n;
			//while(1��=2)
						while(runner!=current){
				//while(1.data==2.data)
				  if(runner.data==current.data){
					  //tmp==3
					LinkedListNode tmp= current.next;//���¸��ڵ�
					//1.next pointer -->3
					//current/2 ��û����ָ���ˣ����ڱ�ɾ��
					previous.next=tmp;//��ֵ���Ͻڵ��next 
					//��current=3
					current =tmp;
			 
					 break; //����while loop������ִ�� runner=runner.next
				  }				  
				  runner=runner.next;}
			
				if(runner==current){ 
					previous=current;
					current=current.next;
				}
				
			}
		}
		
		
		
	
	
	
	
	public static void main(String[] args) {
		LinkedListNode list= new LinkedListNode(0); 
		list.appendToTail(2);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(3);
		list.appendToTail(8);
		list.appendToTail(8);
		
		list.print();
		System.out.println("");
		
		
	}


	}




 	
 
