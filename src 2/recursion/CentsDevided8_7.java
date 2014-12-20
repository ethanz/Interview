package recursion;
//Given an infinite number of quarters (25 cents), dimes (10 cents),
//nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.
//����ָ��xx��Ǯ ����˵���м��� 25/10/5/1 �ֱ���ɵ�������ϡ�
public class CentsDevided8_7 {
//�����8-3 8-4 ��һ��������
//coding֮ǰ�ȷ������⣬��ΰ����ֽ��sub����
//����n=100 cents,������quarter�㴦�� ��1��quarter ֮��n=75.��2��quarterȻ��n=50.�����ڰ�����recursive��dime�� 
//ͬ����dime��(���Ͳ��ÿ���quarter��), ��1��dime,��2��dime...Ȼ����recursive��dime��... penny�㡣����

//----���磬 ����������һ��25�ֵ�Ӳ�ң�����һ�ο���ȡ�ı�ֵ����25,10,5,1�����������һ�� 10�ֵģ�
//��һ�ο���ȡ�ı�ֵ��ֻ��10,5,1�ˣ�����һ�������ܱ�֤��ͬ������ϣ� ��ֻ�ۼ���һ�Σ�	
	
	public static int makeChange(int n,int coinValue){
		int next_coinValue=0;
		switch (coinValue) {
		case 25:
			next_coinValue=10;
			 break;
		case 10:
			next_coinValue=5;
			break;
		case 5:
			next_coinValue=1;
			break;
		case 1:
			return 1; } //��Ϊ25��10��5 ���ù��ˣ�ֻ����1�� ��ôʣ�²��۶��ٷֶ���ȫ������1�֣����Ծ�һ����Ϸ���
		                //return 1
	int ways=0;
	//��ע�����ѭ��������ҵ���߼��ڴ�
	//          //��ǰ��coinValue,��0����ʼ ��С�ڵ�����cents������ 
	for(int i=0;i*coinValue<=n;i++){
		                   //eg:�õ���1��quater ���ǣ�100-25��dime��ȥrecursive
		ways=ways+makeChange(n-i*coinValue,next_coinValue);
	}   
	return ways;
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
