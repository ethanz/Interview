package hard;

//有bug
import java.util.Arrays;
import java.util.Comparator;

//Write a program to find the longest word made of other words in a String[].
//在一个String[]里，找到由其它单词组成的最长单词。
public class FindLargestWord20_7 {
	// 首先按照 String.length排序,然后 从最长的单词开始
	// string arr[] = {"test", "tester", "testertest", "testing",
	// "apple", "seattle", "banana", "batting", "ngcat",
	// "batti","bat", "testingtester", "testbattingcat"};
	// 比方说testbatting 不断地取单词的前缀s，当s存在于单词数组中，递归调用该函数，
	// 判断剩余串是否可以由其它单词组成。如果可以，返回true。
	// 比方说 t-false te-false, tes-false test-true 然后再看是看battingcat b-false
	// ba-false bat-true 然后看tingcat-都没有的
	// 再返回上一层 退递归来到处理battingcat那一层。 接着上次的bat继续处理：batt不在数组中，batti在数组中；递归调用去处理剩余串
	// ngcat，n，ng，ngc，ngca都不在数组中，
	// ngcat存在数组中。递归调用处理剩余串， 发现剩余串为空，返回真。

	public static String findLongest(String[] a) {
		if (a == null) {
			return null;
		}
		Arrays.sort(a, new lengthComparator());
		for (int i = 0; i < a.length - 1; i++) {
			if (isLongest(a, a[i])) {
				return a[i];
			}
		}
		return null;
	}

	public static boolean isLongest(String[] a, String word) {
		if (word.equals("")) {
			return true;
		} // 这里是遍历word里的字母 所以是word的长度
		for (int i = 0; i < word.length(); i++) {
			//当这截的前半段的能在此字符串里找到,而且后半段递归调用后也是最后返回true 就返回true
			//不行的话 什么都不返回 for循环继续下一个判断 t  te tes test。。。
			if (findWord(a, word.substring(0, i + 1))
					&& isLongest(a, word.substring(i + 1))) {
				return true;
			}
		}
		return false;
	}
//遍历搜索 a里是否有temp,其实用hashtable 预处理后查询更好
	private static boolean findWord(String[] a, String temp) {
		for (String string : a) {
			if (string.equals(temp)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] arr = { "test", "tester", "testertest", "testing", "apple",
				"seattle", "banana", "batting", "ngcat", "batti", "bat",
				"testingtester", "testbattingcat" };
		System.out.print(findLongest(arr));
	}

}

class lengthComparator implements Comparator<String> {

	public int compare(String o1, String o2) {
		if (o1.length() < o2.length()) {
			return 1;
		}
		if (o1.length() > o2.length()) {
			return -1;
		}
		return 0;
	}

}
