//��bugδ���
package hard;
//���ַ�˼�� ��ֵ �ƽ�
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import ArrayandString.Anagrams1_4;

//����һ��String[],��������Ԫ�غܶ�,�ٸ�������String A��B ����������֮�����̾���
public class FindDistanceBetween2Words20_5 {
	// ��������һ��ʼ��ͷ��β�ͱ��� �ҵ�һ��A��Ϳ�ʼ��B Ȼ���¼distance
	// Ȼ���ҵ�B��Ϳ�ʼ��A Ȼ�����distanceС��ˢ�� ���Ӷ�O(N)

	// �����O(1)��ʱ�����������أ�ֻ����hash���� �ռ任ʱ�� ˼·�� 19.8��һ����
	// �������飬(����string��key,int[] ��value )�浽hash����,Ȼ��Ҫ�õ�ʱ��ȥ��hash��

	// Ԥ����
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

	//��hashtable�����ѯ����
//	���������ʼ����С����ʱ��������O(1)ʱ��ͨ����ϣ����ӳ�䵽ָ����㣬 Ȼ���������һ�����ʵ�ÿ��λ�ã�ȥ��ڶ������ʵ�����λ�ñȽϣ�
//	�ҵ���С�Ĳ�ֵ�� ����λ���ǵ����ģ���˿����޸Ķ��ֲ��ҽ���������  
	//���ַ�˼�� ��ֵ �ƽ�
	//����2���������ֵ,Ȼ��ȴ�С��Ȼ������С��ȡ��,С�������ȡ��
	
	public static int distance(HashMap<String, ArrayList<Integer>> table,String a,String b){
		ArrayList<Integer> first=table.get(a);
		ArrayList<Integer> second=table.get(b);
		   Integer[] arrayA=(Integer[])first.toArray(new Integer[first.size()]);
		   Integer[] arrayB=(Integer[])second.toArray(new Integer[second.size()]);
		   int midA=arrayA.length/2;
		    int midB=arrayB.length/2;
		    int diff=Math.abs((arrayA[midA]-arrayB[midB]));
		    System.err.println(arrayA[midA]+","+arrayB[midB]+","+diff);
		   //���ֲ�Ҫֱ�Ӳ���arraylist,Ҫ��������
		   //��Щint�����±�
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
