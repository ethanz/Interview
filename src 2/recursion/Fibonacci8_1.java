package recursion;
//书的PDF 63页很重要recursive 主要可以用来解决“nth”“list first nth”“ compute all” 之类的问题
//它等于是给你了一个解决无限多的sub problems的武器。所以你先用方法搞定这个base proble 然后再用
//recursive 搞定衍生的subproblem 
public class Fibonacci8_1 {

	public static int Fibonacci(int n){
//多个if 和else if的 区别,多个if每个都会判断是否符合，if+多个else if的块只要其中一个符合 其他的就不判断了
		//类似 & 和&&的区别
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
