package recursion;
//Given an infinite number of quarters (25 cents), dimes (10 cents),
//nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.
//给你指定xx分钱 让你说能有几种 25/10/5/1 分笔组成的排列组合。
public class CentsDevided8_7 {
//这题和8-3 8-4 有一定相似性
//coding之前先分析问题，如何把它分解成sub问题
//假设n=100 cents,“现在quarter层处理” 用1个quarter 之后n=75.用2个quarter然后n=50.。。在把问题recursive到dime层 
//同理在dime层(这层就不用考虑quarter了), 用1个dime,用2个dime...然后再recursive到dime层... penny层。。。

//----比如， 现在我拿了一个25分的硬币，那下一次可以取的币值就是25,10,5,1；如果我拿了一个 10分的，
//下一次可以取的币值就只有10,5,1了；这样一来，就能保证，同样的组合， 我只累计了一次，	
	
	public static int makeChange(int n,int coinValue){
		int next_coinValue=0;
		switch (coinValue) {
		case 25:
			next_coinValue=10;
			 break;
		case 10:
			next_coinValue=5;
			break;
		case 5:
			next_coinValue=1;
			break;
		case 1:
			return 1; } //因为25，10，5 都用过了，只能用1了 那么剩下不论多少分都是全部都是1分，所以就一种组合方法
		                //return 1
	int ways=0;
	//请注意这个循环，核心业务逻辑在此
	//          //当前的coinValue,从0个开始 到小于等于总cents数结束 
	for(int i=0;i*coinValue<=n;i++){
		                   //eg:用掉了1个quater 就是（100-25，dime）去recursive
		ways=ways+makeChange(n-i*coinValue,next_coinValue);
	}   
	return ways;
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
