package Moderate;

//You are given an array of integers (both positive and negative).
//Find the continuous sequence with the largest sum. Return the sum.

//给出一个整数数组(包含正数和负数)，找到和最大的连续子序列，返回和。(不用返回子序列)
// 这题比那些动态规划的题目简单一点，为什么呢？
//因为题目要求找连续子序列 就是说这些要连续的。 
//因为这点，本题目可以一次遍历O（n）就做出来 
//当加到a[i]时候 如果当前sum小于0 就把0-i都扔掉 重新加起
//然后每次当currentSum大于maxSum的时候更新maxSum,这样 在过程当中最大的maxSub就会被保留
public class LargestSequenceSum19_7 {
	// 注意要考虑 只有负数的情况 所以 要先和maxsum判断 在和大于小于0判断
	public static int maxSub(int[] a) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum = currentSum + a[i];
	 
			if (currentSum > maxSum) {
				maxSum = currentSum;
			} else if (currentSum < 0) {
				currentSum = 0;
			} // 这2个只可能发生一个嘛 那就else if吧
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] a = { 2, -8, 3, -2, 4, -10 };
		System.out.print(maxSub(a));

	}

}
