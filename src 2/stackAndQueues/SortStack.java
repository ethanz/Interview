package stackAndQueues;

// sort a stack in ascending order 
//ֻ����push | pop | peek | isEmpty
//stackֻ���ڶ��˲��� ��ôsort�أ�
//��һ������stack Ȼ���ԭ��stack   top  pop��ȥ��������stack ����Ҫreturn���Ǹ� ascending order topСbottom��

//Ȼ��pop�ڶ�����ʱ�� �ȴ�С������	pop����ԭstack�� top�ȸ���stack�����С(����վpeek)�� ok ֱ��push������stack
//����	pop����ԭstack�� top�ȸ���stack����Ĵ�peek�����Ķ������ݴ�һ�£� ���ǾͲ���ֱ��push������ջ�ˣ�Ҫ�ø���ջpop��topȻ��
//push��ԭ����stack��Ȼ���pop�����Ķ����͸���ջtop�ȴ�С���������pop���������� ����ջ��pop,��push��ԭ��ջ�� 
//ֱ������stack��top��pop�����Ķ���С ���ߵ��� ���� ����ջ���� Ϊֹ��Ȼ�� �ٰ�pop��������push������ջ��
//���Ӷ�ΪO(N2)
public class SortStack extends Stack {

	public static Stack goingToStack(Stack raw) {
		Stack sorted = new Stack();
		if (raw == null) {
			return null;
		}
		if (sorted.top == null) {
			sorted.push(raw.pop());
		}
		//while stack raw is not empty
        while(!raw.isEmpty()){
        	Integer temp=(Integer) raw.pop();             //temp�� sorted�����topС���������push��ȥ��Υ��ascending order��
        	while (!sorted.isEmpty()&&(Integer)sorted.peek()<temp) {
			   raw.push(sorted.pop());  //����Ҫpush��ԭstack�ٱȡ���ѭ��
							}
        	//��sorted����top>=tempʱ�򣬾Ϳ�������push��sorted����
        	sorted.push(temp);
        	//��ȻСѭ����ʱ�����ˣ�����while(!raw.isEmpty()) ��ѭ����û���������Դ�ѭ�������loop ֱ��raw��
        	}
		return sorted;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
