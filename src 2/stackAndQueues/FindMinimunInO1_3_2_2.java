package stackAndQueues;
import org.omg.CORBA.ValueMemberHelper;

public class FindMinimunInO1_3_2_2 extends StackWithMinNode {
//3_2 ����ⷨ��ȱ�����ÿ��node������һ��min��space �Ƚ��˷ѿռ�
//���ǿ��Դ���һ������stackֻ������¼��С�ļ�¼
	             //����ջ��ֻ��¼��С��Ԫ��
	StackWithMinNode s2;
	public FindMinimunInO1_3_2_2(){
		s2 =new StackWithMinNode();
		
	}
	
	public void push(int value){
		if(value<=min()){
		s2.push(value);	//����½�����ֵ��С����ֵ�ͷ��븨��stack
	}
	super.push(value);//��������stack���ֵ
		}
	
	//��Ϊpushʱ����߼� ����stack�����Node�϶��ǴӴ�С�ģ�Խ��stack�׵�Խ��
	//���ǵ���Ҳ�Ǵ�top�����������ġ��������һ���͵�ǰmin����ֵһ��С��ֵ����ô
	//��Ȼ��stack�������Сֵ���ڸ���stack���top.next ���ԾͰѸ���stack���
	//top pop����
	public int pop(){
		int value =super.pop();
		if (value== min()){
			s2.pop();
		}
		return value;
	}
	
	public  int min(){
	if(s2.top==null){
		return Integer.MAX_VALUE;
	}	
	else{
		return s2.top.data;
	}
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
