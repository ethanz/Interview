package Moderate;

import java.util.Arrays;

//���ĸ����� ��������ɫ���������̡�ÿ��һ������װһ����(���Ժ��ƻ�֮�಻һ��Ҫһ����ɫһ��) 
//��²��ĸ���ϣ������ɫ��λ��Ҳ�� ��һ��hit �����ɫ��λ�ò��� ��һ�� ��һ��pseudo-hit
//eg����Ŀ������ʾ�� ������� RYGB,�²��ǣ�YRRR����ôhits������Ϊ0�ˡ�pseudo-hits��3
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
	    	 Arrays.sort(answer); //���ס �����Ҫ��binarysearch,����ȷ����search�Ķ�����sort���ã�����
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