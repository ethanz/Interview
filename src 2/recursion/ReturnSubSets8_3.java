package recursion;

import java.util.ArrayList;

//Write a method that returns all subsets of a set.
//写一个函数返回一个集合中的所有子集。
// For example S = {1, 2, 3} then P(s) = {{}, {1}, {2}, {3}, {1,2}, {1, 3}, {2, 3}, {1, 2, 3}}.
//If S has n elements in it then P(s) will have 2^n elements
//对于一个集合，它的子集一共有2^n 个(包括空集和它本身)。(初中数学)
//这道题目为什么可以用递归？ 因为我们能找到比原问题规模小却同质的问题。(请注意 这个思想非常重要)
//比方说 我先把1 拿出来 可以让我求2 3的子集，那么2 3的子集（2，3，  2 3）同时也是123的子集
//然后我把这个2 3的自己（2，3，23） 都把1加进去，于是就有了（1 2，1 3，123）还有 2 3 1 ，23 和空集

//所以此时 {} 1，2，3 123 和12，13，23都有了
//arraylist可以用来装集合和元素，请注意 每个单个子集都是arraylist，比方说一个子集是(123)实际上是arraylist{1,2,3}
//而子集里每个元素都是Integer，那个for循环里面其实加的都是integer

//直接arraylist（上一层返回的结果）。add（set.get(index)+上一层返回的结果）  返回上一层就行

public class ReturnSubSets8_3 {
     //假设我这个set是 {1,2,3,4}
	//1.方法一层层递归调用到下标4 然后
	//2.方法4返回一个空子集（一个空arraylist） 给方法3
	//3.方法3返回{}.{4} 给方法2（下标2）

	//4. 方法2循环2次（因为方法3返回2个arraylist）返回{({ 4}，{}).add({3，4}，{ 3})返回给方法1
	//5. 方法1循环4次{2,3,4,},{2,3},{2,4}{2},和原本的{3，4}，{ 3}，{ 4}，{}返回方法0
	//6.方法0循环8次然后再加上原版8个子集的 （每个返回的arraylist里都塞个1 然后加原来那8个子集的）
//{1,2,3,4,}{1,2,3}{1,2,4}{1,3,4}{1,2}{1,3}{1,4}{1}再加上	{2,3,4,},{2,3},{2,4},{2},{3，4}，{ 3}，{ 4}，{} 一共16个正确
//                          |                                                      |
//	                        |                                                      |
//	-----这些是foreach循环里加的moresubsets--------------|||--------这些是上层返回的原本的allsubsets---------
	//最后返回moresubesets.add(mroesubsets)
	
//	！！！！所以这个else里干的事情，就是保存原本的层返回来的每个子集，在add上上层返回来的每个子集加当前set.get(index)产生的新子集，
//	 再返回上一层。体现了递归的思想
//	

//	
	// index是set的下标，当然是从0开始啦
	public static ArrayList<ArrayList<Integer>> getSubSets(
			ArrayList<Integer> set, int index) {
		// 先把这个数据结构申明好 可以用来装所有的子集（子集也可能是由多个元素的 所以ArrayList<ArrayList<Integer>>）
		ArrayList<ArrayList<Integer>> allsubsets;
		// 下标到2的arraylist实际上有size=3，所以当前面已经从0迭代到2了，2+1=3了，表明set已经全部走完了，此时加入一个空集完事。
		 //然后直接跳到return 来return  allsubsets  内有一个空集
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // add 一个空集
		} else {// 假设现在index下标是2（递归调用到2层了）,此时我先调(set,3)
			allsubsets = getSubSets(set, index + 1); 
			//allsubsets里面是之前方法返回的所有子集						
			int current = set.get(index);// 然后我先把set[2] 赋值给current=3
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();// 然又定义一个子集
			for (ArrayList<Integer> subset : allsubsets) {// 请注意，这里是loop遍历的allsubsets
														 // 就是递归调用的那些方法返回的那些子集“们”,每次foreach each each一个子集
				                                         //此时，里面是空集（3返回来的）
				ArrayList<Integer> newsubset = new ArrayList<Integer>();// 新建一个arraylist,存放处理后的子集
				newsubset.addAll(subset); //newsubset.addAll 把之前返回来的的空集加到newsubset里了，
				//请注意addAll 是把一个子集Integer批量加到这个新的newsubset （像空集就什么都没有加上）
				newsubset.add(current);   //把3此时也加到这个newsubset里
				moresubsets.add(newsubset);//然后把这个含有3和空集的arraylist加到moresubsets里 然后继续这个循环
				//ps：moresubsets是 ArrayList<ArrayList<Integer>>
			}
			allsubsets.addAll(moresubsets);//循环走完了 返回给上一层递归的，add ALL 加的是子集们，就是arraylist们
		
		}

		return allsubsets;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
