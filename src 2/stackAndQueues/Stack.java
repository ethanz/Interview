package stackAndQueues;

//top节点永远是Stack最顶上的节点，先进后出，后进先出
//stock peak() 是看stack top元素用的 但是不会删掉元素  
public class Stack {
	Node top;

	// 头pop一个出来
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	// 压入一个做头
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	Object peek() {
		if (top != null) {

			return top;
		}
		return null;
	}

	public boolean isEmpty() {
		if (this.top == null) {
			return true;
		} else {
			return false;
		}
	}

}
