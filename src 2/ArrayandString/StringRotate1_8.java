package ArrayandString;
//����������Ǽ�� string�ǲ���rotation. eg��cat rotation֮����� atc
//apple rotation֮�����pleap( ple ap)��ĳ���ַ���ʼ��������˳��� ����ppale�Ͳ���rotation
//Ȼ������һ���ֳɵ�isstring ����ȥ�����ǲ���ĳ��sting��substring
public class StringRotate1_8 {

	//check s2 �ǲ���s1��rotation
public static boolean isRotate	(String s1,String s2){
	//check legit
	if(s1.length()==s2.length()||s1.length()>0&&s2.length()>0){
		
		String s1s1 = s1 + s1;  
	//eg: apple+apple =appleapple �������s2��s1��rotation����ô�϶���2��s1��substring	
		
		return isSubstring(s1s1, s2);//return������ ��������Ͳ�ִ����
	}
	
	
	return false;
	
	
	
	
	
}	
	
	private static boolean isSubstring(String s1,String s2){
		//this is suppose to given
	return true;
	}
}
