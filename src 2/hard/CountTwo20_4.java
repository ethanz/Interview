package hard;

import java.util.zip.Inflater;

//Write a method to count the number of 2s between 0 and n.
//写一个函数，计算0到n之间2的个数。 比如 222 就有3个2.
//暴力法 一个一个数去数 每个数里有几个2,遍历一次要n 数有没有2要lgn 所以O(nlgn)
// while(n > 0){ //查一个数有2位的方法
 //   if(n%10 == 2)//本质还是一位一位去数
 //   ++count;
//     n /= 10;}

//怎么用更好的方法去数呢还是老样子,divide and concur
//比方说 假设 0-99的2数量是x
//那么0-199就是2x 0-299就是 3x+100(2xx 100个)
//所以513 就可以拆成 f(0-499)+f(0-13)+100 =5x+f(13)+100
//如果是279 就可以拆成 2x+f(79)+79+1
//可以用递归来做
public class CountTwo20_4 {

	public static int count2(int n){
		if(n==0){return 0;}
		// 513 into 5 * 100 + 13. [Power = 100; First = 5; Remainder = 13]
		int power=1; //比方说传入的是9527 power就是1000,是和他同位的最小数
		while(10*power<n){
			power=power*10;  //这样可以正确求到power 1x10 x10..x10..直到比N大
		}
		int first=n/power;//(第一位的数字)
		int reminder=n%power;// 除了第一位之后剩下的数字 比如5 2 7
		
		//数 9000有多少个2
		int twosInFirst=0;//注意，这个变量是2的count
		
		if(first>2){               //power是1000 记得么
			twosInFirst=twosInFirst+power; //9000包含2000所以先+1000个2
		}else if(first==2){        //每个reminder都是2
			twosInFirst=twosInFirst+reminder+1;
	 }else if(first==1){
		 twosInFirst=0;
	 }
	//数剩下的位数有多少2(5..2..7)
                                   //power -1
		                           //(999)真心是对的,前面真心是算了最前位有几个二，和如过包含2xxx的话里面有多少power个2
		int twosInElse=first*count2(power-1)+count2(reminder);
		
		return twosInElse+twosInFirst;
	}
	 
	
	public static void main(String[] args) {
		System.out.print(count2(8339));
	}
}
