package stackAndQueues;


import java.util.ArrayList;



//��SetOfStack���а����ܶ�Ķ�ջ����һ����ջ�ﵽ���޵�ʱ��������һ����ջ��
//SetOfStack.push �� SetOfStack.popӦ�ú���ͨ��ջ�Ĳ���һ����
//ʵ��һ������popAt(int stack)��ָ�����ĸ���ջ�ϵ���Ԫ��

//��һ��arraylist,ÿ��Ԫ����һ��stack �������arraylist����sets of stacks
//���ڵ�����Ҫ�󣬿�������д��stack����涨ջid
//����������ÿ��stack��Ҫfull�˲�����һ��stack����push
public class SetsOfStacks3_3 {
	ArrayList<StackWithCapacity> setsofstacks = new ArrayList<StackWithCapacity>();
 
	public void push(Object o) {
		if (StackWithCapacity.ID == -1) {
			StackWithCapacity first = new StackWithCapacity(20);
			first.push(o);
			setsofstacks.add(first);
		} else {
			int currentId = StackWithCapacity.ID;
			boolean flag = !(setsofstacks.get(currentId).isFull());
			if (flag) {
				setsofstacks.get(currentId).push(o);
			} else {
				StackWithCapacity follow= new StackWithCapacity(20);
				follow.push(o);
				setsofstacks.add(follow);
			}
		}
	}
	
	public Object popAt(int stack) {
		if(stack<0||stack>StackWithCapacity.ID){
			System.out.println("This stack does not exist");
			return null;
		}
		int targetStack= stack;
		if(setsofstacks.get(targetStack).size==0){
			System.out.println("This stack is empty");
		return null;}
		else{
		return	setsofstacks.get(targetStack).pop();
		}
	 
	}

	public static void main(String[] args) {
		SetsOfStacks3_3 test = new SetsOfStacks3_3();
		for (int i = 0; i < 80; i++) {
			test.push(new Integer(i));		
		}
	
	System.out.println(	test.popAt(2));
	System.out.println(	test.popAt(2));
	System.out.println(	test.popAt(1));
	System.out.println(	test.popAt(0));
	}

}

// ���ﻹд�� �ϸ�
class StackWithCapacity extends Stack {
	static int ID = -1;
	int id;
	int capacity;
	int size = 0;

	StackWithCapacity(int capacity) {
		super();
		this.capacity = capacity;
		this.id = addID();
	}

	public void push(Object o) {
		super.push(o);
		size++;
	}

	public Object pop() {
		
			size--;
			return super.pop();
		
	}
	
	public static synchronized int addID() {
		return ID++;
	}

	public boolean isFull() {
		return size == capacity;
	}

}