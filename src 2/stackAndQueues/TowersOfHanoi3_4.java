//本题建议学完第八章 recursive后再来看
package stackAndQueues;

//Hanoi塔 3个柱子（因为只在顶端操作所以是三个stack，需要编号) N个盘子 
//盘子一定要从大盘在下 小盘再上
//其实不一定要重写node，因为stack类可以放任何

//如果只有一个碟子，可以直接移到最后柱子
//如果有2个碟子（当然一开始都是在tower1）
//1.T1 pop第一个碟子，push到T2
//2.T2 pop第二个碟子，push到T3
//3.T2 pop第一个碟子，push到T3

//如果有三个碟子呢？
//1.T1 pop第一个碟子，push到T3
//2.T1 pop第二个碟子，push到T2
//3.T3 pop第一个碟子，push到T2
//4.T1 pop第三个碟子，push到T3
//5.T2 pop第一个碟子，push到T1
//6.T2 pop第二个碟子, push到T3
//7.T1 pop第一个碟子，push到T3
//所以用 recursive 递归可以解决问题
//那三个碟子呢? 所以这个 moveDisks 方法就是递归来实现了1～7
//(123)采用两个碟子移动的方法，讲上两个碟子移动到第二根柱子上
//(4)将第三个碟子移动到第三根柱子
//(567)在采用运来的方法将第二根柱子上的两个碟子移动到第三根柱子。

public class TowersOfHanoi3_4 {

	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		// 先push进去的大，盘子是越来越小的，所以要到从n开始
		for (int i = n; i > 0; i--)
			towers[0].push(new Integer(i));
		    //第一个塔towers[0]
		towers[0].moveDisks(n, towers[2], towers[1]);
	}


}
 

class Tower extends Stack {
	int index;
     Object pop(){
    	return super.pop(); 
     };
	public Tower(int num) {
		this.index= num;
	}
	public void moveTopTo(Tower t) {
		 int top = (Integer) pop();//是调用该方法的塔pop
		 t.push(top);
				 }
	public void moveDisks(int n, Tower destination, Tower buffer) {
		 if (n > 0) {
		 moveDisks(n - 1, buffer, destination);
		 moveTopTo(destination);
		 buffer.moveDisks(n - 1, destination, this);
		 }
	
}}

// class HanoiNode extends Node{
// static int WEIGHT=0;
// int weight;
// public HanoiNode(Object d) {
// super(d);
// this.weight=increments();
// }

// synchronized int increments(){
// WEIGHT++;
// return WEIGHT;}

// }