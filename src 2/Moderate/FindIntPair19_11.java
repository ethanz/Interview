package Moderate;

import java.lang.reflect.Array;
import java.util.Arrays;

//Design an algorithm to find all pairs of integers within an array which sum to a specified value.
//设计一个算法，找到数组中所有和为指定值的整数对。
//如果比方说，指定值是10 a[0]是5 你遍历一边找另一个5 这样复杂度是O(n^2) 肯定是要被面试官鄙视的
//那么怎么降低复杂度呢（需要O(1)空间复杂度  O(nlgn)时间复杂度） 遍历一便+二分一遍 nlgn
//你可以先sort 一下这个数组 ,然后用low 和high 指向首位最小和最大的元素 
//假如说 low+high比 指定的sum大,那么high+数组里任何数都不可能等于指定值了 所以high可以舍弃 high--
//直到low+high<= sum 了 那个high才是有意义的high,这个high后面的high都可以舍弃不看
//同理 如果low+high比指定sum小，那么low+数组里任何数都不可能等于指定值了 所以low可以舍弃 low++
//如果sum=low+high 正好 打印 然后low++ high--
//直到low>=high 跳出循环
public class FindIntPair19_11 {
		public static void printSum(int[] a, int sum){
	Arrays.sort(a);
	int first=0;
	int last=a.length-1;
	while(first<last){
		int s=a[first]+a[last];
		if(s==sum){
			System.out.println(a[first]+"+"+a[last]);
			++first;
			--last;//不要重复用 要不断缩小数组			
		}else if(s<sum){
			++first;//合太小了所以a[first]要变大
		}else{//此时s>sum,合太大了所以a[last]要变小
			last--;
		}
		}
	}

		
	
	public static void main(String[] args) {
		  int[] a = { 1, 2, 3, 4, 5, 6,8,9,10,11};
		  printSum(a,7); 
// 程序是这样的，第一次是12太大，所以新下标变10
//还是太大，9.8.7.
//6时候正好 输出, 然后22,5 正好 输出
//然后3.5 正好 输出
  
}
}