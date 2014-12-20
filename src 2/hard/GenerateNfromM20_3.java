package hard;

import java.util.Arrays;

//Write a method to randomly generate a set of m integers from an array of size n. 
//Each element must have equal probability of being chosen.
//写一个函数，随机地从大小为n的数组中选取m个整数。要求每个元素被选中的概率相等
//本题和上一题差不多 可以说思路完全一样
public class GenerateNfromM20_3 {
	
	//写一个random函数(inclusive)
	
	public static  int rand(int low, int high){ //比方说high20 low 10 所以应该是10到20，有因为math。random返回[0,1)所以要+1然后再切成int
		return low+(int) (Math.random()*(high-low+1));
	}
	
	public  static int[]  randomNfromM(int m, int[] array) {
		int[] a=array.clone();
		int[] randomArray=new int[m];
		for(int i=0;i<m;i++){                //看清楚括号的顺序，不要漏掉（a.length-i）外面的括号 否则会a.length-i 会让random访问i之前已经拍好序的下标
			int random=i+(int) (Math.random()*(a.length-i));
		
			int temp=a[i];
			a[i]=a[random];
			a[random]=temp;
			randomArray[i]=a[i];
			
		}
		return randomArray;
	}

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,8,9};
		int[] b=randomNfromM(5, a);
 System.out.print(Arrays.toString(b));

	}

}
