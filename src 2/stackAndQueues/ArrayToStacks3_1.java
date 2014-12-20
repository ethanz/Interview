package stackAndQueues;
//Describe how you could use a single array to implement three stacks.
//解法一：
//将数组划分成3等份，每一份独立的用来实现栈。
//*第一个堆栈：从 0     至 n/3
//*第二个堆栈：从 n/3  至 2n/3
//*第三个堆栈：从2n/3 至 n
//这种解法是基于对每个堆栈的使用没有额外的使用说明，所以我们直接为每个堆栈划分固定的大小。


//解法二中的，主要数组中还有空余的空间，堆栈就还能增长。
//每次为堆栈分配一个空间的时候，在这个新空间中记录上一个空间地址。这样堆栈中的每个元素都有一个指针指向之前的元素。
//这样的实现方法有一个问题就是如果一个堆栈弹出一个空间(释放空间)，这个空间并不会作为空闲空间现在数组后面。这样话我们就不能使用新产生的空闲空间。
//为了解决这个问题，我们用一个列表来记录空闲的空间。当有新空闲空间出现，我们就把它加入到这个表中。如果需要新分配一个空间，就从这个表中删除一个元素。
//这样的实现方法使得3个堆栈能够动态的使用数组的空间，但是这是以增大空间复杂度换来的。


//用一个array implement 三个stack到底是什么意思
//你可以想象成一个array是一个内存空间，然后在这个内存空间里面 要有三个stack
// |---stack0----||-----stack1-----||-----stack2-----|
// |-------------------array-------------------------|
//当然  stack不一定都是满的 还有剩余空间。
public class ArrayToStacks3_1 {
	class FixedDevideed{
	int stackSize=300; //单个stack的Size 方法一里面写死了
	int[] array=new int[stackSize*3]; //这就是那个用来implement three stacks的array
	//你看，其实，对于条件给的不是很明确的题目，我们可以take advantage
	//来按照我们的方便来要求题目
	int[] stackPointer={0,0,0}; // 这个存的是指向各个stack的top element的位置
	
	//第一个stack
	void push(int stackNum, int value){
		// 这个index指的是新push进来的元素在array中的位置
		//          第一个stackNum是0      这个stack在那个位置了    新加入的这个 +1
		int index = stackNum*stackSize+stackPointer[stackNum] +1;
		//该stack里top增加一位
		stackPointer[stackNum]++;
	    array[index]= value;
	    	
	}
	
	int pop(int stackNum){
		int index= stackNum*stackSize+stackPointer[stackNum];
		int value=array[index];
		array[index]=0;
		stackPointer[stackNum]--;
		
return value;	}
		
	int peek(int stackNum){
		int index= stackNum*stackSize+stackPointer[stackNum];
		return array[index];
			}

	boolean isEmpty(int stackNum){
    //不用检查具体的值,只需要
	  boolean flag=(stackPointer[stackNum]==stackNum*stackSize);
	  return flag;
	}
	//第二题点点说一半面试不会弄这么复杂的 说不定可以留给第二遍刷题的时候
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
