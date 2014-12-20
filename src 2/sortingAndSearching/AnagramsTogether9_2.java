package sortingAndSearching;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class AnagramsTogether9_2 implements Comparator<String> {
//Write a method to sort an array of strings so that all the anagrams are next to each other.
//дһ���������ַ�����������ʹ�����еı�λ�ʶ����ڡ�
//��λ�ʾ�����ɵ���ĸ��ͬ����˳��һ���ĵ��ʡ� ����˵��live��evil����һ�Ա�λ��
//������Բο�1-4
	
//��ֱ�ӵĽⷨ��д���Ƚ������ж��Ƿ���ȣ�
//�Ƚ�����sortһ��String����(ת��Ϊchar���� Ȼ����ϵͳ�Դ�����sort char[])
//Ȼ���ڰ�����Ƚ�������Array.sort ����java���п���һ��
	
	public int compare(String s1,String s2){
		return sortChars(s1).compareTo(sortChars(s2)); //String�Դ���compareTo
	}   //�������Ĳ����Ǵ�ֱ��s1.compareTo(s2) �ı��sortChars(s1).compareTo(sortChars(s2))
	
	public String sortChars(String s){
		char[] temp=s.toCharArray();
		Arrays.sort(temp); //Ĭ�ϰ���abc��˳��sort
		return new String(temp);
	}
		
	
	public static void main(String[] args) {
     String[] temp={"live","happy","act","iuu","evil","yppha","cat","uii"};
     Arrays.sort(temp,new AnagramsTogether9_2() );	//�Ѹո�д���Ǹ�comparator���˽�ȥ	
	System.out.print(Arrays.toString(temp));
	}

}
