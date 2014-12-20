package stackAndQueues;

//queue  FIFO              <---------<
//stack  LIFO              |--------><     
//那么 2个stack会怎么样呢      s1 |----------->  |s2
//假设有有n个node  1～～n
// 先把nodes们扔到s1,此时最老的元素在1栈底，最新n的在栈底顶
//然后s1 pop全部，每pop一个都压倒s2里去，这样，s2低会压最新n的，s2顶会压最老的1
//pop s2就是正常的实现queue了
//其实也不用每一次push pop peek都 倒来倒去
//因为凡是已经倒到S2里面去的node，已经是FIFO的顺序了，所以只要push的时候只管往s1里push
//需要peek和 pop时候 把S1里面有的往S2一倒  就行了。
public class MyQueueBy2Stack3_5 {

	Stack s1;
	Stack s2;

	public MyQueueBy2Stack3_5() {
		s1 = new Stack();
		s2 = new Stack();
	}

	public void push(Object o) {
		s1.push(o);
	}

	public Object pop() {
		if (s2.top == null && s1.top == null) {
			return null;
		}
		if (s2.top != null) {

			return s2.pop();
		}
		// while (s2.top == null && s1.top != null) 这么写是错的
		// 因为第一轮循环过后s2就不空了所以最后只会执行一次
		while (s1.top != null) {
			Object temp = s1.pop();
			s2.push(temp);
		}
		return s2.pop();

	}

	public static void main(String[] args) {

		MyQueueBy2Stack3_5 test = new MyQueueBy2Stack3_5();
		for (int i = 0; i < 20; i++) {
			test.push(new Integer(i));
		} // 此时 s1里有19-0
		System.out.println(test.pop());// 此时s2里有0-19 然后pop一个0，s1为空
		System.out.println(test.pop());// 此时s2里有1-19 然后pop一个1，s1为空
		test.push(new Integer(25));// 此时s1有25 s2有 2-19
		test.push(new Integer(28));// 此时s1有28-25 s2有 2-19
		System.out.println(test.pop());// 此时s1.top不是null 执行while 然后s2变成
										// 25-28-2-19

		for (int i = 0; i < 19; i++) {
			System.out.println(test.pop());
		}

	}

}
