package Moderate;

//Given an integer between 0 and 999,999,
//print an English phrase that describes the integer (eg, "One Thousand, Two Hundred and Thirty Four").
//用语言文字描述10w以下的整数
public class DescInteger19_6 {
	// 先准备好词库
	static String[] wordarr1 = { "", "One ", "Two ", "Three ", "Four ",
			"Five ", "Six ", "Seven ", "Eight ", "Nine " };
	static String[] wordarr11 = { "", "Eleven ", "Twelve ", "Thirteen ",
			"Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
			"Nineteen " };
	static String[] wordarr10 = { "", "Ten ", "Twenty ", "Thirty ", "Forty ",
			"Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " };
	static String[] wordarr100 = { "", "Hundred ", "Thousand " };

	public static String translation(int num){
		 //先判断n有几位
		 int len=test(num);
		
		 int temp;
		 StringBuilder sb = new StringBuilder();
		 if(num==0){
			sb.append("Zero");
			     //位数%2等于0 就是说偶位数再+1
		}else{
			do{ //if number >999
				if(len>3){  //假如是500k 就是除以10k
					temp = (num / (int)Math.pow((double)10,(double)len-2));
					// If tmp is 2 digit number and not a multiple of 10
					if (temp / 10 == 1 && temp%10 != 0) {
					 sb.append(wordarr11[temp % 10]) ;
						 } else {
						 sb.append(wordarr10[temp / 10]);
						 sb.append(wordarr1[temp % 10]);
						 }
					if (temp > 0) {
						 sb.append(wordarr100[len / 2]);
						 }
						 num = num % (int)(Math.pow((double)10,(double)len-2));
						 len = len-2;	
				}else { // Number is less than 1000
					 temp = num / 100;
					 if (temp != 0) {
					 sb.append(wordarr1[temp]);
					 sb.append(wordarr100[len / 2]);
					 }
					 temp = num % 100 ;
					 if(temp / 10 == 1 && temp % 10 != 0) {
					 sb.append(wordarr11[temp % 10]) ;
					 } else {
					 sb.append(wordarr10[temp / 10]);
					sb.append(wordarr1[temp % 10]);
					 }
					 len = 0;
			}			}while(len>0);}
			return sb.toString();}

	public static int test(int n) {
		int len = 1;
		while (n / 10 > 0) {
			len++;
			n = n / 10;
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.print(translation(99999));

	}

}
