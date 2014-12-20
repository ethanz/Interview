package stackAndQueues;

// sort a stack in ascending order 
//只能用push | pop | peek | isEmpty
//stack只能在顶端操作 怎么sort呢？
//建一个辅助stack 然后把原来stack   top  pop过去，（辅助stack 就是要return的那个 ascending order top小bottom大）

//然后pop第二个的时候 比大小，假如	pop出来原stack的 top比辅助stack里面的小(辅助站peek)， ok 直接push进辅助stack
//假如	pop出来原stack的 top比辅助stack里面的大（peek出来的东西先暂存一下） ，那就不能直接push进辅助栈了，要让辅助栈pop出top然后
//push回原来的stack，然后把pop出来的东西和辅助栈top比大小，如果还是pop出来东西大 辅助栈再pop,再push回原来栈， 
//直到辅助stack的top比pop出来的东西小 或者等于 或者 辅助栈空了 为止，然后 再把pop出来东西push到辅助栈里
//复杂度为O(N2)
public class SortStack extends Stack {

	public static Stack goingToStack(Stack raw) {
		Stack sorted = new Stack();
		if (raw == null) {
			return null;
		}
		if (sorted.top == null) {
			sorted.push(raw.pop());
		}
		//while stack raw is not empty
        while(!raw.isEmpty()){
        	Integer temp=(Integer) raw.pop();             //temp大 sorted里面的top小，这种情况push进去是违背ascending order的
        	while (!sorted.isEmpty()&&(Integer)sorted.peek()<temp) {
			   raw.push(sorted.pop());  //所以要push回原stack再比。。循环
							}
        	//当sorted里面top>=temp时候，就可以正常push到sorted里了
        	sorted.push(temp);
        	//虽然小循环此时结束了，但是while(!raw.isEmpty()) 大循环还没结束，所以大循环会继续loop 直到raw空
        	}
		return sorted;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
