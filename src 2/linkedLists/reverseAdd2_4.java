package linkedLists;
//nλ������linkedlist�� �����ǵ���洢��
//eg��513 ��linkedlist���� Node1: 3-Node2: 1-Node3: 5
//���ڸ���2���Ѿ��������򴢴�õ�linkedlist Ȼ��д��function��������� ������Ҳ�����ַ���linkedlist
//Ϊʲô��������linked listת�����ֺ������� ����Ϊ����Ϊn �����п������int �������long(����������Թ��Ƿ���overflow)
//��Ϊ��nλ�����Կ��Կ��ǵݹ�---��λ
public class reverseAdd2_4 {

	public static LinkedListNode add(LinkedListNode a,LinkedListNode b,int carry){
		if (a == null && b == null) {
			 return null;
			 }
		//��ʱ�򿴳�����洢�ĺ��˰ɣ���λ����ǰ��������ӣ��ҹ�Ȼ��ͼ��ͼɮ��
		LinkedListNode result=new LinkedListNode(carry);
		int value=carry;
		if(a!=null){
            value=value+a.data;			
		}
		if(b!=null){
            value=value+b.data;			
		}
		// ��֤�õ��˵��������͸�λ������eg�� 8%10=8   13%10=3
		result.data = value % 10;
		
		if((a.data+b.data)>=10){
			carry=1;
		}                                  
		              //�ݹ����add����  //aΪnullô��Ϊ�Ļ����贫��null����Ϊ�Ļ��ʹ�����a.next
		LinkedListNode following = add(a == null ? null : a.next,
				b== null ? null : b.next,
			            value > 10 ? 1 : 0);
       //following ������һλ ��������2����� +��λ������еĻ���
		
		                                        //result.setNext( following); ���������linkedlistnode�Ļ�
		
		//��Ϊ�ǵݹ飬���Լӷ��Ľ������һλλ����ȥ����
		result.appendToTail(following.data);
			
	return   result;}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
