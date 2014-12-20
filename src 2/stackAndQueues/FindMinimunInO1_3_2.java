package stackAndQueues;

//新设计一个stack，使得其有一个找到stack里最小值的功能
//并且push pop和 找最小值min都要O(1)
public class FindMinimunInO1_3_2 extends StackWithMinNode {
	// 我自己想了一个思路(和解法1是一样的)因为stack其实只是对top一端实施操作
	// 所以如果改写Node让 Node可以指向这个最小值，那么不管top在那里都可以让MIN O(1),
	// 此外每次push时候就和新最小值比大小即可，push还是O1
	//这个解法的缺点就是每个node都新增一个min的space 比较浪费空间

	//这么push的好处都有啥
	//每次新往stack里面加Node的。就是本次data和以前所有data的最小值，然后把这个值
	//存在这次TOP的min里。。所以 每个node的min是不一样的
	//所以不管怎么pop 当前top的min都是stack里的最小值
	public void push(int value) {
		int newMin = Math.min(value, min());
		NodeWithMin temp = new NodeWithMin(value, newMin);
		temp.next = top;
		top = temp;
	}

	public int min() {
		if (top.min == 0) {
			return Integer.MAX_VALUE;// 值为 2的31次方-1 的常量,它表示 int 类型能够表示的最大值。
		} else {
			return top.min;
		}
	}

	public int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}
		return Integer.MAX_VALUE;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
