package ArrayandString;

public class Anagrams2_1_4 {

	public static void main(String[] args) {
		
		    String a ="abcadefg";
		    String b ="bacadefg";
			System.out.print(compare1(a,b));

	}
	public static boolean compare1(String s1, String s2){
	    boolean flag;  
		if(s1 == null && s2!=null)
			return flag=false;
			if(s1!=null && s2==null)
				return flag=false;
			if(s1==null && s2==null)
				return flag=false;
			if(s1.length()!=s2.length())
				return flag=false;
	    char[] ary1=s1.toCharArray();
	    char[] ary2=s2.toCharArray();
	    int[] acs2=new int[256];
	    // ��ʼ��acs2����  �����涼��0
	    for(int i=0;i<acs2.length;i++){
	    	acs2[i]=0;    		    }
	    
	    //ÿ��char��Ӧ��acsii�룬�����������±��
	    //   String �� char              a     f       m
	    //asc2����00000000000000000000000100000100000001
	    //�����2��a ��++2�� 00000000000002
	    for(int i=0;i<s1.length();i++){
	    	
	    		acs2[s1.charAt(i)]++;
	    		}
	    			 
	    //check if s2 is having these char and having the right amount of these chars 
		for(int i=0; i < s2.length(); i++){
			if(acs2[s2.charAt(i)] == 0)
			return false;
			else{
			acs2[s2.charAt(i)]--;// for example, if s1 has two "a" ,then acs2[a] should
			//be 2, but if s2 has three "a", it will return false in this loop
			}
			 
			}
			return true;
			}
			}