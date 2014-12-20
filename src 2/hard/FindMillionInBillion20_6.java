package hard;
//Describe an algorithm to find the largest 1 million numbers in 1 billion numbers.
//Assume that the computer memory can hold all one billion numbers.
//描述一个算法，在10亿个数中找到最大的1百万个数。假设内存可以一次性装入这10亿个数。
//虽然这道题的数据量很大，但由于题目已经假设所有的数据可以一次性装入内存， 所以题目中的10亿，
//1百万也就没有什么特殊含义了。 我们完全可以想像成在100个数中查找最大的10个数。
public class FindMillionInBillion20_6 {
//解法1. 直接排序 然后取前1 million complexity O(nlgn)
	
//	解法2 .最小堆（这个第二轮时候再看吧）
//
//	利用最小堆来维护最大的1百万个数，堆顶元素是这1百万个数中最小的。 遍历剩下的元素，当某一元素大于堆顶元素，
//	则用该元素替换堆顶元素， 然后调整堆结构，使其仍为最小堆。当遍历完所有10亿个数后， 堆中维护的就是最大的1百万个数。
//	在n个数中查找最大的k个数，该算法需要O(nlogk) 的时间。由于k一般要比n小得多，所以该算法比排序法要快。
//
//	该算法还有一个优点，就是便于处理大数据。比如说， 我们一般需要在非常多的数中找到最大(最小)的k个数，
//	这个k一般比较小， 而n却可能大得无法一次性载入内存。这时候我们就可以在内存中维护一个k 个元素的最小(最大)堆，
//	然后把数据分多次从磁盘读入内存进行处理。
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
