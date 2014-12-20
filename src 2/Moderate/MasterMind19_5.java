package Moderate;

import java.util.Arrays;

//有四个格子 有四种颜色的球红黄蓝绿。每次一个格子装一个球(可以红红黄黄之类不一定要一个颜色一个) 
//你猜测四个组合，如果颜色对位置也对 算一个hit 如果颜色对位置不对 算一个 算一个pseudo-hit
//eg：题目后来提示了 如果答案是 RYGB,猜测是：YRRR。那么hits很明显为0了。pseudo-hits是3
public class MasterMind19_5 {

	public static Result match(char[] answer,char [] guess){
	int hits=0;
	int pseudohits=0;
		for(int i=0;i<answer.length;i++) {
			if(guess[i]==answer[i]){
		    ++hits;
		   guess[i]=' ';
		
		}}
		System.out.println(guess);
	     for(int j=0;j<answer.length;j++) {
	    	 Arrays.sort(answer); //请记住 如果你要用binarysearch,必须确保你search的东西是sort过得！！！
	    		//System.out.println("aaa"+Arrays.binarySearch(answer, guess[j]));
	    	 if((Arrays.binarySearch(answer, guess[j]))!=-1){
			
				++pseudohits;
			  guess[j]=' ';
			}
	}
		 return new Result(hits, pseudohits);
		}
	
	
	public static void main(String[] args) {
	    char solution[] = {'R','Y','G','B'};
	    char guess[] = {'B','B','B','B'};
           Result result=match(solution,guess);
         System.out.println(result.hits);
           System.out.println(result.pseudohit);
	}

}

 class Result{
		int hits;
		int pseudohit;
	 public Result(int hits,int p) {
	this.hits=hits;
	pseudohit=p;
}

}