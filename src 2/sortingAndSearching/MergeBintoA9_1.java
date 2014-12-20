package sortingAndSearching;
//You are given two sorted arrays, A and B, and A has a large enough buffer
//at the end to hold B. Write a method to merge B into A in sorted order.
//A B都是sorted,现在要合并成一整个sorted数组

//请注意 为何这题要提示  A has a large enough buffer at the end to hold B？
//因为面试官想看看你是否能在不增加额外的空间开支下完陈这题。
//所以这题可以灵活应用下之前的mergesort
//A，B不是都sorted了吗，我们不从头开始比谁小，我们从A，B的尾巴开始比谁大
//谁大，谁就放到A的[(a最后一个有数据的下标)+(b.length)],然后该--下标的--,接下去就和普通mergesort一样
                           

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
			r--;}//跳出while了,然后只要把还没有弄完的那个弄进去就可了
		for(;lengtha>0;lengtha--){//因为要lengtha-- 所以要>0
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
