package Moderate;

import java.util.Random;

import javax.security.auth.x500.X500Principal;
//implement rand7() using rand5()
//����һ������һ��������1��5������ĺ���������дһ����������1��7�������

//ע�� ���ⲻ�����Ūһ���ܳ�1-7֮������ͺ��ˣ�Ҫ�ȸ���
//��ѧ��֤������� hawstein.com/posts/19.10.html �����ѣ�

//ֻҪ���ǽ�Rand5 ӳ�䵽һ���ܲ��������������Randa������a > 7,
// ����Ҫע��һ�����,��ӳ����Randaһ����Ҫ����ȸ�������1��a�ġ�
// ���� rand5()+rand5 -1 �ǲ��� ƽ��������1-9��
//���ǡ�����1ֻ��һ����ϣ� ����Rand5()������1ʱ��(1, 1)��������2�����֣�(1, 2)��(2, 1)������6���ࡣ
//���Բ�������ֲ�������̬�ֲ��� 
//����Randa ������ 1-a�������
//!!!������һ����ʽ  a * (Randa - 1) + Randa-1 �ܲ�������� ����������ֲ��������
//��������������  a * (Randa^2 - 1) + Randa 
public class Random7_19_10 {

	public static int rand7() {
		while (true) {
			// num������ֲ�������0-24
			int num = 5 * (rand5() - 1) + (rand5() - 1);
			if (num < 21) {
				// �����0-6 ����Ҫ
				int random = num % 7 + 1;
				return random;
			}
		}
	}

	public static int rand5(){
		Random rand =new Random();
		int i= rand.nextInt(101);
		return  i%5+1 ;
	}
	
	public static void main(String[] args) {
	for(int i=0;i<20;i++){
		System.out.println(rand7());
	}
	
	}

}
