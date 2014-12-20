package Moderate;

import java.util.Hashtable;

//Design a method to find the frequency of occurrences of any given word in a book.
//���һ���������ҵ�����������һ�����еĳ��ִ�����

public class FindWordsinBook19_8 {
//�����Ŀ��19.2��һ��˼·�����ֻ��Ҫ��ѯһ�Σ� �Ǿ�ֱ����
	//ֱ���� ����һ�ߣ�0(n)���� �ҵ�һ����count++  ��Ӧ�ò���л�˰�
	
//���Ҫ��β�ѯ������Ҫ��ѯ���ֲ�ͬ�ĵ��ʣ��Ǿ���Ԥ����һ�飬 ��������ֻ��Ҫ��O(1)��ʱ����в�ѯ��
//��hashtable������������ÿ���ʳ��ֵĴ��� �Ժ�ֻҪ����table��֪������ʳ����˼���
	
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
