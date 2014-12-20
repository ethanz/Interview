package Moderate;

//You are given an array of integers (both positive and negative).
//Find the continuous sequence with the largest sum. Return the sum.

//����һ����������(���������͸���)���ҵ����������������У����غ͡�(���÷���������)
// �������Щ��̬�滮����Ŀ��һ�㣬Ϊʲô�أ�
//��Ϊ��ĿҪ�������������� ����˵��ЩҪ�����ġ� 
//��Ϊ��㣬����Ŀ����һ�α���O��n���������� 
//���ӵ�a[i]ʱ�� �����ǰsumС��0 �Ͱ�0-i���ӵ� ���¼���
//Ȼ��ÿ�ε�currentSum����maxSum��ʱ�����maxSum,���� �ڹ��̵�������maxSub�ͻᱻ����
public class LargestSequenceSum19_7 {
	// ע��Ҫ���� ֻ�и�������� ���� Ҫ�Ⱥ�maxsum�ж� �ںʹ���С��0�ж�
	public static int maxSub(int[] a) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum = currentSum + a[i];
	 
			if (currentSum > maxSum) {
				maxSum = currentSum;
			} else if (currentSum < 0) {
				currentSum = 0;
			} // ��2��ֻ���ܷ���һ���� �Ǿ�else if��
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] a = { 2, -8, 3, -2, 4, -10 };
		System.out.print(maxSub(a));

	}

}
