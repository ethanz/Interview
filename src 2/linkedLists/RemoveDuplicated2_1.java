
package linkedLists;
import java.util.*;
//去除重复的node
public class RemoveDuplicated2_1 {

	//with a buffer(hashtable)
	// 通过hashtable不允许重复key的feature,把node里的data设为key然后用hashtable自带的
	//containkey方法来检查重复的data
	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
  //单纯声明 previous节点
		 LinkedListNode previous = null;
		 while (n != null) {
	//第一次loop的时候   hashtable是空的 里面肯定没有东西的,所以第一次肯定不会进
			//如果hashtable里已经有这个数据了 那么直接让前节点的next指向n的后节点
			 //让n轮空，前节点不指向它了所以就删掉了n
			 if (table.containsKey(n.data)) previous.next = n.next;
		 else {
		 table.put(n.data, true);
	//所以第一次loop时候 previous就是n了，第二次loop刚开始的时候也是n
		 previous = n;
		 }
		//此时previous是n，n在等于n.next 等于往后移一位	 
		 n = n.next;
		 //此时还在while循环内，所以n=n.next 继续进行while循环 所以 previous是新n的
		 //的真正的previous,这就是你如何在单链表里面实现previous
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
	
	//当不允许用buffer时候(不用hashtable)
	//eg假设 有  1  2   3 三个node
  //                                              1  	
	public static void deleteDups3(LinkedListNode n){
		if(n==null){return;}
		 //                1
		LinkedListNode previous =n;
		//                2
		LinkedListNode current=n.next;
	//当linkedlist还没有到尽头的时候
	            //2	
		while(current!=null){
			                //1
			LinkedListNode runner = n;
			//while(1！=2)
						while(runner!=current){
				//while(1.data==2.data)
				  if(runner.data==current.data){
					  //tmp==3
					LinkedListNode tmp= current.next;//下下个节点
					//1.next pointer -->3
					//current/2 就没人有指向了，等于被删了
					previous.next=tmp;//赋值给上节点的next 
					//让current=3
					current =tmp;
			 
					 break; //跳出while loop！！不执行 runner=runner.next
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




 	
 
