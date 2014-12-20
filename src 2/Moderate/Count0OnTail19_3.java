package Moderate;                                                   //阶乘
//Write an algorithm which computes the number of trailing zeros in n factorial.
//写一个算法计算n的阶乘末尾0的个数。
//把阶乘算出来是不科学的 因为阶乘可能很大 分分钟就溢出了
//要好好分析问题的根本，阶乘后面有好多0的很本身什么。是2x5产生的,其他乘不出0
//又因为有5必有（不止一个）2所以我们只要计算阶乘中有几个5就可以
public class Count0OnTail19_3 {

	
	public  static int  countZero(int n) {
		if(n<10){return -1;}
		int count=0;
		//注意，关键点是i=i×5
//		5!, 包含1*5, 1个5
//		10!, 包含1*5,2*5,因为是 factorial阶乘所以 （5^2）
//		15!, 包含1*5,2*5,3*5, （5^3）
//		20!, 包含1*5,2*5,3*5,4*5, （5^4）
//		25!, 包含1*5,2*5,3*5,4*5,5*5,（5^6）
//所以 这个循环里 第一次 i是5 第二次是25 第三次 （5^3）所以这样除能正确的出5数也就是0数。。。
		 //本质上是求n里含有的5^count 次方,因为乘count次了5----会产生count个0
		for(int i=5;n/i>0;i=i*5){
			count=count+n/i;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(3/5);

	}

}
