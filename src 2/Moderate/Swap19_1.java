package Moderate;
//Write a function to swap a number in place without temporary variables.
//дһ����������������������ʹ����ʱ������

public class Swap19_1 {      
public static void swap1(int a,int b){
	a=a-b; // ע�����a b������ԭ����a b
	b=a+b;//=(a-b)+b=ԭ����a
	a=b-a;//(a-b)+b-(a-b)=ԭ����b
}
	
//��bit manipulation
public static void swap2(int a,int b){
    a=a^b;  //(^���) 0^1=1, 1^0=1, 1^1=0^0=1 һ����0 ��һ����1
    b=a^b;
    a=a^b;
}  //��������ý���

//ʹ������֮ǰһ��Ҫ��һ�룬
//��ĳ����У��Ƿ��п��ܻ���swap�е������β�����ͬһ������ ����ǣ���ô��������swap�������������⡣	
//������û�������ʵʵ������temp variable��swap����
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
