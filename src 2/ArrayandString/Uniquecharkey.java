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
		 
		// boolean[] ��Ĭ��ֵ����false��������
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);// char תint, char��ASCII ����int����ʽ��ʾ
			// ͬ����char����ͬ����int
	//		System.out.println(val);
			if (char_set[val])
			// boolean[]���Ĭ��ֵ��false ����..һ��ʼ�������ִ�����if
			{
				return false;
			}
			// �����char��ASCII �룩��booleanֵ��Ϊtrue�ˣ�����string���������������ͬ�ַ�
			// �ͻ�ִ�����if (char_set[val]Ϊtrue)�� ���Ծ�return false;��������������
			char_set[val] = true;
		}
	//	System.out.print("1111");
		return true;// �����return false����ͬһ�������,����ǰ�����return false���˾�������ִ������ˡ�
	}

}
