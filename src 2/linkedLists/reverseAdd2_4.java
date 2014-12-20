package linkedLists;
//n位数存在linkedlist里 但是是倒序存储的
//eg：513 在linkedlist里是 Node1: 3-Node2: 1-Node3: 5
//现在给你2个已经这样反向储存好的linkedlist 然后写个function让他们相加 输出结果也是这种反向linkedlist
//为什么不把整个linked list转成数字后再做呢 ，因为长度为n 所以有可能溢出int 甚至溢出long(你可以问面试官是否考虑overflow)
//因为是n位，所以可以考虑递归---进位
public class reverseAdd2_4 {

	public static LinkedListNode add(LinkedListNode a,LinkedListNode b,int carry){
		if (a == null && b == null) {
			 return null;
			 }
		//这时候看出反向存储的好了吧，个位在最前，方便你加，我果然是图样图僧破
		LinkedListNode result=new LinkedListNode(carry);
		int value=carry;
		if(a!=null){
            value=value+a.data;			
		}
		if(b!=null){
            value=value+b.data;			
		}
		// 保证拿到了的是余数和个位数。。eg： 8%10=8   13%10=3
		result.data = value % 10;
		
		if((a.data+b.data)>=10){
			carry=1;
		}                                  
		              //递归调用add方法  //a为null么？为的话就设传参null：不为的话就传参入a.next
		LinkedListNode following = add(a == null ? null : a.next,
				b== null ? null : b.next,
			            value > 10 ? 1 : 0);
       //following 就是下一位 。。等于2者相加 +进位（如果有的话）
		
		                                        //result.setNext( following); 如果是正常linkedlistnode的话
		
		//因为是递归，所以加法的结果就是一位位加上去拉。
		result.appendToTail(following.data);
			
	return   result;}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
