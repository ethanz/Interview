package stackAndQueues;

public class StackWithMinNode {

	NodeWithMin top;

	// ͷpopһ������
	int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}
		return Integer.MAX_VALUE;
	}

	// ѹ��һ����ͷ
	void push(int item) {
		NodeWithMin t = new NodeWithMin(item);
		t.next = top;
		top = t;
	}

}
