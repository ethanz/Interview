package stackAndQueues;
import org.omg.CORBA.ValueMemberHelper;

public class FindMinimunInO1_3_2_2 extends StackWithMinNode {
//3_2 这个解法的缺点就是每个node都新增一个min的space 比较浪费空间
//我们可以创建一个复制stack只用来记录最小的记录
	             //辅助栈，只记录最小的元素
	StackWithMinNode s2;
	public FindMinimunInO1_3_2_2(){
		s2 =new StackWithMinNode();
		
	}
	
	public void push(int value){
		if(value<=min()){
		s2.push(value);	//如果新进来的值更小，新值就放入辅助stack
	}
	super.push(value);//正常在主stack里存值
		}
	
	//因为push时候的逻辑 辅助stack里面的Node肯定是从大倒小的，越在stack底的越大
	//但是弹出也是从top慢慢弹出来的。如果弹出一个和当前min（）值一样小的值了那么
	//自然主stack里面的最小值等于辅助stack里的top.next 所以就把辅助stack里的
	//top pop出来
	public int pop(){
		int value =super.pop();
		if (value== min()){
			s2.pop();
		}
		return value;
	}
	
	public  int min(){
	if(s2.top==null){
		return Integer.MAX_VALUE;
	}	
	else{
		return s2.top.data;
	}
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
