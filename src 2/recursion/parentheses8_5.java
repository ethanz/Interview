package recursion;

//parenthes(Բ����)
public class parentheses8_5 {

	// Implement an algorithm to print all valid
	// (e.g., properly opened and closed) combinations of n-pairs of
	// parentheses.
	// e.g. input: 3 (e.g., 3 pairs of parentheses)
	// output: ()()(), ()(()), (())(), ((())),(()())

	// ���� �Ȳ�̸���� �����Ŀ�Ļ����߼���ʲô��
	// ��Ȼ�ǡ����� �� ������ ��������ȣ�����������ֻ࣬�ܴ�ӡ����������֮��Ȼ
	// ���Ե� �ⷽ����������5��ʱ�� ����5���������͡�����
	// ���������ź������ŵ��߼��е㲻һ��
	// ��ֻҪ���л�û��������涨������ �Ϳ��Բ���
	// �ң�����������ң������Ѿ�����n������ô�ҵ��������ܳ���n

	// ����һ�����ڳ����У�ֻҪ���������ţ����Ǿͼ����������Ȼ��ݹ���á�
	// ���˳��ݹ�ʱ�����ʣ���������������ʣ��������������࣬���Ǿͽ������ż����������
	// ֱ�����ʣ��������ź������Ŷ�Ϊ0ʱ�����ɴ�ӡһ���������

	public static void printPar(int number) {
		char[] str = new char[number * 2];
		printpar(number, number, str, 0);
	}

	// ���Ҫ��ӡ������ //count��ʾstr�������±꣬�Ͼ�char�ô�������д������Ȼ����ô֪�����˼��������ţ�
	// ����һ�����ź�count+1��count +1��
	private static void printpar(int l, int r, char[] str, int count) {
		if (l < 0 || r < 0) { //������<0����<1  ����Ҫ�� l/r��0��ʱ�� ���������<1 ��return�� ����ôִ��(l == 0 && r == 0)����Ĵ�ӡ����أ�
			return;
		}// invalid number
		if (l == 0 && r == 0) {
			
			System.out.println(str);// ��Ϊ��ʼl r��һ����ģ����Ե�l r���ù�ʱ���ʾ��Գɹ������Դ�ӡ
		} else {
			if (l > 0) {
				str[count] = '(';
				printpar(l - 1, r, str, count + 1);
			}
			if (r > l) {// �����ʱr>l, ˵��str��'('�õı�')'�࣬���Կ�����')'
				str[count] = ')';
				printpar(l, r - 1, str, count + 1);

			}
		}

	}
//������������������ �ݹ���ú����践�ض������ϲ� ֻ�����ϲ�ɰ��Ʒstrһ���ݹ���ô�����ȥ��ֱ������l==r==0 ���Ŷ����� �ʹ�ӡ
	public static void main(String[] args) {
		printPar(3);

	}

}
