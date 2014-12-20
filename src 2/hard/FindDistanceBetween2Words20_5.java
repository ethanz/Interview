//有bug未解决
package hard;
//二分法思想 中值 逼近
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import ArrayandString.Anagrams1_4;

//你有一个String[],可能里面元素很多,再给你两个String A和B 叫你求他们之间的最短距离
public class FindDistanceBetween2Words20_5 {
	// 暴力法：一开始从头向尾巴遍历 找到一个A后就开始找B 然后记录distance
	// 然后找到B后就开始找A 然后如果distance小就刷新 复杂度O(N)

	// 如何用O(1)的时间来完成这个呢？只能用hash表了 空间换时间 思路和 19.8是一样的
	// 遍历下书，(所以string是key,int[] 是value )存到hash表里,然后要用的时候去查hash表

	// 预处理
	public static HashMap<String, ArrayList<Integer>> prePorcessBook(
			String[] book) {
		HashMap<String, ArrayList<Integer>> table = new HashMap<String, ArrayList<Integer>>();
		
		for (int i = 0; i < book.length; i++) {
			String word = book[i].toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					ArrayList<Integer> index=new  ArrayList<Integer>();
					index.add(i);
					table.put(word, index);
				} else {
				table.get(word).add(i);
				 	}
			}
		}
		return table;
	}

	//从hashtable里面查询距离
//	求两个单词间的最小距离时，首先用O(1)时间通过哈希函数映射到指定结点， 然后对于其中一个单词的每个位置，去与第二个单词的所有位置比较，
//	找到最小的差值。 由于位置是递增的，因此可以修改二分查找进行搜索。  
	//二分法思想 中值 逼近
	//先求2个数组的中值,然后比大小，然后大的往小的取半,小的往大的取半
	
	public static int distance(HashMap<String, ArrayList<Integer>> table,String a,String b){
		ArrayList<Integer> first=table.get(a);
		ArrayList<Integer> second=table.get(b);
		   Integer[] arrayA=(Integer[])first.toArray(new Integer[first.size()]);
		   Integer[] arrayB=(Integer[])second.toArray(new Integer[second.size()]);
		   int midA=arrayA.length/2;
		    int midB=arrayB.length/2;
		    int diff=Math.abs((arrayA[midA]-arrayB[midB]));
		    System.err.println(arrayA[midA]+","+arrayB[midB]+","+diff);
		   //二分不要直接操作arraylist,要操作数组
		   //那些int都是下标
		   return distance(arrayA, arrayB,0,arrayA.length-1,0,arrayB.length-1,Integer.MAX_VALUE);
	}
	
	public static int distance(Integer[] a, Integer[] b,int alow,int ahigh,int blow,int bhigh,int diff){
//    
      int midA=(alow+ahigh)/2;
      int midB=(blow+bhigh)/2;
      if((Math.abs(a[midA]-b[midB])>=diff)){
    	  return diff;
      }else if(a[midA]<b[midB]){
    	 return distance(a, b,midA+1,ahigh,blow,midB-1,Math.abs(a[midA]-b[midB]));
      }else{
    	  return distance(a, b,alow,midA-1,midB+1,bhigh,Math.abs(a[midA]-b[midB]));
      }
  	
	}
//	
	
	public static void main(String[] args) {
	String[] a={"aa","bb","cc","dd","ee"};
	System.out.print(distance(prePorcessBook(a), "aa", "bb"));
	


	}

}
