package ArrayandString;
import java.util.*;
//Anagrams 的意思是2个string是由同一堆字符但是不同顺序组成的。（可以任意顺序） 
//变位词就是组成的字母相同，但顺序不一样的单词。 比如说：live和evil就是一对变位词
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
