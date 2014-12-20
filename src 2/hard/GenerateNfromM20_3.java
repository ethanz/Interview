package hard;

import java.util.Arrays;

//Write a method to randomly generate a set of m integers from an array of size n. 
//Each element must have equal probability of being chosen.
//дһ������������شӴ�СΪn��������ѡȡm��������Ҫ��ÿ��Ԫ�ر�ѡ�еĸ������
//�������һ���� ����˵˼·��ȫһ��
public class GenerateNfromM20_3 {
	
	//дһ��random����(inclusive)
	
	public static  int rand(int low, int high){ //�ȷ�˵high20 low 10 ����Ӧ����10��20������Ϊmath��random����[0,1)����Ҫ+1Ȼ�����г�int
		return low+(int) (Math.random()*(high-low+1));
	}
	
	public  static int[]  randomNfromM(int m, int[] array) {
		int[] a=array.clone();
		int[] randomArray=new int[m];
		for(int i=0;i<m;i++){                //��������ŵ�˳�򣬲�Ҫ©����a.length-i����������� �����a.length-i ����random����i֮ǰ�Ѿ��ĺ�����±�
			int random=i+(int) (Math.random()*(a.length-i));
		
			int temp=a[i];
			a[i]=a[random];
			a[random]=temp;
			randomArray[i]=a[i];
			
		}
		return randomArray;
	}

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,8,9};
		int[] b=randomNfromM(5, a);
 System.out.print(Arrays.toString(b));

	}

}
