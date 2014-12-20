package ArrayandString;

public class Uniquecharkey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baacd";
		boolean flag = isUniqueChars2(s);
		System.out.println(flag);
	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		 
		// boolean[] 的默认值都是false！！！！
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);// char 转int, char的ASCII 码以int的形式显示
			// 同样的char会有同样的int
	//		System.out.println(val);
			if (char_set[val])
			// boolean[]里的默认值是false 所以..一开始这个不会执行这个if
			{
				return false;
			}
			// 把这个char（ASCII 码）的boolean值改为true了，所以string如果接下来还有相同字符
			// 就会执行这个if (char_set[val]为true)了 所以就return false;并且跳出方法。
			char_set[val] = true;
		}
	//	System.out.print("1111");
		return true;// 这个和return false是在同一层里面的,所以前面如果return false；了就跳出不执行这个了。
	}

}
