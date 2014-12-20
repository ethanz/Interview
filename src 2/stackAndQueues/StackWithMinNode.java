package stackAndQueues;

public class StackWithMinNode {

	NodeWithMin top;

	// 头pop一个出来
	int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}
		return Integer.MAX_VALUE;
	}

	// 压入一个做头
	void push(int item) {
		NodeWithMin t = new NodeWithMin(item);
		t.next = top;
		top = t;
	}

}
