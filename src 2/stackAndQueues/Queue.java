package stackAndQueues;

//�����Թ���Ҫ��ʵ��һ���򵥵Ķ�ջ�����жӵ�ʱ������˳����д�꣬
//����ͱ�һ���ӦƸ������һ���ˡ��������ɣ��������Щ�����Ķ�ջ�Ͷ��еĿ�ܴ���һ��Ҫ���ա�
public class Queue {

	Node first;
	Node last;

	// ���� �ӵ�β��
	public void enqueue(Object item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	// ���� ͷ����һ��
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
