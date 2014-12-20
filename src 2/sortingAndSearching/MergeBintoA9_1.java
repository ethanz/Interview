package sortingAndSearching;
//You are given two sorted arrays, A and B, and A has a large enough buffer
//at the end to hold B. Write a method to merge B into A in sorted order.
//A B����sorted,����Ҫ�ϲ���һ����sorted����

//��ע�� Ϊ������Ҫ��ʾ  A has a large enough buffer at the end to hold B��
//��Ϊ���Թ��뿴�����Ƿ����ڲ����Ӷ���Ŀռ俪֧��������⡣
//��������������Ӧ����֮ǰ��mergesort
//A��B���Ƕ�sorted�������ǲ���ͷ��ʼ��˭С�����Ǵ�A��B��β�Ϳ�ʼ��˭��
//˭��˭�ͷŵ�A��[(a���һ�������ݵ��±�)+(b.length)],Ȼ���--�±��--,����ȥ�ͺ���ͨmergesortһ��
                           

public class MergeBintoA9_1 {

	public static int[] mergeBtoA(int[] a,int indexOfLastAData, int[] b){
		
		if((indexOfLastAData+1+b.length)>a.length){
			System.out.println("a deosn't have enough buffer");
			return null;
	
		}
			
		int lengtha=indexOfLastAData;
		int lengthb=b.length-1;
		int r=lengtha+b.length;
		while(true){
			if(a[lengtha]>b[lengthb]){
				a[r]=a[lengtha];
				if(--lengtha<0){break;}
			}else{
				a[r]=b[lengthb];
			if(--lengthb<0){break;}
			}
			r--;}//����while��,Ȼ��ֻҪ�ѻ�û��Ū����Ǹ�Ū��ȥ�Ϳ���
		for(;lengtha>0;lengtha--){//��ΪҪlengtha-- ����Ҫ>0
			a[--r]=a[lengtha];
		}
		for(;lengthb>0;lengthb--){
			a[--r]=b[lengthb];
		}
		return a;	
	}
		
	
	
	public static void main(String[] args) {
		int[] a=new int[20];
	a[0]=1;
	a[1]=2;
	a[2]=3;
	a[3]=4;
	a[4]=5;
	int lastofAData=4;
	int[] b={4,5,6,7};
	int[] c=mergeBtoA(a,lastofAData,b);
	for(int i=0;i<c.length;i++){
		System.out.print(c[i]);
		}
	}

}
