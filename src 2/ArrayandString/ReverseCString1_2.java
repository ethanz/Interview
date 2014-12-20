package ArrayandString;

import java.util.ArrayList;

//Write code to reverse a C-Style String. (C-String means that ��abcd�� is 
//represented as five characters, including the null character.)

//char�ַ��ǵ������ַ�
//c�����ַ������ɺܶ��ַ�����һ����β��־'\0'��ɵģ���β��null
//
public class ReverseCString1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="abcdefg"+"\\0";
System.out.println(s);
System.out.println(reverse(s));

	}
	
	
	public static String reverse (String s){
		StringBuilder ary= new StringBuilder();
		for(int i=s.length()-3;i>-1;i--){
			ary.append(s.charAt(i));
		}
		ary.append(s.charAt(s.length()-2));
		ary.append(s.charAt(s.length()-1));
		
		String reversed =ary.toString();
		return reversed;
	}

}
