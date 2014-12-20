package hard;

//��bug
import java.util.Arrays;
import java.util.Comparator;

//Write a program to find the longest word made of other words in a String[].
//��һ��String[]��ҵ�������������ɵ�����ʡ�
public class FindLargestWord20_7 {
	// ���Ȱ��� String.length����,Ȼ�� ����ĵ��ʿ�ʼ
	// string arr[] = {"test", "tester", "testertest", "testing",
	// "apple", "seattle", "banana", "batting", "ngcat",
	// "batti","bat", "testingtester", "testbattingcat"};
	// �ȷ�˵testbatting ���ϵ�ȡ���ʵ�ǰ׺s����s�����ڵ��������У��ݹ���øú�����
	// �ж�ʣ�മ�Ƿ����������������ɡ�������ԣ�����true��
	// �ȷ�˵ t-false te-false, tes-false test-true Ȼ���ٿ��ǿ�battingcat b-false
	// ba-false bat-true Ȼ��tingcat-��û�е�
	// �ٷ�����һ�� �˵ݹ���������battingcat��һ�㡣 �����ϴε�bat��������batt���������У�batti�������У��ݹ����ȥ����ʣ�മ
	// ngcat��n��ng��ngc��ngca�����������У�
	// ngcat���������С��ݹ���ô���ʣ�മ�� ����ʣ�മΪ�գ������档

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
		} // �����Ǳ���word�����ĸ ������word�ĳ���
		for (int i = 0; i < word.length(); i++) {
			//����ص�ǰ��ε����ڴ��ַ������ҵ�,���Һ��εݹ���ú�Ҳ����󷵻�true �ͷ���true
			//���еĻ� ʲô�������� forѭ��������һ���ж� t  te tes test������
			if (findWord(a, word.substring(0, i + 1))
					&& isLongest(a, word.substring(i + 1))) {
				return true;
			}
		}
		return false;
	}
//�������� a���Ƿ���temp,��ʵ��hashtable Ԥ������ѯ����
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
