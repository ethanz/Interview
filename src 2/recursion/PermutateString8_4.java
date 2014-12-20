package recursion;

import java.util.ArrayList;

//Write a method to compute all permutations of a string
//return ���string��ȫ���������
//���Ӷ�O(n!)
public class PermutateString8_4 {

	//˼·����һ��ͦ���Ƶģ� ��ͬ�ĵؾ��ǲ���returnԭ������Щ(û�мӹ�����index��) ֻҪreturn�ӹ��þͿ���
	//����Ҫ��λ�ã���Ϊ��һ������� ���������У� ����Ҫ�ѱ��ε�index�ӵ�����λ��
	//�������շ��ص�,���Ƕ���ȫ��
		
public static ArrayList<String> mutation(String s){
	ArrayList<String> allrotations=new ArrayList<String>();
	if(s==null){return  null;
	}else if(s.length()==0){
		allrotations.add("");
		return allrotations;
	}
    char first=s.charAt(0);
    String s_sub=s.substring(1);//remove first char
    //recursive
    ArrayList<String> retrieving=mutation(s_sub);
    //retreiving ���arraylist����   ������һ��ݹ鷵�����������������,����string����1λ
    //����Щ�����������ÿ��λ�ö����뱾��ȡ�������Ǹ�char
    for(String word:retrieving){
    	//ÿ��word��ÿ��λ�ö�����һ��first
    	//length()+1��ԭ���� �ȷ�˵ 0���� abc a֮ǰҪ���� c֮��ҲҪ���� ����Ҫ+1
    	for(int j=0;j<word.length()+1;j++){
    		String addedWordString=insertCharAt(word,first,j);
    		allrotations.add(addedWordString);
    	}
    }
	
	return allrotations;
 }
	
public static String insertCharAt(String word, char first,int j){
	String firsthalf=word.substring(0,j); //java��ǰ�պ�����j���ᱻŪ��ȥ
	String secondhalf=word.substring(j);
	return firsthalf+first+secondhalf;
	
}	
	
	
	public static void main(String[] args) {
		for(int i=0;i<(mutation("123")).size();i++)
		System.out.println(mutation("123").get(i));

	}

}
