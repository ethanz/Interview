package stackAndQueues;

//�����һ��stack��ʹ������һ���ҵ�stack����Сֵ�Ĺ���
//����push pop�� ����Сֵmin��ҪO(1)
public class FindMinimunInO1_3_2 extends StackWithMinNode {
	// ���Լ�����һ��˼·(�ͽⷨ1��һ����)��Ϊstack��ʵֻ�Ƕ�topһ��ʵʩ����
	// ���������дNode�� Node����ָ�������Сֵ����ô����top�����ﶼ������MIN O(1),
	// ����ÿ��pushʱ��ͺ�����Сֵ�ȴ�С���ɣ�push����O1
	//����ⷨ��ȱ�����ÿ��node������һ��min��space �Ƚ��˷ѿռ�

	//��ôpush�ĺô�����ɶ
	//ÿ������stack�����Node�ġ����Ǳ���data����ǰ����data����Сֵ��Ȼ������ֵ
	//�������TOP��min������� ÿ��node��min�ǲ�һ����
	//���Բ�����ôpop ��ǰtop��min����stack�����Сֵ
	public void push(int value) {
		int newMin = Math.min(value, min());
		NodeWithMin temp = new NodeWithMin(value, newMin);
		temp.next = top;
		top = temp;
	}

	public int min() {
		if (top.min == 0) {
			return Integer.MAX_VALUE;// ֵΪ 2��31�η�-1 �ĳ���,����ʾ int �����ܹ���ʾ�����ֵ��
		} else {
			return top.min;
		}
	}

	public int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}
		return Integer.MAX_VALUE;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
