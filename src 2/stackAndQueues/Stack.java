package stackAndQueues;

//top�ڵ���Զ��Stack��ϵĽڵ㣬�Ƚ����������ȳ�
//stock peak() �ǿ�stack topԪ���õ� ���ǲ���ɾ��Ԫ��  
public class Stack {
	Node top;

	// ͷpopһ������
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	// ѹ��һ����ͷ
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
