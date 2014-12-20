//���⽨��ѧ��ڰ��� recursive��������
package stackAndQueues;

//Hanoi�� 3�����ӣ���Ϊֻ�ڶ��˲�������������stack����Ҫ���) N������ 
//����һ��Ҫ�Ӵ������� С������
//��ʵ��һ��Ҫ��дnode����Ϊstack����Է��κ�

//���ֻ��һ�����ӣ�����ֱ���Ƶ��������
//�����2�����ӣ���Ȼһ��ʼ������tower1��
//1.T1 pop��һ�����ӣ�push��T2
//2.T2 pop�ڶ������ӣ�push��T3
//3.T2 pop��һ�����ӣ�push��T3

//��������������أ�
//1.T1 pop��һ�����ӣ�push��T3
//2.T1 pop�ڶ������ӣ�push��T2
//3.T3 pop��һ�����ӣ�push��T2
//4.T1 pop���������ӣ�push��T3
//5.T2 pop��һ�����ӣ�push��T1
//6.T2 pop�ڶ�������, push��T3
//7.T1 pop��һ�����ӣ�push��T3
//������ recursive �ݹ���Խ������
//������������? ������� moveDisks �������ǵݹ���ʵ����1��7
//(123)�������������ƶ��ķ������������������ƶ����ڶ���������
//(4)�������������ƶ�������������
//(567)�ڲ��������ķ������ڶ��������ϵ����������ƶ������������ӡ�

public class TowersOfHanoi3_4 {

	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		// ��push��ȥ�Ĵ�������Խ��ԽС�ģ�����Ҫ����n��ʼ
		for (int i = n; i > 0; i--)
			towers[0].push(new Integer(i));
		    //��һ����towers[0]
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
		 int top = (Integer) pop();//�ǵ��ø÷�������pop
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