package hard;
//Write a function that adds two numbers. You should not use + or any arithmetic operators.
//дһ��Add�������������ĺͣ�����ʹ��+�Ż����������������
//bit manipulation
public class AddWithoutPlusSign20_1 {

//	�ܰ���ټӷ�������Ū�ø��򵥵��𣿴���YES�����ǿ��԰����������ĺͷֳ������� ����"��"��λ"�������ӣ�
//
//    ����759 + 674���������ǽ�λ���õ�323��
//
//    ����759 + 674��ֻ���ǽ�λ��������ȥ��ÿһλ���õ�1110��
// �ټ������͵õ��� 1433 �����ټ�Ҳ�����üӺŰ�  ������recursive	
//���������Ҫ����Ū�Ļ�
//�����ǽ�λ�ġ��ӡ�   1+0/0+1 =1  1+1/0+0=0  ��������� ^
//��λ�Ļ�,��a b ����1ʱ�� ����ǰ��һλ ����(a&b)<<1  
//�ȷ�˵101+111==1100
// ��ô�ӾͿ���˵ 0,1,0
//��λ����          1,0,1,0
//��λ�ͼ�Ҫ����ټ������ſ���--recursive
	
	public static  int addWithoutPlus(int a,int b){
		if(a==0){return b;}
		if(b==0){return a;}
		int add=a^b;
		int carry=(a&b)<<1;
		return addWithoutPlus(add, carry);
		//recursive��������һ���ӳ�0 ���Ծͷ�����ֵ
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
