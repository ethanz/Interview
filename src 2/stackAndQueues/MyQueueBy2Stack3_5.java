package stackAndQueues;

//queue  FIFO              <---------<
//stack  LIFO              |--------><     
//��ô 2��stack����ô����      s1 |----------->  |s2
//��������n��node  1����n
// �Ȱ�nodes���ӵ�s1,��ʱ���ϵ�Ԫ����1ջ�ף�����n����ջ�׶�
//Ȼ��s1 popȫ����ÿpopһ����ѹ��s2��ȥ��������s2�ͻ�ѹ����n�ģ�s2����ѹ���ϵ�1
//pop s2����������ʵ��queue��
//��ʵҲ����ÿһ��push pop peek�� ������ȥ
//��Ϊ�����Ѿ�����S2����ȥ��node���Ѿ���FIFO��˳���ˣ�����ֻҪpush��ʱ��ֻ����s1��push
//��Ҫpeek�� popʱ�� ��S1�����е���S2һ��  �����ˡ�
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
		// while (s2.top == null && s1.top != null) ��ôд�Ǵ��
		// ��Ϊ��һ��ѭ������s2�Ͳ������������ֻ��ִ��һ��
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
		} // ��ʱ s1����19-0
		System.out.println(test.pop());// ��ʱs2����0-19 Ȼ��popһ��0��s1Ϊ��
		System.out.println(test.pop());// ��ʱs2����1-19 Ȼ��popһ��1��s1Ϊ��
		test.push(new Integer(25));// ��ʱs1��25 s2�� 2-19
		test.push(new Integer(28));// ��ʱs1��28-25 s2�� 2-19
		System.out.println(test.pop());// ��ʱs1.top����null ִ��while Ȼ��s2���
										// 25-28-2-19

		for (int i = 0; i < 19; i++) {
			System.out.println(test.pop());
		}

	}

}
