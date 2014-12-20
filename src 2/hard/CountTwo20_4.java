package hard;

import java.util.zip.Inflater;

//Write a method to count the number of 2s between 0 and n.
//дһ������������0��n֮��2�ĸ����� ���� 222 ����3��2.
//������ һ��һ����ȥ�� ÿ�������м���2,����һ��Ҫn ����û��2Ҫlgn ����O(nlgn)
// while(n > 0){ //��һ������2λ�ķ���
 //   if(n%10 == 2)//���ʻ���һλһλȥ��
 //   ++count;
//     n /= 10;}

//��ô�ø��õķ���ȥ���ػ���������,divide and concur
//�ȷ�˵ ���� 0-99��2������x
//��ô0-199����2x 0-299���� 3x+100(2xx 100��)
//����513 �Ϳ��Բ�� f(0-499)+f(0-13)+100 =5x+f(13)+100
//�����279 �Ϳ��Բ�� 2x+f(79)+79+1
//�����õݹ�����
public class CountTwo20_4 {

	public static int count2(int n){
		if(n==0){return 0;}
		// 513 into 5 * 100 + 13. [Power = 100; First = 5; Remainder = 13]
		int power=1; //�ȷ�˵�������9527 power����1000,�Ǻ���ͬλ����С��
		while(10*power<n){
			power=power*10;  //����������ȷ��power 1x10 x10..x10..ֱ����N��
		}
		int first=n/power;//(��һλ������)
		int reminder=n%power;// ���˵�һλ֮��ʣ�µ����� ����5 2 7
		
		//�� 9000�ж��ٸ�2
		int twosInFirst=0;//ע�⣬���������2��count
		
		if(first>2){               //power��1000 �ǵ�ô
			twosInFirst=twosInFirst+power; //9000����2000������+1000��2
		}else if(first==2){        //ÿ��reminder����2
			twosInFirst=twosInFirst+reminder+1;
	 }else if(first==1){
		 twosInFirst=0;
	 }
	//��ʣ�µ�λ���ж���2(5..2..7)
                                   //power -1
		                           //(999)�����ǶԵ�,ǰ��������������ǰλ�м����������������2xxx�Ļ������ж���power��2
		int twosInElse=first*count2(power-1)+count2(reminder);
		
		return twosInElse+twosInFirst;
	}
	 
	
	public static void main(String[] args) {
		System.out.print(count2(8339));
	}
}
