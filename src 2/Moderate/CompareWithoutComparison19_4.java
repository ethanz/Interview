package Moderate;
//Write a method which finds the maximum of two numbers.
//You should not use if-else or any other comparison operator.
//写一个函数返回两个数中的较大者，你不能使用if-else及任何比较操作符。
public class CompareWithoutComparison19_4 {
//这题要用到bit manipulation(其实我觉得类似莫名其妙的题目都要用到bit manipulation)
//众所周知，int是32个bit 正数int的第一个bit是0 复数的第一个bit是1
	
 public static int returnBigger(int a,int b) {
	int c=a-b; 
	int[] temp={a,b};
	c=Math.abs(c>>31);//a大 为0,b大 为1. 记得要转成无符号类型 否则有可能出现-1
	
	return temp[c];
}	
	
	public static void main(String[] args) {
 
		int a=returnBigger(344, 999);
	System.out.print(a);
	
	}}