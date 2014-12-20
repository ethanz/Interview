package sortingAndSearching;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class AnagramsTogether9_2 implements Comparator<String> {
//Write a method to sort an array of strings so that all the anagrams are next to each other.
//写一个函数对字符串数组排序，使得所有的变位词都相邻。
//变位词就是组成的字母相同，但顺序不一样的单词。 比如说：live和evil就是一对变位词
//本题可以参考1-4
	
//最直接的解法，写个比较器来判断是否相等，
//比较器内sort一下String本身(转化为char数组 然后用系统自带方法sort char[])
//然后在把这个比较器传给Array.sort 就像java期中考试一样
	
	public int compare(String s1,String s2){
		return sortChars(s1).compareTo(sortChars(s2)); //String自带的compareTo
	}   //我所做的不过是从直接s1.compareTo(s2) 改变成sortChars(s1).compareTo(sortChars(s2))
	
	public String sortChars(String s){
		char[] temp=s.toCharArray();
		Arrays.sort(temp); //默认按照abc的顺序sort
		return new String(temp);
	}
		
	
	public static void main(String[] args) {
     String[] temp={"live","happy","act","iuu","evil","yppha","cat","uii"};
     Arrays.sort(temp,new AnagramsTogether9_2() );	//把刚刚写的那个comparator传了进去	
	System.out.print(Arrays.toString(temp));
	}

}
