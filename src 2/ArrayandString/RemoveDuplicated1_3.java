package ArrayandString;

import java.util.Arrays;

import recursion.ReturnSubSets8_3;

public class RemoveDuplicated1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "avddvcvcvcbu1vvcvcccbcd";
		char[] a = s.toCharArray();
		removeDup(a);
		System.out.print(new String(a));
	}

	public static String remove(String s) {
		// ����������ǿ��� ȱ����� ���˶����String[]ռ�ռ�
		char[] ary = s.toCharArray();
		for (int i = 0; i < ary.length; i++) {
			for (int j = i + 1; j < ary.length; j++) {
				if (((ary[i])) == (ary[j])) {
					ary[j] = ' ';
				}
			}
		}
		String d = new String(ary);
		String[] sary = d.split(" ");
		String e = "";
		for (int i = 0; i < sary.length; i++) {
			e = e.concat(sary[i]);
		}

		return e;
	}

	// �ⷽ������ô�ö���ռ�
	// 3ָ�뷽��i=1 j=0 tail=1
	// �ڱȽϵĹ����� ��Զ�� j<=tail<=i
	// 0��tail�ǲ��ظ��� ȥ��ȥ�õ�����
	// ��Ϊj������ѭ�� ����ÿ�δ�ѭ��i��һ�� jҪ��0��tail��һ�� ����break
	// ��ʲô�����break�أ� ���� str[i]==str[j] ˵�����str[i]��ȥ���������char�ظ��� ������i����Ҫ
	// ֱ��������ѭ������++i
	// �����ȷ��ȥ������û�е� ˵����ȷ�ǿ��Լӽ��� ��ô�͵�j��ѭ����tail��ʱ��ӵ�tail��λ��
	// ��i<len��ʱ�򶼼������ �Ͱ�ʣ�µ� tail��len�������

	public static void removeDup(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		int tail = 1;
		for (int i = 1; i < len; i++) {
			int j;// Ϊ��Ҫ������ Ϊ�˷�ֹ if(j==tail)������
			for (j = 0; j < tail; j++) {
				System.err.print(j);
				if (str[i] == str[j])
					break;// break���������ѭ��
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		while (tail < len) {
			str[tail] = 0;
			tail++;
		}

	}

}
