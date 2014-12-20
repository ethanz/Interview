package stackAndQueues;
//Describe how you could use a single array to implement three stacks.
//�ⷨһ��
//�����黮�ֳ�3�ȷݣ�ÿһ�ݶ���������ʵ��ջ��
//*��һ����ջ���� 0     �� n/3
//*�ڶ�����ջ���� n/3  �� 2n/3
//*��������ջ����2n/3 �� n
//���ֽⷨ�ǻ��ڶ�ÿ����ջ��ʹ��û�ж����ʹ��˵������������ֱ��Ϊÿ����ջ���̶ֹ��Ĵ�С��


//�ⷨ���еģ���Ҫ�����л��п���Ŀռ䣬��ջ�ͻ���������
//ÿ��Ϊ��ջ����һ���ռ��ʱ��������¿ռ��м�¼��һ���ռ��ַ��������ջ�е�ÿ��Ԫ�ض���һ��ָ��ָ��֮ǰ��Ԫ�ء�
//������ʵ�ַ�����һ������������һ����ջ����һ���ռ�(�ͷſռ�)������ռ䲢������Ϊ���пռ�����������档���������ǾͲ���ʹ���²����Ŀ��пռ䡣
//Ϊ�˽��������⣬������һ���б�����¼���еĿռ䡣�����¿��пռ���֣����ǾͰ������뵽������С������Ҫ�·���һ���ռ䣬�ʹ��������ɾ��һ��Ԫ�ء�
//������ʵ�ַ���ʹ��3����ջ�ܹ���̬��ʹ������Ŀռ䣬��������������ռ临�ӶȻ����ġ�


//��һ��array implement ����stack������ʲô��˼
//����������һ��array��һ���ڴ�ռ䣬Ȼ��������ڴ�ռ����� Ҫ������stack
// |---stack0----||-----stack1-----||-----stack2-----|
// |-------------------array-------------------------|
//��Ȼ  stack��һ���������� ����ʣ��ռ䡣
public class ArrayToStacks3_1 {
	class FixedDevideed{
	int stackSize=300; //����stack��Size ����һ����д����
	int[] array=new int[stackSize*3]; //������Ǹ�����implement three stacks��array
	//�㿴����ʵ�������������Ĳ��Ǻ���ȷ����Ŀ�����ǿ���take advantage
	//���������ǵķ�����Ҫ����Ŀ
	int[] stackPointer={0,0,0}; // ��������ָ�����stack��top element��λ��
	
	//��һ��stack
	void push(int stackNum, int value){
		// ���indexָ������push������Ԫ����array�е�λ��
		//          ��һ��stackNum��0      ���stack���Ǹ�λ����    �¼������� +1
		int index = stackNum*stackSize+stackPointer[stackNum] +1;
		//��stack��top����һλ
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
    //���ü������ֵ,ֻ��Ҫ
	  boolean flag=(stackPointer[stackNum]==stackNum*stackSize);
	  return flag;
	}
	//�ڶ�����˵һ�����Բ���Ū��ô���ӵ� ˵�������������ڶ���ˢ���ʱ��
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
