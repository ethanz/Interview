package recursion;

import java.util.ArrayList;

//Write a method to compute all permutations of a string
//return 这个string的全部排列组合
//复杂度O(n!)
public class PermutateString8_4 {

	//思路和上一题挺相似的， 不同的地就是不用return原本的那些(没有加过本次index的) 只要return加过得就可以
	//还有要换位置，因为上一题是组合 本题是排列！ 所以要把本次的index加到所有位置
	//这样最终返回的,就是都齐全的
		
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
    //retreiving 这个arraylist里面   有着下一层递归返回来的所有排列组合,但是string的少1位
    //往这些排列组合里在每个位置都插入本次取出来的那个char
    for(String word:retrieving){
    	//每个word的每个位置都插入一下first
    	//length()+1的原因是 比方说 0插入 abc a之前要插入 c之后也要插入 所以要+1
    	for(int j=0;j<word.length()+1;j++){
    		String addedWordString=insertCharAt(word,first,j);
    		allrotations.add(addedWordString);
    	}
    }
	
	return allrotations;
 }
	
public static String insertCharAt(String word, char first,int j){
	String firsthalf=word.substring(0,j); //java是前闭后开所以j不会被弄进去
	String secondhalf=word.substring(j);
	return firsthalf+first+secondhalf;
	
}	
	
	
	public static void main(String[] args) {
		for(int i=0;i<(mutation("123")).size();i++)
		System.out.println(mutation("123").get(i));

	}

}
