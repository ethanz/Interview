package hard;
//Write a function that adds two numbers. You should not use + or any arithmetic operators.
//写一个Add函数求两个数的和，不能使用+号或其它算术运算符。
//bit manipulation
public class AddWithoutPlusSign20_1 {

//	能把这假加法个过程弄得更简单点吗？答案是YES，我们可以把求两个数的和分成两步， “加"与"进位"，看例子：
//
//    计算759 + 674，但不考虑进位，得到323。
//
//    计算759 + 674，只考虑进位，而不是去加每一位，得到1110。
// 再加起来就得到解 1433 但是再加也不能用加号啊  所以用recursive	
//如果二进制要这样弄的话
//不考虑近位的“加”   1+0/0+1 =1  1+1/0+0=0  所以用异或 ^
//进位的话,当a b 都是1时候 会往前进一位 所以(a&b)<<1  
//比方说101+111==1100
// 那么加就可以说 0,1,0
//进位就是          1,0,1,0
//进位和加要最后再加起来才可以--recursive
	
	public static  int addWithoutPlus(int a,int b){
		if(a==0){return b;}
		if(b==0){return a;}
		int add=a^b;
		int carry=(a&b)<<1;
		return addWithoutPlus(add, carry);
		//recursive到最后会有一个加成0 所以就返回了值
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
