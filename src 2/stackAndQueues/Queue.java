package stackAndQueues;

//当面试官需要你实现一个简单的堆栈或者列队的时候，你能顺利的写完，
//那你就比一般的应聘者先人一步了。熟能生巧，下面的这些基本的堆栈和队列的框架代码一定要掌握。
public class Queue {

	Node first;
	Node last;

	// 入列 加到尾巴
	public void enqueue(Object item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	// 出列 头出来一个
	public Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
			return null;
	}
	public Object peek() {
		if (first != null) {
			
			return first;
		}
		return null;
			
	}
	
	
	
}
