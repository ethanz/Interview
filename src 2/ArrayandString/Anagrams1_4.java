package ArrayandString;
import java.util.*;
//Anagrams ����˼��2��string����ͬһ���ַ����ǲ�ͬ˳����ɵġ�����������˳�� 
//��λ�ʾ�����ɵ���ĸ��ͬ����˳��һ���ĵ��ʡ� ����˵��live��evil����һ�Ա�λ��
public class Anagrams1_4 {

	
	
	public static void main(String[] args) {
	    String a ="abcdefg";
	    String b ="decafgb";
		System.out.print(compare1(a,b));
		
	}

	public static boolean compare1(String a, String b){
	    boolean flag;  
		char[] ary1=a.toCharArray();
	      char[] ary2=b.toCharArray();
	     Arrays.sort(ary1);
	     Arrays.sort(ary2);
	     
	     String c= new String(ary1);
	     String d= new String(ary2);
	     if(c.equals(d)){
	    	return flag=true;
	    	}
	     else return flag=false;
	      
	
	
	}
	
}
