package Moderate;                                                   //�׳�
//Write an algorithm which computes the number of trailing zeros in n factorial.
//дһ���㷨����n�Ľ׳�ĩβ0�ĸ�����
//�ѽ׳�������ǲ���ѧ�� ��Ϊ�׳˿��ܴܺ� �ַ��Ӿ������
//Ҫ�ú÷�������ĸ������׳˺����кö�0�ĺܱ���ʲô����2x5������,�����˲���0
//����Ϊ��5���У���ֹһ����2��������ֻҪ����׳����м���5�Ϳ���
public class Count0OnTail19_3 {

	
	public  static int  countZero(int n) {
		if(n<10){return -1;}
		int count=0;
		//ע�⣬�ؼ�����i=i��5
//		5!, ����1*5, 1��5
//		10!, ����1*5,2*5,��Ϊ�� factorial�׳����� ��5^2��
//		15!, ����1*5,2*5,3*5, ��5^3��
//		20!, ����1*5,2*5,3*5,4*5, ��5^4��
//		25!, ����1*5,2*5,3*5,4*5,5*5,��5^6��
//���� ���ѭ���� ��һ�� i��5 �ڶ�����25 ������ ��5^3����������������ȷ�ĳ�5��Ҳ����0��������
		 //����������n�ﺬ�е�5^count �η�,��Ϊ��count����5----�����count��0
		for(int i=5;n/i>0;i=i*5){
			count=count+n/i;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(3/5);

	}

}
