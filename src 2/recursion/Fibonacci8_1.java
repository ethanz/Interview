package recursion;
//���PDF 63ҳ����Ҫrecursive ��Ҫ�������������nth����list first nth���� compute all�� ֮�������
//�������Ǹ�����һ��������޶��sub problems�����������������÷����㶨���base proble Ȼ������
//recursive �㶨������subproblem 
public class Fibonacci8_1 {

	public static int Fibonacci(int n){
//���if ��else if�� ����,���ifÿ�������ж��Ƿ���ϣ�if+���else if�Ŀ�ֻҪ����һ������ �����ľͲ��ж���
		//���� & ��&&������
		if(n==0){return 0;
		}else if(n==1){
			return 1;
		}else if(n>1){
			return Fibonacci(n-1)+Fibonacci(n-2);
		}else{return -1;}
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.print(Fibonacci(10));

	}

}
