package ArrayandString;

//Implement an algorithm to determine if a string has all unique characters. 
//What if you can not use additional data structures?


//���� �������Ǵ�� 
public class Uniquechar1_1 {
	//Ĭ����false ����ظ����true
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
				//== �Ǳȶ���equals �Ǳ�ֵ
				
				if (((Character) this.s.charAt(i)).equals(this.s.charAt(j))) {
					//�ѵ���ͬ�ľ�return�� ����û��Ҫ�ٱ�
					return flag=true;
					
				} 
				//���ﲻ����ôд ����ÿ���ַ�����ͬ�� ��ΪҪѭ����Σ�����Ϊstring���治��ÿ���ַ���һ��������һ����ͬ�ľͻ�return false ��ǰ��flagֵ�ĸǵ�
				//����else{return flag=false;}
			//���Բ�Ҫһ��ʼ��falseȻ���鵽�ԵĸĶ�
			}

		}
		return flag;

	}
}
