package ArrayandString;

//Implement an algorithm to determine if a string has all unique characters. 
//What if you can not use additional data structures?


//别看了 以下这是错的 
public class Uniquechar1_1 {
	//默认是false 如果重复会变true
	boolean flag=false;
	boolean result;
	String s;

	public Uniquechar1_1(String b) {
		s = b;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "abcdefgghijkfil";
		boolean flag2 = ((new Uniquechar1_1(text)).detect());
		System.out.println(flag2);

	}

	
	public boolean detect() {
		int l = this.s.length();
		System.out.println(this.s);
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				//== 是比对象，equals 是比值
				
				if (((Character) this.s.charAt(i)).equals(this.s.charAt(j))) {
					//搜到相同的就return了 后面没必要再比
					return flag=true;
					
				} 
				//这里不能这么写 除非每个字符都相同， 因为要循环多次，又因为string里面不是每个字符都一样，到有一个不同的就会return false 把前面flag值的盖掉
				//错误else{return flag=false;}
			//所以才要一开始是false然后检查到对的改对
			}

		}
		return flag;

	}
}
