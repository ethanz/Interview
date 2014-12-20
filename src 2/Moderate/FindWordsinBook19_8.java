package Moderate;

import java.util.Hashtable;

//Design a method to find the frequency of occurrences of any given word in a book.
//设计一个函数，找到给定单词在一本书中的出现次数。

public class FindWordsinBook19_8 {
//这道题目和19.2是一个思路。如果只需要查询一次， 那就直接做
	//直接做 遍历一边，0(n)搜索 找到一个就count++  这应该不用谢了吧
	
//如果要多次查询，而且要查询各种不同的单词，那就先预处理一遍， 接下来就只需要用O(1)的时间进行查询。
//用hashtable存下整本书中每个词出现的次数 以后只要访问table就知道这个词出现了几次
	
	public static Hashtable<String,Integer> prePorcessBook(String[] book){
		Hashtable table=new Hashtable();
		for (String word : book) {
			word=word.toLowerCase();
			if(word.trim()!=""){
				if(!table.containsKey(word)){
					table.put(word, 1);
				}else{
					int tempCount=(Integer) table.get(word);
					++tempCount;
					table.put(word,new Integer(tempCount));
				}
				
				
			}
		 
		}
		return table;
	}
	
	public  static int getFrequency(Hashtable table,String word) {
		if(table==null||word==null){
			return -1;
		}
		word=word.toLowerCase();
		if(table.containsKey(word)){
			return (Integer) table.get(word);
		}
		
		return 0;
	}
	
	
 
	public static void main(String[] args) {
		  String[] words = { "the", "Lara", "and", "outcropping", "career","it","it","it" };
		  Hashtable dictionary =prePorcessBook(words);
		  
		  for (String word : words) {
	            System.out.println(word + ": " + getFrequency(dictionary, word));
	        }

	}

}
