package Moderate;
//Write a method which finds the maximum of two numbers.
//You should not use if-else or any other comparison operator.
//дһ�����������������еĽϴ��ߣ��㲻��ʹ��if-else���καȽϲ�������
public class CompareWithoutComparison19_4 {
//����Ҫ�õ�bit manipulation(��ʵ�Ҿ�������Ī���������Ŀ��Ҫ�õ�bit manipulation)
//������֪��int��32��bit ����int�ĵ�һ��bit��0 �����ĵ�һ��bit��1
	
 public static int returnBigger(int a,int b) {
	int c=a-b; 
	int[] temp={a,b};
	c=Math.abs(c>>31);//a�� Ϊ0,b�� Ϊ1. �ǵ�Ҫת���޷������� �����п��ܳ���-1
	
	return temp[c];
}	
	
	public static void main(String[] args) {
 
		int a=returnBigger(344, 999);
	System.out.print(a);
	
	}}