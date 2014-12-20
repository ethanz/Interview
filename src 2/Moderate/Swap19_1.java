package Moderate;
//Write a function to swap a number in place without temporary variables.
//写一个函数交换两个数，不能使用临时变量。

public class Swap19_1 {      
public static void swap1(int a,int b){
	a=a-b; // 注释里的a b都是以原来的a b
	b=a+b;//=(a-b)+b=原来的a
	a=b-a;//(a-b)+b-(a-b)=原来的b
}
	
//用bit manipulation
public static void swap2(int a,int b){
    a=a^b;  //(^异或) 0^1=1, 1^0=1, 1^1=0^0=1 一样是0 不一样是1
    b=a^b;
    a=a^b;
}  //异或后会正好交换

//使用它们之前一定要想一想，
//你的程序中，是否有可能会让swap中的两个形参引用同一变量。 如果是，那么上述两个swap函数都将出问题。	
//所以最好还是老老实实的用有temp variable的swap方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
